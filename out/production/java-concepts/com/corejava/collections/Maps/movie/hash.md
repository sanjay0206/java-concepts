# Java Collections: `equals` and `hashCode` Implementation

## Collections Where `equals` and `hashCode` Should Be Overridden

1. **Hash-Based Collections:**
    - **`HashMap<K, V>`**: Uses `hashCode` to store and retrieve keys and `equals` to check key equality.
    - **`HashSet<E>`**: Uses `hashCode` to store and retrieve elements and `equals` to check element equality.
    - **`Hashtable<K, V>`**: Similar to `HashMap`, relies on `hashCode` and `equals` for key management.

2. **Other Hash-Based Collections:**
    - **`LinkedHashMap<K, V>`**: Extends `HashMap` with predictable iteration order, still relies on `hashCode` and `equals`.
    - **`LinkedHashSet<E>`**: Extends `HashSet` with predictable iteration order, still relies on `hashCode` and `equals`.

## Collections Where `equals` and `hashCode` Are Not Required

1. **Sorted Collections:**
    - **`TreeMap<K, V>`**: Uses `compareTo` (or `Comparator`) for ordering, not `hashCode`. Requires `equals` for key comparisons in some cases.
    - **`TreeSet<E>`**: Uses `compareTo` (or `Comparator`) for ordering, not `hashCode`. Requires `equals` for element comparisons.

2. **Sequential Collections:**
    - **`ArrayList<E>`**: Uses `equals` for methods like `contains`, `indexOf`, and `remove`, but does not use `hashCode`.
    - **`LinkedList<E>`**: Similar to `ArrayList`, uses `equals` for certain methods but does not use `hashCode`.

3. **Deque and Queue Implementations:**
    - **`ArrayDeque<E>`**: Uses `equals` for element comparisons, but not `hashCode`.
    - **`PriorityQueue<E>`**: Uses `compareTo` (or `Comparator`) for ordering, not `hashCode`. Uses `equals` for comparisons.

4. **Other Specialized Collections:**
    - **`BlockingQueue<E>`**: An interface with implementations like `ArrayBlockingQueue`, `LinkedBlockingQueue`, and `PriorityBlockingQueue`. Uses `equals` for certain operations but not `hashCode`.

## Summary

- **Override `equals` and `hashCode`:** For hash-based collections (`HashMap`, `HashSet`, `Hashtable`, `LinkedHashMap`, `LinkedHashSet`) where both `hashCode` and `equals` are used for storing and retrieving elements.
- **Override `equals` Only:** For sorted and sequential collections where `hashCode` is not used but `equals` is needed for operations like `contains`, `indexOf`, and `remove`.
- **No Override Needed:** For collections that do not use `hashCode` and only occasionally use `equals`, such as `PriorityQueue`, `ArrayDeque`, and other specialized queues.

Implementing `equals` and `hashCode` is crucial for correct behavior in hash-based collections, while for others, overriding `equals` alone might be sufficient depending on the specific use case.
