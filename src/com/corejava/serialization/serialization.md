# Serialization

Serialization is the process of converting a Java object into a stream of bytes to **store** or **transmit** it. Deserialization is the reverse process—**reconstructing** the object from its byte stream.

<img src="what-is-serialization-in-java.webp" alt="Serialization" width="600" height="500">

---

## ? Why Use Serialization?

- **Data Persistence**: Save Java objects to a database or file.
- **Session Management**: Retain user state across HTTP requests.
- **Caching**: Store frequently used data temporarily (e.g., in Redis).
- **Remote Calls (RMI)**: Send objects across JVMs.
- **Web Services**: Send/receive JSON or XML payloads via REST APIs.

---

## ? Classes Involved in Java Serialization

| Purpose                    | Class/Interface              |
|---------------------------|------------------------------|
| Marker Interface          | `java.io.Serializable`       |
| Writing Object to Stream  | `ObjectOutputStream`         |
| Reading Object from Stream| `ObjectInputStream`          |

---

## ? What is `serialVersionUID`?

- A unique version ID used during **deserialization**.
- Ensures that the class used during deserialization matches the version of the serialized object.

```java
private static final long serialVersionUID = 1L;
```

### ? What Happens If Not Given?

- JVM auto-generates it based on class structure.
- If class changes (e.g., new fields), the UID changes.
- Causes `InvalidClassException` when deserializing old data with the new class.

? **Best Practice**: Always define `serialVersionUID` manually.

---

## ? `transient` Keyword

- Marks a field to be **excluded** from serialization.

```java
public class User implements Serializable {
    private String username;
    private transient String password; // This won't be serialized
}
```

- Jackson and Java serialization both ignore `transient` fields.

---

## ? Serialization in Spring Boot

Spring Boot heavily uses serialization for:

---

### 1. ? Jackson (JSON Serialization)

Spring Boot uses **Jackson** to automatically serialize and deserialize Java objects in REST APIs.

| Annotation        | Description                                      |
|------------------|--------------------------------------------------|
| `@JsonProperty`  | Rename fields in JSON                            |
| `@JsonIgnore`    | Skip a field during serialization                |
| `@JsonInclude`   | Include non-null or non-default fields only      |
| `@JsonFormat`    | Define date/time formats                         |
| `@JsonCreator`   | Use constructor/factory for deserialization      |

> Jackson also ignores `transient` fields by default.

---

### 2. ? RedisTemplate (for Redis Caching)

Spring Boot uses `RedisTemplate` for storing Java objects in Redis.

| Component                  | Class Name                          |
|---------------------------|--------------------------------------|
| Redis Client              | `RedisTemplate<String, Object>`     |
| JSON Serializer for Redis | `Jackson2JsonRedisSerializer`       |
| Key Serializer            | `StringRedisSerializer`             |

To serialize objects into Redis as JSON:

```java
RedisTemplate<String, Object> template;
Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<>(Object.class);
template.setDefaultSerializer(serializer);
```

---

### ? Spring Boot Serialization Use Cases with Responsible Classes

| Use Case                          | Description                                                                 | Responsible Class / Component                          | Default Serializer Class / Mechanism                          |
|-----------------------------------|-----------------------------------------------------------------------------|---------------------------------------------------------|---------------------------------------------------------------|
| **REST API Input/Output**         | Jackson automatically serializes responses and deserializes requests.      | `ObjectMapper`, `@RestController`, `@RequestBody`, `@ResponseBody` | `com.fasterxml.jackson.databind.ObjectMapper`                 |
| **Session Storage (Spring Session)** | Stores session objects (which must be serializable) in Redis or a database.| `RedisOperationsSessionRepository`, `JdbcOperationsSessionRepository` | Typically Java serialization (`java.io.Serializable`) or configured serializers like `JdkSerializationRedisSerializer` |
| **Caching (Spring Cache + Redis)** | Serializes Java objects to JSON or binary before storing in Redis.         | `RedisCacheManager`, `RedisTemplate`, `Jackson2JsonRedisSerializer` | `JdkSerializationRedisSerializer` by default, or `Jackson2JsonRedisSerializer` if configured |
| **Messaging (Kafka/RabbitMQ)**    | Serializes Java objects into JSON or byte arrays for messaging.            | `KafkaTemplate`, `RabbitTemplate`, `Jackson2JsonMessageConverter` | `StringSerializer`, `ByteArraySerializer`, or `Jackson2JsonMessageConverter` |
| **Object Mapping (DTOs)**         | Transfers data between layers or services in serialized format.            | `ObjectMapper`, DTO classes with Jackson annotations    | `com.fasterxml.jackson.databind.ObjectMapper`                 |

---

# Where Is Serialized Data Stored?

| Context                             | Where Serialized Data Is Stored or Sent                          |
|-----------------------------------|------------------------------------------------------------------|
| **Plain Java Serialization**      | Usually stored as a **file** on disk or sent over a network stream (e.g., sockets) |
| **Jackson Serialization (Spring Boot REST APIs)** | Converted into **JSON string** and sent as **HTTP response body** or received in **HTTP request body** (in-memory, transient during request lifecycle) |
| **Redis Serialization (Spring Boot RedisTemplate)** | Serialized as **byte arrays or JSON strings** and stored **inside Redis in-memory data store** (not file, but in-memory key-value storage) |

---

## Explanation

- **Plain Java Serialization**  
  Using `ObjectOutputStream`, the serialized bytes are typically written to a file or sent over a network socket.

- **Jackson Serialization**  
  Jackson converts Java objects to JSON strings **in memory**. In Spring Boot REST APIs, this JSON is the HTTP response payload sent to the client (browser, another service, etc.).

- **Redis Serialization**  
  Using `RedisTemplate` with serializers like `Jackson2JsonRedisSerializer`, the object is converted to JSON (or binary) and stored **inside Redis**, which is an in-memory key-value store (not a file system).

---

## Summary

| Usage                                | Storage Location            |
|-------------------------------------|----------------------------|
| Java Serialization (`ObjectOutputStream`) | File or network stream      |
| Jackson Serialization (REST API)         | HTTP message body (memory)  |
| RedisTemplate Serialization               | Redis in-memory store       |
