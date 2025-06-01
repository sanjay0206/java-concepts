# Optional.of vs Optional.ofNullable

In Java, `Optional.of` and `Optional.ofNullable` are both factory methods used to create instances of the `Optional` class. However, they behave differently depending on the provided value.

## Optional.of(value)

- Used when you are certain that the provided value is not null.
- If the provided value is null, it throws a `NullPointerException`.
- Useful when you are confident that the value you are wrapping will not be null.

**Example:**
```java
String value = "Hello";
Optional<String> optional = Optional.of(value);
```

## Optional.ofNullable(value)
- Used when the provided value could be either non-null or null.
- If the provided value is null, it returns an empty Optional.
- If the provided value is non-null, it wraps the value inside an Optional.
- Useful when you are unsure if the value you are wrapping might be null.

**Example:**
```java
String value = null;
Optional<String> optional = Optional.ofNullable(value);
```

#### In summary, Optional.of should be used when you are sure that the value will not be null, while Optional.ofNullable should be used when the value might be null. Using Optional.ofNullable allows you to handle both cases gracefully without risking a NullPointerException.