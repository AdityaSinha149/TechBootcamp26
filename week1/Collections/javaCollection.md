# Java Collection Framework

The **Java Collection Framework (JCF)** is a unified architecture provided by Java to store, manipulate, and process groups of objects efficiently. It consists of interfaces, classes, and algorithms that help in handling data structures such as lists, sets, queues, and maps.

---

## Components of Java Collection Framework

The Java Collection Framework can be broadly classified into the following components:

- **Interfaces** – Define the basic structure and behavior
- **Classes (Implementations)** – Concrete data structures
- **Algorithms** – Common operations (sorting, searching, etc.)
- **Iterators** – Mechanisms to traverse collections

---

## Core Interfaces

The core interfaces define the basic structure and behavior of collections.

- **Collection** – Root interface of the collection hierarchy (except Map)
- **List** – Ordered collection that allows duplicate elements
- **Set** – Collection that does not allow duplicate elements
- **Queue** – Collection designed for holding elements prior to processing
- **Deque** – Double-ended queue that allows insertion and removal from both ends
- **Map** – Stores key–value pairs (not a child of Collection)

---

## Collection Hierarchy

```
Iterable
   |
Collection
   |
------------------------------------------------
|            |              |                 |
List         Set            Queue            Deque
```

---

## List Implementations

Lists store elements in an ordered sequence and allow duplicate values. They are commonly used when index-based access is required.

### ArrayList
- Uses a dynamic array internally
- Provides fast access (`O(1)`) but slower insertion/deletion in the middle (`O(n)`)
- **Best for**: Frequent reads, infrequent modifications

### LinkedList
- Uses a doubly linked list
- Faster insertion and deletion (`O(1)` at ends) but slower random access (`O(n)`)
- **Best for**: Frequent insertions/deletions

### Vector
- Thread-safe dynamic array
- Considered legacy due to performance overhead
- **Best for**: Legacy code requiring thread safety

### Stack
- Implements LIFO (Last In First Out)
- `ArrayDeque` is preferred in modern Java
- **Best for**: Simple stack operations (use `ArrayDeque` instead)

---

## Set Implementations

Sets store unique elements only and are used when duplication is not allowed.

### HashSet
- Uses hashing for storage
- Provides fast operations (`O(1)`) but no order guarantee
- **Best for**: Fast lookups, uniqueness checking

### LinkedHashSet
- Maintains insertion order while ensuring uniqueness
- Slightly slower than `HashSet` due to maintaining order
- **Best for**: When order matters with uniqueness

### TreeSet
- Stores elements in sorted order using a Red-Black Tree
- Operations take `O(log n)` time
- **Best for**: Sorted data with uniqueness

---

## Queue Implementations

Queues are mainly used for task scheduling and processing.

### PriorityQueue
- Elements are ordered based on priority rather than insertion order
- Uses a heap internally
- **Best for**: Priority-based processing

### ArrayDeque
- Efficient implementation of Deque
- Preferred over `Stack` and `LinkedList`
- **Best for**: Stack and queue operations

---

## Map Implementations

Maps store data as key–value pairs where keys are unique.

### HashMap
- Fast access using hashing (`O(1)`)
- Allows one null key and multiple null values
- **Best for**: Fast key-value lookups

### LinkedHashMap
- Maintains insertion order of keys
- Slightly slower than `HashMap`
- **Best for**: When order matters

### TreeMap
- Maintains keys in sorted order
- Operations take `O(log n)` time
- **Best for**: Sorted key-value pairs

### Hashtable
- Thread-safe legacy class
- Does not allow null keys or values
- **Best for**: Legacy code (use `ConcurrentHashMap` instead)

---

## Common Collection Methods

### Collection Interface Methods
```java
boolean add(E e)              // Add element
boolean remove(Object o)      // Remove element
int size()                    // Get size
boolean isEmpty()             // Check if empty
boolean contains(Object o)    // Check if contains element
void clear()                  // Remove all elements
Iterator<E> iterator()        // Get iterator
```

### List Interface Methods
```java
void add(int index, E element)     // Add at index
E get(int index)                   // Get element at index
E set(int index, E element)        // Replace element at index
E remove(int index)                // Remove element at index
int indexOf(Object o)              // Get first index of element
int lastIndexOf(Object o)          // Get last index of element
```

### Set Interface Methods
```java
boolean add(E e)              // Add element (if not present)
boolean remove(Object o)      // Remove element
boolean contains(Object o)    // Check if contains
int size()                    // Get size
void clear()                  // Remove all elements
```

### Queue Interface Methods
```java
boolean add(E e)      // Add (throws exception if fails)
boolean offer(E e)    // Add (returns false if fails)
E remove()            // Remove head (throws exception if empty)
E poll()              // Remove head (returns null if empty)
E element()           // View head (throws exception if empty)
E peek()              // View head (returns null if empty)
```

### Deque Interface Methods
```java
void addFirst(E e)    // Add at front
void addLast(E e)     // Add at end
E removeFirst()       // Remove from front
E removeLast()        // Remove from end
E peekFirst()         // View front element
E peekLast()          // View last element
```

### Map Interface Methods
```java
V put(K key, V value)              // Add/update key-value pair
V get(Object key)                  // Get value for key
V remove(Object key)               // Remove key-value pair
boolean containsKey(Object key)    // Check if key exists
boolean containsValue(Object value)// Check if value exists
Set<K> keySet()                    // Get all keys
Collection<V> values()             // Get all values
Set<Map.Entry<K,V>> entrySet()    // Get all key-value pairs
```

---

## Iterator and ListIterator

### Iterator Methods
```java
boolean hasNext()     // Check if more elements exist
E next()              // Get next element
void remove()         // Remove current element
```

### ListIterator Methods (extends Iterator)
```java
boolean hasPrevious() // Check if previous element exists
E previous()          // Get previous element
void add(E e)         // Add element
void set(E e)         // Replace current element
```

---

## Collections Utility Class

The `Collections` class provides static utility methods to operate on collections:

```java
Collections.sort(List<T> list)              // Sort list
Collections.reverse(List<?> list)           // Reverse list
Collections.shuffle(List<?> list)           // Shuffle randomly
Collections.binarySearch(List<T> list, T key) // Binary search
Collections.max(Collection<T> coll)         // Find maximum
Collections.min(Collection<T> coll)         // Find minimum
Collections.frequency(Collection<?> c, Object o) // Count occurrences
```

---

## Practical Code Examples

### ArrayList Example
```java
import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();
        
        // Adding elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        
        // Accessing elements
        System.out.println("First fruit: " + fruits.get(0));
        
        // Modifying elements
        fruits.set(1, "Mango");
        
        // Removing elements
        fruits.remove("Orange");
        
        // Iterating
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}
```

### HashSet Example
```java
import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<Integer> numbers = new HashSet<>();
        
        // Adding elements
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(2); // Duplicate - won't be added
        
        // Check contains
        System.out.println("Contains 5? " + numbers.contains(5));
        
        // Size
        System.out.println("Size: " + numbers.size()); // Output: 3
        
        // Iterate
        for (int num : numbers) {
            System.out.println(num);
        }
    }
}
```

### HashMap Example
```java
import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String, Integer> scores = new HashMap<>();
        
        // Adding key-value pairs
        scores.put("Alice", 95);
        scores.put("Bob", 87);
        scores.put("Charlie", 92);
        
        // Getting values
        System.out.println("Alice's score: " + scores.get("Alice"));
        
        // Check if key exists
        if (scores.containsKey("Bob")) {
            System.out.println("Bob's score found!");
        }
        
        // Iterate through entries
        for (String name : scores.keySet()) {
            System.out.println(name + ": " + scores.get(name));
        }
    }
}
```

---

## Java vs C++ Collection Comparison

For students coming from C++, here's a quick comparison:

| Operation | Java (ArrayList) | C++ (vector) |
|-----------|------------------|--------------|
| Add element | `list.add(e)` | `vec.push_back(e)` |
| Access element | `list.get(i)` | `vec[i]` |
| Remove element | `list.remove(i)` | `vec.erase(vec.begin()+i)` |
| Size | `list.size()` | `vec.size()` |
| Clear | `list.clear()` | `vec.clear()` |

| Operation | Java (HashSet) | C++ (set/unordered_set) |
|-----------|----------------|-------------------------|
| Insert | `set.add(e)` | `set.insert(e)` |
| Check existence | `set.contains(e)` | `set.find(e) != set.end()` |
| Remove | `set.remove(e)` | `set.erase(e)` |

| Operation | Java (HashMap) | C++ (map/unordered_map) |
|-----------|----------------|-------------------------|
| Insert | `map.put(k, v)` | `map[k] = v` |
| Access | `map.get(k)` | `map[k]` |
| Check key | `map.containsKey(k)` | `map.find(k) != map.end()` |
| Remove | `map.remove(k)` | `map.erase(k)` |

| Operation | Java (Queue) | C++ (queue) |
|-----------|--------------|-------------|
| Insert | `queue.offer(e)` | `queue.push(e)` |
| Remove | `queue.poll()` | `queue.pop()` |
| Peek | `queue.peek()` | `queue.front()` |

| Operation | Java (Stack/ArrayDeque) | C++ (stack) |
|-----------|-------------------------|-------------|
| Push | `deque.push(e)` | `stack.push(e)` |
| Pop | `deque.pop()` | `stack.pop()` |
| Top | `deque.peek()` | `stack.top()` |

---

## Time Complexity Reference

| Collection | Add | Remove | Get | Contains |
|------------|-----|--------|-----|----------|
| ArrayList | O(1)* | O(n) | O(1) | O(n) |
| LinkedList | O(1)** | O(1)** | O(n) | O(n) |
| HashSet | O(1) | O(1) | - | O(1) |
| TreeSet | O(log n) | O(log n) | - | O(log n) |
| HashMap | O(1) | O(1) | O(1) | O(1) |
| TreeMap | O(log n) | O(log n) | O(log n) | O(log n) |

*Amortized time (may require resizing)  
**At known positions (ends)

---

## When to Use Which Collection?

- **ArrayList**: When you need fast random access and infrequent insertions/deletions
- **LinkedList**: When you frequently add/remove from the beginning or middle
- **HashSet**: When you need to store unique elements with fast lookups
- **TreeSet**: When you need unique elements in sorted order
- **HashMap**: When you need fast key-value lookups
- **TreeMap**: When you need sorted key-value pairs
- **PriorityQueue**: When you need elements in priority order
- **ArrayDeque**: When you need a stack or queue

---

## Advantages of Java Collection Framework

- Reduces programming effort by providing ready-to-use data structures
- Improves performance through highly optimized implementations
- Provides reusable and standardized code
- Supports interoperability between different implementations
- Enables scalability for growing applications

---

## Key Takeaways

- Java uses **object-oriented method names** (e.g., `add()`, `get()`)
- C++ STL uses **function-based and operator-based syntax** (e.g., `push_back()`, `[]`)
- Despite different naming conventions, both provide similar functionality
- Choose the right collection based on your use case and performance requirements
- The Java Collection Framework is essential for writing efficient and scalable applications

---

## Conclusion

The Java Collection Framework offers a powerful, flexible, and efficient way to store and manipulate data. Mastery of collections is essential for writing high-performance Java applications and solving algorithmic problems efficiently.
