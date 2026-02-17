# Java Collections Quick Reference

A concise cheat sheet for Java Collections Framework - perfect for quick lookups during problem-solving!

---

## 🎯 When to Use Which Collection?

| Need | Use | Why |
|------|-----|-----|
| Fast random access | `ArrayList` | O(1) get by index |
| Frequent insertions/deletions | `LinkedList` | O(1) at ends |
| Unique elements, fast lookup | `HashSet` | O(1) contains |
| Unique elements, sorted order | `TreeSet` | O(log n) operations, sorted |
| Key-value pairs, fast lookup | `HashMap` | O(1) get/put |
| Key-value pairs, sorted keys | `TreeMap` | O(log n) operations, sorted |
| FIFO queue | `LinkedList` or `ArrayDeque` | Queue operations |
| LIFO stack | `ArrayDeque` | Better than Stack class |
| Priority-based processing | `PriorityQueue` | Min/max heap |

---

## 📋 Common Operations Cheat Sheet

### ArrayList
```java
List<Integer> list = new ArrayList<>();
list.add(5);              // Add to end - O(1)*
list.add(0, 3);           // Add at index - O(n)
list.get(0);              // Access by index - O(1)
list.set(0, 10);          // Update by index - O(1)
list.remove(0);           // Remove by index - O(n)
list.size();              // Get size - O(1)
list.contains(5);         // Check existence - O(n)
list.clear();             // Remove all - O(n)
Collections.sort(list);   // Sort - O(n log n)
```

### LinkedList
```java
LinkedList<Integer> list = new LinkedList<>();
list.addFirst(1);         // Add at start - O(1)
list.addLast(5);          // Add at end - O(1)
list.getFirst();          // Get first - O(1)
list.getLast();           // Get last - O(1)
list.removeFirst();       // Remove first - O(1)
list.removeLast();        // Remove last - O(1)
```

### HashSet
```java
Set<Integer> set = new HashSet<>();
set.add(5);               // Add element - O(1)
set.remove(5);            // Remove element - O(1)
set.contains(5);          // Check existence - O(1)
set.size();               // Get size - O(1)
set.isEmpty();            // Check if empty - O(1)
set.clear();              // Remove all - O(n)

// Iterate
for (int num : set) {
    System.out.println(num);
}
```

### TreeSet
```java
TreeSet<Integer> set = new TreeSet<>();
set.add(5);               // Add - O(log n)
set.remove(5);            // Remove - O(log n)
set.contains(5);          // Check - O(log n)
set.first();              // Get min - O(log n)
set.last();               // Get max - O(log n)
set.floor(3);             // Largest ≤ 3 - O(log n)
set.ceiling(3);           // Smallest ≥ 3 - O(log n)
```

### HashMap
```java
Map<String, Integer> map = new HashMap<>();
map.put("key", 10);       // Add/update - O(1)
map.get("key");           // Get value - O(1)
map.remove("key");        // Remove - O(1)
map.containsKey("key");   // Check key - O(1)
map.containsValue(10);    // Check value - O(n)
map.getOrDefault("key", 0); // Get or default - O(1)
map.size();               // Get size - O(1)

// Iterate through keys
for (String key : map.keySet()) {
    System.out.println(key + ": " + map.get(key));
}

// Iterate through entries (faster)
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}
```

### TreeMap
```java
TreeMap<String, Integer> map = new TreeMap<>();
map.put("key", 10);       // Add - O(log n)
map.firstKey();           // Min key - O(log n)
map.lastKey();            // Max key - O(log n)
map.floorKey("c");        // Largest key ≤ "c" - O(log n)
map.ceilingKey("c");      // Smallest key ≥ "c" - O(log n)
```

### Queue (LinkedList)
```java
Queue<Integer> queue = new LinkedList<>();
queue.offer(5);           // Add to rear - O(1)
queue.poll();             // Remove from front - O(1)
queue.peek();             // View front - O(1)
queue.isEmpty();          // Check if empty - O(1)
```

### Stack (ArrayDeque)
```java
Deque<Integer> stack = new ArrayDeque<>();
stack.push(5);            // Push - O(1)
stack.pop();              // Pop - O(1)
stack.peek();             // View top - O(1)
stack.isEmpty();          // Check if empty - O(1)
```

### PriorityQueue (Min Heap)
```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.offer(5);              // Add - O(log n)
pq.poll();                // Remove min - O(log n)
pq.peek();                // View min - O(1)

// Max heap
PriorityQueue<Integer> maxPq = new PriorityQueue<>((a, b) -> b - a);
```

---

## 🔄 Common Patterns

### Pattern 1: Frequency Counting
```java
HashMap<Integer, Integer> freq = new HashMap<>();
for (int num : arr) {
    freq.put(num, freq.getOrDefault(num, 0) + 1);
}
```

### Pattern 2: Two Sum (Finding Complement)
```java
HashMap<Integer, Integer> map = new HashMap<>();
for (int i = 0; i < arr.length; i++) {
    int complement = target - arr[i];
    if (map.containsKey(complement)) {
        return new int[] {map.get(complement), i};
    }
    map.put(arr[i], i);
}
```

### Pattern 3: Removing Duplicates
```java
HashSet<Integer> set = new HashSet<>(Arrays.asList(arr));
// or
Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());
```

### Pattern 4: Sliding Window with HashMap
```java
HashMap<Character, Integer> window = new HashMap<>();
int left = 0;
for (int right = 0; right < s.length(); right++) {
    char c = s.charAt(right);
    window.put(c, window.getOrDefault(c, 0) + 1);
    
    while (/* condition */) {
        char leftChar = s.charAt(left);
        window.put(leftChar, window.get(leftChar) - 1);
        if (window.get(leftChar) == 0) {
            window.remove(leftChar);
        }
        left++;
    }
}
```

### Pattern 5: Priority Queue for Kth Element
```java
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
for (int num : arr) {
    minHeap.offer(num);
    if (minHeap.size() > k) {
        minHeap.poll();
    }
}
int kthLargest = minHeap.peek();
```

---

## 📊 Time Complexity Summary

| Collection | Add | Remove | Get | Contains | Space |
|------------|-----|--------|-----|----------|-------|
| **ArrayList** | O(1)* | O(n) | O(1) | O(n) | O(n) |
| **LinkedList** | O(1) | O(1)** | O(n) | O(n) | O(n) |
| **HashSet** | O(1) | O(1) | N/A | O(1) | O(n) |
| **TreeSet** | O(log n) | O(log n) | N/A | O(log n) | O(n) |
| **HashMap** | O(1) | O(1) | O(1) | O(1) | O(n) |
| **TreeMap** | O(log n) | O(log n) | O(log n) | O(log n) | O(n) |
| **PriorityQueue** | O(log n) | O(log n) | N/A | O(n) | O(n) |

*Amortized (may require resizing)  
**At known positions (ends)

---

## 🔧 Useful Utility Methods

### Arrays
```java
Arrays.sort(arr);                    // Sort array
Arrays.binarySearch(arr, key);       // Binary search (sorted array)
Arrays.fill(arr, value);             // Fill with value
Arrays.copyOf(arr, length);          // Copy array
Arrays.toString(arr);                // Convert to string
Arrays.asList(1, 2, 3);             // Create list from elements
```

### Collections
```java
Collections.sort(list);              // Sort list
Collections.reverse(list);           // Reverse list
Collections.shuffle(list);           // Shuffle randomly
Collections.max(list);               // Find maximum
Collections.min(list);               // Find minimum
Collections.frequency(list, elem);   // Count occurrences
Collections.binarySearch(list, key); // Binary search (sorted list)
```

### Conversion
```java
// Array to List
List<Integer> list = Arrays.asList(1, 2, 3);
List<Integer> list = new ArrayList<>(Arrays.asList(arr));

// List to Array
Integer[] arr = list.toArray(new Integer[0]);
int[] arr = list.stream().mapToInt(i->i).toArray();

// Set to List
List<Integer> list = new ArrayList<>(set);

// Array to Set
Set<Integer> set = new HashSet<>(Arrays.asList(arr));
```

---

## 🎯 Decision Tree

```
Need to store elements?
├─ Need key-value pairs?
│  ├─ Need sorted keys?
│  │  └─ Use TreeMap
│  └─ Don't need sorting?
│     └─ Use HashMap
│
└─ Don't need key-value pairs?
   ├─ Need unique elements?
   │  ├─ Need sorted order?
   │  │  └─ Use TreeSet
   │  └─ Don't need sorting?
   │     └─ Use HashSet
   │
   └─ Allow duplicates?
      ├─ Need index access?
      │  └─ Use ArrayList
      ├─ Frequent insert/delete at ends?
      │  └─ Use LinkedList
      └─ Need priority-based processing?
         └─ Use PriorityQueue
```

---

## 💡 Pro Tips

1. **HashMap vs TreeMap:** Use `HashMap` unless you need sorted keys
2. **ArrayList vs LinkedList:** Use `ArrayList` unless you frequently add/remove from middle
3. **HashSet for O(1) lookups:** When you need to check "does this exist?"
4. **PriorityQueue for Kth element:** Maintain a heap of size k
5. **TreeSet for range queries:** Use `floor()`, `ceiling()`, `subSet()`
6. **Use getOrDefault():** Cleaner code for frequency counting
7. **Avoid null keys in HashMap:** Only one null key allowed, multiple null values OK
8. **LinkedHashMap for insertion order:** When HashMap order matters

---

## 🚨 Common Mistakes to Avoid

1. ❌ `list.remove(5)` removes index 5, not value 5 (use `list.remove(Integer.valueOf(5))`)
2. ❌ Modifying collection while iterating (use `Iterator.remove()`)
3. ❌ Using `==` for String comparison (use `.equals()`)
4. ❌ Not checking `containsKey()` before `get()` in Map
5. ❌ Using `Stack` class (use `ArrayDeque` instead)
6. ❌ Forgetting to handle null values in custom comparators

---

**Print this out and keep it handy while solving problems! 📌**
