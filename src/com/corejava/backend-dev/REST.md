# Employee Client

This document provides a simple implementation of an `EmployeeClient` in Java using two different approaches: `RestTemplate` and `WebClient`. Both implementations handle CRUD operations for employee data in a RESTful API.

## Table of Contents
- [RestTemplate Implementation](#resttemplate-implementation)
- [WebClient Implementation](#webclient-implementation)

## RestTemplate Implementation
Definition:
RestTemplate is a synchronous client provided by Spring for making HTTP requests to RESTful web services. It simplifies the interaction with APIs by providing methods for common HTTP methods like GET, POST, PUT, and DELETE.

Use:
RestTemplate is used for making synchronous calls, which means the thread waits for the response from the server before proceeding. It's suitable for simple applications where blocking behavior is acceptable.
The following code demonstrates how to use `RestTemplate` to perform CRUD operations on an employee resource.

```java
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class EmployeeClient {

    private final RestTemplate restTemplate;
    private final String baseUrl = "http://example.com/api/employees";
    private final String token = "your_bearer_token";

    public EmployeeClient() {
        this.restTemplate = new RestTemplate();
    }

    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        headers.set("Content-Type", "application/json");
        return headers;
    }

    public ResponseEntity<String> getEmployee(int id) {
        HttpHeaders headers = createHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(baseUrl + "/" + id, HttpMethod.GET, entity, String.class);
    }

    public ResponseEntity<String> createEmployee(String employeeJson) {
        HttpHeaders headers = createHeaders();
        HttpEntity<String> entity = new HttpEntity<>(employeeJson, headers);

        return restTemplate.exchange(baseUrl, HttpMethod.POST, entity, String.class);
    }

    public ResponseEntity<String> updateEmployee(int id, String employeeJson) {
        HttpHeaders headers = createHeaders();
        HttpEntity<String> entity = new HttpEntity<>(employeeJson, headers);

        return restTemplate.exchange(baseUrl + "/" + id, HttpMethod.PUT, entity, String.class);
    }

    public ResponseEntity<String> deleteEmployee(int id) {
        HttpHeaders headers = createHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(baseUrl + "/" + id, HttpMethod.DELETE, entity, String.class);
    }

    public static void main(String[] args) {
        EmployeeClient client = new EmployeeClient();

        // GET example
        ResponseEntity<String> getResponse = client.getEmployee(1);
        System.out.println("GET Response: " + getResponse.getBody());

        // POST example
        String newEmployeeJson = "{\"name\":\"John Doe\",\"position\":\"Developer\"}";
        ResponseEntity<String> postResponse = client.createEmployee(newEmployeeJson);
        System.out.println("POST Response: " + postResponse.getBody());

        // PUT example
        String updateEmployeeJson = "{\"name\":\"John Doe\",\"position\":\"Senior Developer\"}";
        ResponseEntity<String> putResponse = client.updateEmployee(1, updateEmployeeJson);
        System.out.println("PUT Response: " + putResponse.getBody());

        // DELETE example
        ResponseEntity<String> deleteResponse = client.deleteEmployee(1);
        System.out.println("DELETE Response: " + deleteResponse.getBody());
    }
}
```

## WebClient Implementation
Definition:
WebClient is a non-blocking, reactive web client provided by Spring WebFlux. It is designed for making asynchronous HTTP requests, allowing for more efficient handling of I/O-bound operations.

Use:
WebClient is used when you need to perform non-blocking calls, making it suitable for applications that require scalability and can handle multiple concurrent requests without blocking the thread.
The following code demonstrates how to use `WebClient` to perform CRUD operations on an employee resource.

```java
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class EmployeeClient {

    private final WebClient webClient;
    private final String baseUrl = "http://example.com/api/employees";
    private final String token = "your_bearer_token";

    public EmployeeClient() {
        this.webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                .build();
    }

    public Mono<String> getEmployee(int id) {
        return webClient.get()
                .uri("/{id}", id)
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<String> createEmployee(String employeeJson) {
        return webClient.post()
                .bodyValue(employeeJson)
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<String> updateEmployee(int id, String employeeJson) {
        return webClient.put()
                .uri("/{id}", id)
                .bodyValue(employeeJson)
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<String> deleteEmployee(int id) {
        return webClient.delete()
                .uri("/{id}", id)
                .retrieve()
                .bodyToMono(String.class);
    }

    public static void main(String[] args) {
        EmployeeClient client = new EmployeeClient();

        // GET example
        client.getEmployee(1)
                .doOnNext(response -> System.out.println("GET Response: " + response))
                .block();

        // POST example
        String newEmployeeJson = "{\"name\":\"John Doe\",\"position\":\"Developer\"}";
        client.createEmployee(newEmployeeJson)
                .doOnNext(response -> System.out.println("POST Response: " + response))
                .block();

        // PUT example
        String updateEmployeeJson = "{\"name\":\"John Doe\",\"position\":\"Senior Developer\"}";
        client.updateEmployee(1, updateEmployeeJson)
                .doOnNext(response -> System.out.println("PUT Response: " + response))
                .block();

        // DELETE example
        client.deleteEmployee(1)
                .doOnNext(response -> System.out.println("DELETE Response: " + response))
                .block();
    }
}
```