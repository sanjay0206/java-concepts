# ConcurrentModificationException in Java

## Overview

`ConcurrentModificationException` is a runtime exception in Java that occurs when a collection is modified while it is being iterated over, and the modification is not allowed.

### Fail-Fast Iterators
Fail-fast iterators detect structural modifications to the collection during iteration and immediately throw `ConcurrentModificationException`. This behavior is common in most standard collections in Java.

### Fail-Safe Iterators
Fail-safe iterators work on a snapshot of the collection and allow modifications without throwing exceptions. This behavior is typical of concurrent collections designed for multithreaded environments.

## Understanding `modCount` in Java Collections

### What is `modCount`?

`modCount` is an internal field used by Java's collection classes to keep track of the number of structural modifications made to a collection. Structural modifications are changes that alter the size or structure of the collection, such as adding or removing elements.

### How `modCount` Works

1. **Modification Tracking**:
    - When a structural modification occurs (e.g., `add()`, `remove()`), the `modCount` is incremented.
    - Each iterator maintains a snapshot of the `modCount` when it is created.

2. **Consistency Check During Iteration**:
    - During iteration, the iterator compares the current `modCount` of the collection with its snapshot.
    - If the values differ, indicating that the collection has been modified, a `ConcurrentModificationException` is thrown.

## Common Case
### Modifying a Collection During Iteration
**Scenario**: You are iterating over a collection and modify it (e.g., adding or removing elements) during the iteration.

**Problematic Code:**
```java
List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E"));
for (String item : list) {
    if (item.equals("C")) {
        list.remove(item); // ConcurrentModificationException
    }
}
```
**Solution**: Using Iterator.remove() or CopyOnWriteArrayList
```java
// Option 1: Using Iterator.remove()
Iterator<String> iterator = list.iterator();
while (iterator.hasNext()) {
        iterator.next();
    iterator.remove(); // Safely remove the element
}

// Option 2: Using CopyOnWriteArrayList
List<String> list = new CopyOnWriteArrayList<>(Arrays.asList("A", "B", "C", "D", "E"));
for (String item : list) {
        list.remove(item); // No ConcurrentModificationException
}
```

**Problematic Code with Map::**
```java
Map<Integer, String> map = new HashMap<>();
map.put(1, "One");
map.put(2, "Two");
for (Integer key : map.keySet()) {
    map.remove(key); // ConcurrentModificationException
}
```
**Solution**:  Using Iterator.remove(). Use an Iterator to safely remove elements from the map during iteration.
```java
Map<Integer, String> map = new HashMap<>();
map.put(1, "One");
map.put(2, "Two");
Iterator<Integer> iterator = map.keySet().iterator();
while (iterator.hasNext()) {
    Integer key = iterator.next();
    iterator.remove(); // Safely remove the entry
}
```