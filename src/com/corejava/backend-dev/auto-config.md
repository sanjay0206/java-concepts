
# Spring Boot Auto Configuration Guide

Spring Boot offers powerful auto-configuration features to reduce boilerplate and help you get started quickly.

---

## ? Core Auto-Configurations

| Feature                  | Auto-configured? | Notes                                                  |
|--------------------------|------------------|--------------------------------------------------------|
| **DispatcherServlet**    | ? Yes           | Automatically registered and mapped to `/`            |
| **Embedded Servlet Containers** | ? Yes    | Tomcat (default), Jetty, Undertow                      |
| **Jackson (JSON)**       | ? Yes           | Auto-configures `ObjectMapper`, used in REST          |
| **Message Converters**   | ? Yes           | Converts JSON/XML automatically                        |
| **Multipart File Upload**| ? Yes           | Enabled if `multipart.enabled=true`                   |
| **Error Handling**       | ? Yes           | `/error` endpoint with default error pages            |

---

## ? Web Layer

| Feature                  | Auto-configured? | Notes                                                  |
|--------------------------|------------------|--------------------------------------------------------|
| **Spring MVC (Web)**     | ? Yes           | With `spring-boot-starter-web`                         |
| **Static Resource Handling** | ? Yes       | From `resources/static`, `public`, `META-INF/resources` |
| **View Resolvers**       | ? Yes           | Thymeleaf, FreeMarker, Mustache, etc.                  |
| **CORS Configuration**   | ? No            | Must configure via `WebMvcConfigurer`                  |
| **Interceptors**         | ? No            | Register manually in `WebMvcConfigurer`                |
| **Filters**              | ? Yes           | Auto-registered if annotated with `@Component`         |
| **Servlets / Listeners** | ? Yes           | With annotations or bean registration                  |

---

## ?? Security

| Feature                  | Auto-configured? | Notes                                                  |
|--------------------------|------------------|--------------------------------------------------------|
| **Spring Security**      | ? Yes           | If `spring-boot-starter-security` is in classpath      |
| **Default login page**   | ? Yes           | Basic login form is enabled by default                 |
| **CSRF Protection**      | ? Yes           | Enabled by default                                     |
| **Password encoding**    | ? Yes           | Uses `DelegatingPasswordEncoder`                       |

---

## ?? Data Access

| Feature                  | Auto-configured? | Notes                                                  |
|--------------------------|------------------|--------------------------------------------------------|
| **Spring Data JPA**      | ? Yes           | With JPA and relevant starter                          |
| **DataSource**           | ? Yes           | Auto-configured with DB URL                            |
| **EntityManagerFactory** | ? Yes           | Enabled for JPA                                        |
| **Transaction Manager**  | ? Yes           | For transactional support                              |
| **Spring Data Repositories** | ? Yes       | Detected via `@Repository`                             |
| **H2 Console**           | ? Yes           | Enable with `spring.h2.console.enabled=true`           |

---

## ? Other Integrations

| Feature                  | Auto-configured? | Notes                                                  |
|--------------------------|------------------|--------------------------------------------------------|
| **Actuator Endpoints**   | ? Yes           | With `spring-boot-starter-actuator`                    |
| **Health Checks**        | ? Yes           | Basic health indicators                                |
| **Metrics & Monitoring** | ? Yes           | Uses Micrometer                                        |
| **DevTools**             | ? Yes           | For hot reloads in dev                                 |
| **Spring Boot CLI**      | ? Yes           | Optional, for Groovy-based apps                        |

---

## ? How Does It Work?

Spring Boot auto-configuration is powered by the `@EnableAutoConfiguration` annotation, which is included in:

```
@SpringBootApplication = @Configuration + @EnableAutoConfiguration + @ComponentScan
```

It loads configuration classes listed in:

- `META-INF/spring.factories` (Spring Boot 2.x)
- `META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports` (Spring Boot 3.x)

Auto-config is applied based on conditions:

- `@ConditionalOnClass`
- `@ConditionalOnMissingBean`
- `@ConditionalOnProperty`

---

## ? Summary

| Component Type         | Auto-configured? | Manual Setup Required?           |
|------------------------|------------------|----------------------------------|
| Filters                | ? Yes           | ? No (unless custom)            |
| Interceptors           | ? No            | ? Yes (via WebMvcConfigurer)    |
| DispatcherServlet      | ? Yes           | ? No                             |
| Security               | ? Yes           | ? No (basic security included)  |
| Data Layer             | ? Yes           | ? No                             |

---
