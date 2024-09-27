# Spring Boot Actuator Endpoints

Spring Boot Actuator provides <b>production-ready features</b> that help you <b>monitor and manage your application</b>. It comes with several built-in endpoints that allow you to interact with the running application.

### Enable All Endpoints

To enable all Actuator endpoints, add the following property:

```properties
management.endpoints.web.exposure.include=*
```
### Enable Specific Endpoints

If you want to enable only specific Actuator endpoints, provide a comma-separated list of the endpoint IDs

```properties
management.endpoints.web.exposure.include=health,info,beans,env
```

## 1. **`/actuator`**
 ```json
  {
  "_links": {
    "self": {
      "href": "http://localhost:8081/actuator",
      "templated": false
    },
    "beans": {
      "href": "http://localhost:8081/actuator/beans",
      "templated": false
    },
    "caches-cache": {
      "href": "http://localhost:8081/actuator/caches/{cache}",
      "templated": true
    },
    "caches": {
      "href": "http://localhost:8081/actuator/caches",
      "templated": false
    },
    "health-path": {
      "href": "http://localhost:8081/actuator/health/{*path}",
      "templated": true
    },
    "health": {
      "href": "http://localhost:8081/actuator/health",
      "templated": false
    },
    "info": {
      "href": "http://localhost:8081/actuator/info",
      "templated": false
    },
    "conditions": {
      "href": "http://localhost:8081/actuator/conditions",
      "templated": false
    },
    "configprops": {
      "href": "http://localhost:8081/actuator/configprops",
      "templated": false
    },
    "configprops-prefix": {
      "href": "http://localhost:8081/actuator/configprops/{prefix}",
      "templated": true
    },
    "env": {
      "href": "http://localhost:8081/actuator/env",
      "templated": false
    },
    "env-toMatch": {
      "href": "http://localhost:8081/actuator/env/{toMatch}",
      "templated": true
    },
    "loggers": {
      "href": "http://localhost:8081/actuator/loggers",
      "templated": false
    },
    "loggers-name": {
      "href": "http://localhost:8081/actuator/loggers/{name}",
      "templated": true
    },
    "heapdump": {
      "href": "http://localhost:8081/actuator/heapdump",
      "templated": false
    },
    "threaddump": {
      "href": "http://localhost:8081/actuator/threaddump",
      "templated": false
    },
    "metrics": {
      "href": "http://localhost:8081/actuator/metrics",
      "templated": false
    },
    "metrics-requiredMetricName": {
      "href": "http://localhost:8081/actuator/metrics/{requiredMetricName}",
      "templated": true
    },
    "scheduledtasks": {
      "href": "http://localhost:8081/actuator/scheduledtasks",
      "templated": false
    },
    "mappings": {
      "href": "http://localhost:8081/actuator/mappings",
      "templated": false
    }
  }
}
  ```



## 1. **`/actuator/health`**
- **Description**: Provides application health information.
- **Usage**: This endpoint is useful for checking the application's health status. It aggregates health indicators like database connections, disk space, and other custom indicators.
- **Response Example**:
  ```json
  {
    "status": "UP",
    "components": {
      "db": {
        "status": "UP",
        "details": {
          "database": "PostgreSQL",
          "validationQuery": "isValid()"
        }
      },
      "diskSpace": {
        "status": "UP",
        "details": {
          "total": 499963174912,
          "free": 123456789012,
          "threshold": 10485760,
          "exists": true
        }
      },
      "ping": {
            "status": "UP"
       }
    }
  }
  ```

## 2. **`/actuator/info`**
- **Description**: Displays arbitrary application information.
- **Usage**: This endpoint is typically used to expose information like build version, description, and custom properties.
- **Response Example**:
  ```json
  {
    "app": {
      "name": "My Application",
      "version": "1.0.0",
      "description": "Sample Spring Boot Application"
    }
  }
  ```

## 3. **`/actuator/metrics`**
- **Description**: Provides metrics data about the current state of the application.
- **Usage**: Use this endpoint to monitor various metrics like memory usage, garbage collection, and HTTP request statistics.
- **Response Example**:
  ```json
  {
    "names": [
        "application.ready.time",
        "application.started.time",
        "disk.free",
        "disk.total",
        "executor.active",
        "executor.completed",
        "executor.pool.core",
        "executor.pool.max",
        "executor.pool.size",
        "executor.queue.remaining",
        "executor.queued",
        "hikaricp.connections",
        "hikaricp.connections.acquire",
        "hikaricp.connections.active",
        "hikaricp.connections.creation",
        "hikaricp.connections.idle",
        "hikaricp.connections.max",
        "hikaricp.connections.min",
        "hikaricp.connections.pending",
        "hikaricp.connections.timeout",
        "hikaricp.connections.usage",
        "http.server.requests",
        "jdbc.connections.max",
        "jdbc.connections.min",
        "jvm.buffer.count",
        "jvm.buffer.memory.used",
        "jvm.buffer.total.capacity",
        "jvm.classes.loaded",
        "jvm.classes.unloaded",
        "jvm.gc.live.data.size",
        "jvm.gc.max.data.size",
        "jvm.gc.memory.allocated",
        "jvm.gc.memory.promoted",
        "jvm.gc.overhead",
        "jvm.gc.pause",
        "jvm.memory.committed",
        "jvm.memory.max",
        "jvm.memory.usage.after.gc",
        "jvm.memory.used",
        "jvm.threads.daemon",
        "jvm.threads.live",
        "jvm.threads.peak",
        "jvm.threads.states",
        "logback.events",
        "process.cpu.usage",
        "process.start.time",
        "process.uptime",
        "spring.data.repository.invocations",
        "system.cpu.count",
        "system.cpu.usage",
        "tomcat.sessions.active.current",
        "tomcat.sessions.active.max",
        "tomcat.sessions.alive.max",
        "tomcat.sessions.created",
        "tomcat.sessions.expired",
        "tomcat.sessions.rejected"
    ]
  }
  ```

- **Query Specific Metric**: You can query a specific metric like `jvm.memory.used`:
    - **Endpoint**: `/actuator/metrics/jvm.memory.used`
    - **Response Example**:
      ```json
      {
        "name": "jvm.memory.used",
        "description": "Amount of memory that the Java virtual machine (JVM) is using.",
        "baseUnit": "bytes",
        "measurements": [
          {
            "statistic": "VALUE",
            "value": 12345678
          }
        ],
        "availableTags": [
          {
            "tag": "area",
            "values": [
              "heap",
              "nonheap"
            ]
          }
        ]
      }
      ```

## 4. **`/actuator/env`**
- **Description**: Exposes properties from the Spring `Environment`.
- **Usage**: Use this endpoint to view the configuration properties of the application, including system properties, environment variables, and custom application properties.
- **Response Example**:
  ```json
  {
    "activeProfiles": [],
    "propertySources": [
      {
        "name": "systemProperties",
        "properties": {
          "java.version": {
            "value": "1.8.0_202"
          },
          "user.timezone": {
            "value": "UTC"
          }
        }
      },
     "..."
    ]
  }
  ```

## 5. **`/actuator/beans`**
- **Description**: Displays a list of all Spring Beans in your application context.
- **Usage**: This endpoint is useful for debugging and understanding the beans that are currently loaded in the Spring ApplicationContext.
- **Response Example**:
  ```json
  {
    "contexts": {
      "application": {
        "beans": {
          "myService": {
            "type": "com.example.MyService",
            "scope": "singleton",
            "dependencies": []
          },
          "myController": {
            "type": "com.example.MyController",
            "scope": "singleton",
            "dependencies": [
              "myService"
            ]
          }
        }
      }
    }
  }
  ```

## 6. **`/actuator/mappings`**
- **Description**: Displays a list of all `@RequestMapping` paths.
- **Usage**: This endpoint is useful for understanding all the available HTTP endpoints in your application and their respective mappings.
- **Response Example**:
  ```json
  {
    "contexts": {
      "application": {
        "mappings": {
          "dispatcherServlets": {
            "dispatcherServlet": [
              {
                "handler": "public com.example.MyController.myMethod()",
                "predicate": "{GET /api/example}"
              },
              {
                "handler": "public com.example.MyController.anotherMethod()",
                "predicate": "{POST /api/example}"
              }
            ]
          }
        }
      }
    }
  }
  ```

## 7. **`/actuator/loggers`**
- **Description**: Displays and modifies the logging levels of loggers in the application.
- **Usage**: This endpoint is useful for dynamically changing log levels without restarting the application.
- **Response Example**:
  ```json
  {
    "levels": [
      "OFF",
      "ERROR",
      "WARN",
      "INFO",
      "DEBUG",
      "TRACE"
    ],
    "loggers": {
      "com.example": {
        "configuredLevel": "INFO",
        "effectiveLevel": "INFO"
      }
    }
  }
  ```

- **Change Log Level**: You can change the log level of a logger:
    - **Method**: `POST`
    - **Endpoint**: `/actuator/loggers/com.example`
    - **Request Body**:
      ```json
      {
        "configuredLevel": "DEBUG"
      }
      ```

---

This `actuator.md` file should give you a solid overview of some of the most important Spring Boot Actuator endpoints and how to use them. You can customize it further according to your specific application needs.
