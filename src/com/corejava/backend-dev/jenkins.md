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
def projectId = params.projectId
def version = params.version
def branchName = params.branchName
def projectName = params.projectName

def initialize() {
    def parameters = [
        projectId: projectId,
        branchName: branchName,
        version: version,
        projectName: projectName
    ]
    echo "Initializing project with parameters: ${parameters}"
    return projectName
}

def dockerRun(containerName, imageName) {
    sh "docker stop ${containerName} || true"
    sh "docker rm ${containerName} || true"
    sh "docker run -d --name ${containerName} -p 8080:8080 ${imageName}"
}

def sendNotification(status) {
    def subject = "${status.toUpperCase()}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
    def body = status == "SUCCESS" ? 
        "Good news! The build and deployment of ${env.JOB_NAME} #${env.BUILD_NUMBER} was successful." : 
        "Unfortunately, the build and deployment of ${env.JOB_NAME} #${env.BUILD_NUMBER} failed. Please check the Jenkins console output for more details."
    
    mail to: 'team@example.com', subject: subject, body: body
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
        stage('Initialize') {
            steps {
                script {
                    env.PROJECT_NAME = initialize()
                }
            }
        }
        
        stage('Checkout') {
            steps {
                // Checkout code from version control
                git url: 'https://github.com/your-repo/your-spring-boot-project.git', branch: branchName
            }
        }

        stage('Build') {
            steps {
                // Build the Spring Boot application using Maven
                sh "${MAVEN_HOME}/bin/mvn clean package"
            }
        }

        stage('Test') {
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

        stage('Static Code Analysis') {
            steps {
                // Perform static code analysis using SonarQube (example)
                withSonarQubeEnv('SonarQube') {
                    sh "${MAVEN_HOME}/bin/mvn sonar:sonar"
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', 'dockerhub-credentials') {
                        def dockerImage = docker.build("your-docker-repo/your-spring-boot-app:${env.BUILD_NUMBER}")
                        dockerImage.push("${env.BUILD_NUMBER}")
                        dockerImage.push("latest")
                    }
                }
            }
        }

        stage('Deploy to Development') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', 'dockerhub-credentials') {
                        dockerRun('spring-boot-app-dev', "your-docker-repo/your-spring-boot-app:${env.BUILD_NUMBER}")
                    }
                }
            }
        }

        stage('Deploy to UAT') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', 'dockerhub-credentials') {
                        dockerRun('spring-boot-app-uat', "your-docker-repo/your-spring-boot-app:${env.BUILD_NUMBER}")
                    }
                }
            }
        }

        stage('Deploy to Production') {
            steps {
                input message: 'Deploy to Production?', ok: 'Deploy'
                script {
                    docker.withRegistry('https://index.docker.io/v1/', 'dockerhub-credentials') {
                        dockerRun('spring-boot-app-prod', "your-docker-repo/your-spring-boot-app:${env.BUILD_NUMBER}")
                    }
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
