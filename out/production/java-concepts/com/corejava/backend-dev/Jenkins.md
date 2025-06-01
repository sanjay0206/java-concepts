# Jenkins Pipeline for Spring Boot Application

## Overview

This document provides an example Jenkins pipeline script for building, testing, and deploying a Spring Boot application. The pipeline includes stages for checking out code from version control, building the application, running tests, performing static code analysis, building a Docker image, and deploying to development, UAT, and production environments.

## Jenkins

Jenkins is an open-source automation server that helps automate parts of the software development process, including building, testing, and deploying code. It is widely used for continuous integration (CI) and continuous delivery (CD) practices. Jenkins supports a wide range of plugins to integrate with various tools and technologies used in the software development lifecycle.

### Key Uses of Jenkins

- **Continuous Integration**: Automatically build and test code every time changes are committed to version control.
- **Continuous Delivery/Deployment**: Automate the process of deploying applications to different environments, such as development, staging, and production.
- **Automation**: Automate repetitive tasks such as running scripts, managing configurations, and deploying updates.
- **Monitoring**: Monitor the health and status of builds and deployments, and provide real-time feedback to developers.

## Pipeline Script

```groovy
def Stages = [
    CHECKOUT: 'Checkout SCM',
    COMPILE: 'Compile',
    TEST: 'Run Tests',
    STATIC_ANALYSIS: 'Static Code Analysis',
    BUILD_DOCKER: 'Build Docker Image',
    DEPLOY_DEV: 'Deploy to Development',
    DEPLOY_UAT: 'Deploy to UAT',
    DEPLOY_PROD: 'Deploy to Production'
]

def sendNotification(status) {
    def subject = "${status.toUpperCase()}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
    def body = status == "SUCCESS" ? 
        "Good news! The build and deployment of ${env.JOB_NAME} #${env.BUILD_NUMBER} was successful." : 
        "Unfortunately, the build and deployment of ${env.JOB_NAME} #${env.BUILD_NUMBER} failed. Please check the Jenkins console output for more details."
    
    mail to: "${env.MAIL_GROUP}", subject: subject, body: body
}

def dockerRun(containerName, imageName) {
    sh "docker stop ${containerName} || true"
    sh "docker rm ${containerName} || true"
    sh "docker run -d --name ${containerName} -p 8080:8080 ${imageName}"
}

pipeline {
    agent any
    
    tools {
        maven 'Maven3' // Use the name of your Maven installation configured in Jenkins
        jdk 'JavaJDK' // Use the name of your JDK installation configured in Jenkins
    }

    environment {
        MAVEN_HOME = tool 'Maven3' // This will dynamically set the path to the Maven tool
        JAVA_HOME = tool 'JavaJDK' // This will dynamically set the path to the JDK tool
    }

    stages {
        stage(Stages.CHECKOUT) {
            steps {
                // Checkout code from version control
                git url: "${env.GIT_URL}", branch: "${env.BRANCH_NAME}"
            }
        }

        stage(Stages.COMPILE) {
            steps {
                // Build the Spring Boot application using Maven
                sh "${MAVEN_HOME}/bin/mvn clean compile"
            }
        }

        stage(Stages.TEST) {
            steps {
                // Run unit tests
                sh "${MAVEN_HOME}/bin/mvn test"
            }
            post {
                always {
                    // Archive test results
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage(Stages.STATIC_ANALYSIS) {
            steps {
                // Perform static code analysis using SonarQube (example)
                withSonarQubeEnv('SonarQube') {
                    sh "${MAVEN_HOME}/bin/mvn verify sonar:sonar"
                }
            }
        }

        stage(Stages.BUILD_DOCKER) {
            steps {
                script {          
                    withCredentials([string(credentialsId: 'DOCKERHUB_PWD', variable: 'DOCKERHUB_PASSWORD')]) {
					    sh "docker login -u ${env.DOCKER_USERNAME} -p $DOCKERHUB_PASSWORD"
					}
                    sh "docker push ${env.DOCKER_USERNAME}/devops-integration"
                }
            }
        }

        stage(Stages.DEPLOY_DEV) {
            steps {
                script {
                     withCredentials([string(credentialsId: 'DOCKERHUB_PWD', variable: 'DOCKERHUB_PASSWORD')]) {
					    sh "docker login -u ${env.DOCKER_USERNAME} -p $DOCKERHUB_PASSWORD"
					 }
					 dockerRun('devops-integration-dev', "${env.DOCKER_USERNAME}/devops-integration:${env.BUILD_NUMBER}")
                }
            }
        }

        stage(Stages.DEPLOY_UAT) {
            steps {
                script {
                      withCredentials([string(credentialsId: 'DOCKERHUB_PWD', variable: 'DOCKERHUB_PASSWORD')]) {
					     sh "docker login -u ${env.DOCKER_USERNAME} -p $DOCKERHUB_PASSWORD"					 
					  }
					  dockerRun('devops-integration-uat', "${env.DOCKER_USERNAME}/devops-integration:${env.BUILD_NUMBER}")
                }
            }
        }

        stage(Stages.DEPLOY_PROD) {
            steps {
                input message: 'Deploy to Production?', ok: 'Deploy'
                script {
                    withCredentials([string(credentialsId: 'DOCKERHUB_PWD', variable: 'DOCKERHUB_PASSWORD')]) {
					    sh "docker login -u ${env.DOCKER_USERNAME} -p $DOCKERHUB_PASSWORD"
					}
					dockerRun('devops-integration-prod', "${env.DOCKER_USERNAME}/devops-integration:${env.BUILD_NUMBER}")
                }
            }
        }
    }

    post {
        always {
            // Clean up workspace after the build
            cleanWs()
        }
        success {
            sendNotification("SUCCESS")
        }
        failure {
            sendNotification("FAILURE")
        }
    }
}