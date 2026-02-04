<h1>Java Collection Framework</h1>

<p>
The <strong>Java Collection Framework (JCF)</strong> is a unified architecture provided by Java
to store, manipulate, and process groups of objects efficiently.
It consists of interfaces, classes, and algorithms that help in handling
data structures such as lists, sets, queues, and maps.
</p>

<hr>

<h2>Components of Java Collection Framework</h2>

<p>The Java Collection Framework can be broadly classified into the following components:</p>

<ul>
  <li>Interfaces</li>
  <li>Classes (Implementations)</li>
  <li>Algorithms</li>
  <li>Iterators</li>
</ul>

<hr>

<h2>Core Interfaces</h2>

<p>The core interfaces define the basic structure and behavior of collections.</p>

<ul>
  <li><strong>Collection</strong> – Root interface of the collection hierarchy (except Map)</li>
  <li><strong>List</strong> – Ordered collection that allows duplicate elements</li>
  <li><strong>Set</strong> – Collection that does not allow duplicate elements</li>
  <li><strong>Queue</strong> – Collection designed for holding elements prior to processing</li>
  <li><strong>Deque</strong> – Double-ended queue that allows insertion and removal from both ends</li>
  <li><strong>Map</strong> – Stores key–value pairs (not a child of Collection)</li>
</ul>

<hr>

<h2>Collection Hierarchy</h2>

<pre>
Iterable
   |
Collection
   |
------------------------------------------------
|            |              |                 |
List         Set            Queue            Deque
</pre>

<hr>

<h2>List Implementations</h2>

<p>
Lists store elements in an ordered sequence and allow duplicate values.
They are commonly used when index-based access is required.
</p>

<ul>
  <li>
    <strong>ArrayList</strong><br>
    Uses a dynamic array internally. Provides fast access but slower insertion/deletion
    in the middle of the list.
  </li>
  <li>
    <strong>LinkedList</strong><br>
    Uses a doubly linked list. Faster insertion and deletion but slower random access.
  </li>
  <li>
    <strong>Vector</strong><br>
    Thread-safe dynamic array. Considered legacy due to performance overhead.
  </li>
  <li>
    <strong>Stack</strong><br>
    Implements LIFO (Last In First Out). ArrayDeque is preferred in modern Java.
  </li>
</ul>

<hr>

<h2>Set Implementations</h2>

<p>
Sets store unique elements only and are used when duplication is not allowed.
</p>

<ul>
  <li>
    <strong>HashSet</strong><br>
    Uses hashing for storage. Provides fast operations but no order guarantee.
  </li>
  <li>
    <strong>LinkedHashSet</strong><br>
    Maintains insertion order while ensuring uniqueness.
  </li>
  <li>
    <strong>TreeSet</strong><br>
    Stores elements in sorted order using a Red-Black Tree.
  </li>
</ul>

<hr>

<h2>Queue Implementations</h2>

<p>
Queues are mainly used for task scheduling and processing.
</p>

<ul>
  <li>
    <strong>PriorityQueue</strong><br>
    Elements are ordered based on priority rather than insertion order.
  </li>
  <li>
    <strong>ArrayDeque</strong><br>
    Efficient implementation of Deque, preferred over Stack and LinkedList.
  </li>
</ul>

<hr>

<h2>Map Implementations</h2>

<p>
Maps store data as key–value pairs where keys are unique.
</p>

<ul>
  <li>
    <strong>HashMap</strong><br>
    Fast access using hashing. Allows one null key.
  </li>
  <li>
    <strong>LinkedHashMap</strong><br>
    Maintains insertion order of keys.
  </li>
  <li>
    <strong>TreeMap</strong><br>
    Maintains keys in sorted order.
  </li>
  <li>
    <strong>Hashtable</strong><br>
    Thread-safe legacy class. Does not allow null keys or values.
  </li>
</ul>

<hr>

<h2>Algorithms</h2>

<p>
The <strong>Collections</strong> class provides static utility methods to operate on collections.
These methods work on List, Set, and Map implementations.
</p>

<ul>
  <li>sort()</li>
  <li>reverse()</li>
  <li>shuffle()</li>
  <li>binarySearch()</li>
  <li>max() / min()</li>
  <li>frequency()</li>
</ul>

<hr>

<h2>Iterators</h2>

<p>
Iterators allow safe traversal of collection elements and help avoid runtime errors.
</p>

<ul>
  <li><strong>Iterator</strong> – Allows forward traversal</li>
  <li><strong>ListIterator</strong> – Allows forward and backward traversal</li>
</ul>

<hr>

<h2>Advantages of Java Collection Framework</h2>

<ul>
  <li>Reduces programming effort</li>
  <li>Improves performance</li>
  <li>Provides reusable and standardized code</li>
  <li>Supports scalability</li>
</ul>

<hr>

<h2>Basic Knowledge and Functions of Java Collection Components</h2>

<h3>1. Collection Interface</h3>

<p>
Acts as the base interface for List, Set, and Queue.
</p>

<strong>Common Methods:</strong>
<ul>
  <li>add(E e)</li>
  <li>remove(Object o)</li>
  <li>size()</li>
  <li>isEmpty()</li>
  <li>contains(Object o)</li>
  <li>clear()</li>
  <li>iterator()</li>
</ul>

<p>
These methods define basic operations like insertion, deletion,
and traversal of elements.
</p>

<hr>

<h3>2. List Interface</h3>

<p>
Used when ordered data and duplicate values are required.
</p>

<strong>Common Methods:</strong>
<ul>
  <li>add(int index, E element)</li>
  <li>get(int index)</li>
  <li>set(int index, E element)</li>
  <li>remove(int index)</li>
  <li>indexOf(Object o)</li>
  <li>lastIndexOf(Object o)</li>
</ul>

<p>
These methods support index-based access and modification of elements.
</p>

<hr>

<h3>3. Set Interface</h3>

<p>
Used to store unique elements only.
</p>

<strong>Common Methods:</strong>
<ul>
  <li>add(E e)</li>
  <li>remove(Object o)</li>
  <li>contains(Object o)</li>
  <li>size()</li>
  <li>clear()</li>
</ul>

<p>
Duplicate insertion is ignored automatically by Set implementations.
</p>

<hr>

<h3>4. Queue Interface</h3>

<p>
Follows FIFO principle and is used in scheduling systems.
</p>

<strong>Common Methods:</strong>
<ul>
  <li>add(E e)</li>
  <li>offer(E e)</li>
  <li>remove()</li>
  <li>poll()</li>
  <li>element()</li>
  <li>peek()</li>
</ul>

<p>
Methods differ in how they handle empty queues (exception vs null).
</p>

<hr>

<h3>5. Deque Interface</h3>

<p>
Supports insertion and deletion from both ends.
</p>

<strong>Common Methods:</strong>
<ul>
  <li>addFirst(E e)</li>
  <li>addLast(E e)</li>
  <li>removeFirst()</li>
  <li>removeLast()</li>
  <li>peekFirst()</li>
  <li>peekLast()</li>
</ul>

<hr>

<h3>6. Map Interface</h3>

<p>
Used for fast key-based data access.
</p>

<strong>Common Methods:</strong>
<ul>
  <li>put(K key, V value)</li>
  <li>get(Object key)</li>
  <li>remove(Object key)</li>
  <li>containsKey(Object key)</li>
  <li>containsValue(Object value)</li>
  <li>keySet()</li>
  <li>values()</li>
  <li>entrySet()</li>
</ul>

<hr>

<h3>7. Iterator and ListIterator</h3>

<strong>Iterator Methods:</strong>
<ul>
  <li>hasNext()</li>
  <li>next()</li>
  <li>remove()</li>
</ul>

<strong>ListIterator Methods:</strong>
<ul>
  <li>hasPrevious()</li>
  <li>previous()</li>
  <li>add(E e)</li>
  <li>set(E e)</li>
</ul>

<hr>

<h3>8. Collections Utility Class</h3>

<strong>Common Methods:</strong>
<ul>
  <li>sort(List list)</li>
  <li>reverse(List list)</li>
  <li>shuffle(List list)</li>
  <li>binarySearch(List list, Object key)</li>
  <li>max(Collection c)</li>
  <li>min(Collection c)</li>
</ul>

<hr>

<hr>

<h2>Function-wise and Data Structure Name Differences (Java vs C++)</h2>

<p>
The Java Collection Framework and C++ STL provide similar data structures,
but the class names and method names differ. Below is a direct comparison
of commonly used collections and their functions.
</p>

<hr>

<h3>1. List vs Vector / List (C++)</h3>

<table border="1" cellpadding="6">
<tr>
  <th>Operation</th>
  <th>Java (List / ArrayList)</th>
  <th>C++ STL (vector / list)</th>
</tr>
<tr>
  <td>Add element</td>
  <td>add(e)</td>
  <td>push_back(e)</td>
</tr>
<tr>
  <td>Access element</td>
  <td>get(index)</td>
  <td>v[index]</td>
</tr>
<tr>
  <td>Remove element</td>
  <td>remove(index)</td>
  <td>erase(iterator)</td>
</tr>
<tr>
  <td>Size</td>
  <td>size()</td>
  <td>size()</td>
</tr>
<tr>
  <td>Clear</td>
  <td>clear()</td>
  <td>clear()</td>
</tr>
</table>

<hr>

<h3>2. Set vs set / unordered_set</h3>

<table border="1" cellpadding="6">
<tr>
  <th>Operation</th>
  <th>Java (Set)</th>
  <th>C++ STL</th>
</tr>
<tr>
  <td>Insert element</td>
  <td>add(e)</td>
  <td>insert(e)</td>
</tr>
<tr>
  <td>Check existence</td>
  <td>contains(e)</td>
  <td>find(e)</td>
</tr>
<tr>
  <td>Remove element</td>
  <td>remove(e)</td>
  <td>erase(e)</td>
</tr>
<tr>
  <td>Traversal</td>
  <td>Iterator</td>
  <td>Iterator</td>
</tr>
</table>

<hr>

<h3>3. Map vs map / unordered_map</h3>

<table border="1" cellpadding="6">
<tr>
  <th>Operation</th>
  <th>Java (Map)</th>
  <th>C++ STL</th>
</tr>
<tr>
  <td>Insert key-value</td>
  <td>put(k, v)</td>
  <td>m[k] = v</td>
</tr>
<tr>
  <td>Access value</td>
  <td>get(k)</td>
  <td>m[k]</td>
</tr>
<tr>
  <td>Check key</td>
  <td>containsKey(k)</td>
  <td>find(k)</td>
</tr>
<tr>
  <td>Remove key</td>
  <td>remove(k)</td>
  <td>erase(k)</td>
</tr>
<tr>
  <td>Keys only</td>
  <td>keySet()</td>
  <td>Iterate keys</td>
</tr>
</table>

<hr>

<h3>4. Queue vs queue</h3>

<table border="1" cellpadding="6">
<tr>
  <th>Operation</th>
  <th>Java (Queue)</th>
  <th>C++ STL</th>
</tr>
<tr>
  <td>Insert</td>
  <td>offer(e)</td>
  <td>push(e)</td>
</tr>
<tr>
  <td>Remove</td>
  <td>poll()</td>
  <td>pop()</td>
</tr>
<tr>
  <td>Front element</td>
  <td>peek()</td>
  <td>front()</td>
</tr>
</table>

<hr>

<h3>5. Stack vs stack</h3>

<table border="1" cellpadding="6">
<tr>
  <th>Operation</th>
  <th>Java (Stack)</th>
  <th>C++ STL</th>
</tr>
<tr>
  <td>Push</td>
  <td>push(e)</td>
  <td>push(e)</td>
</tr>
<tr>
  <td>Pop</td>
  <td>pop()</td>
  <td>pop()</td>
</tr>
<tr>
  <td>Top element</td>
  <td>peek()</td>
  <td>top()</td>
</tr>
</table>

<hr>

<h3>6. Algorithms Comparison</h3>

<table border="1" cellpadding="6">
<tr>
  <th>Operation</th>
  <th>Java (Collections)</th>
  <th>C++ STL (&lt;algorithm&gt;)</th>
</tr>
<tr>
  <td>Sort</td>
  <td>Collections.sort(list)</td>
  <td>sort(begin, end)</td>
</tr>
<tr>
  <td>Binary Search</td>
  <td>Collections.binarySearch()</td>
  <td>binary_search()</td>
</tr>
<tr>
  <td>Reverse</td>
  <td>Collections.reverse()</td>
  <td>reverse()</td>
</tr>
</table>

<hr>

<h3>Key Takeaway</h3>

<p>
Java uses <strong>object-oriented method names</strong>,
while C++ STL uses <strong>function-based and operator-based syntax</strong>.
Despite different naming conventions, both provide similar functionality.
</p>

<h2>Conclusion</h2>

<p>
The Java Collection Framework offers a powerful, flexible, and efficient way
to store and manipulate data. Mastery of collections is essential for
writing high-performance and scalable Java applications.
</p>
