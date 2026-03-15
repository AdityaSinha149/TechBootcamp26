# Hard Linked List Problems

These problems combine multiple Linked List patterns and require strong pointer manipulation skills.

Students should attempt these only after completing the easy and medium problems.

These problems test:

- Advanced pointer manipulation
- Pattern combination
- Data structure design


# 1️⃣ Reverse Nodes in K Group (LC 25)

Difficulty: Hard  
Pattern: Reverse Pattern + Group Processing  

## Problem

Given a linked list, reverse the nodes of the list **k at a time** and return the modified list.

If the number of nodes is not a multiple of k, leave the remaining nodes as they are.

## Example

Input:

1 → 2 → 3 → 4 → 5  
k = 2  

Output:

2 → 1 → 4 → 3 → 5  

## Hint

1. Find the kth node
2. Reverse the k nodes
3. Reconnect the previous part with the reversed group
4. Repeat

## Solution

```java
public ListNode reverseKGroup(ListNode head, int k) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode groupPrev = dummy;

    while (true) {

        ListNode kth = groupPrev;

        for (int i = 0; i < k && kth != null; i++) {
            kth = kth.next;
        }

        if (kth == null) break;

        ListNode groupNext = kth.next;

        ListNode prev = groupNext;
        ListNode curr = groupPrev.next;

        while (curr != groupNext) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode temp = groupPrev.next;
        groupPrev.next = kth;
        groupPrev = temp;
    }

    return dummy.next;
}
```

Time: O(n)  
Space: O(1)

## Key Learning

This problem combines **reverse pattern + segment processing**.


# 2️⃣ LRU Cache (LC 146)

Difficulty: Hard  
Pattern: HashMap + Doubly Linked List  

## Problem

Design a data structure that supports:

- get(key)
- put(key, value)

Both operations must run in **O(1)** time.

When the cache reaches capacity, remove the **least recently used** item.

## Hint

Use two data structures:

HashMap → fast lookup  
Doubly Linked List → track usage order  

Most recently used items stay near the **head**.

## Solution (Core Idea)

```java
class LRUCache {

    class Node {
        int key, value;
        Node prev, next;
    }

    int capacity;
    HashMap<Integer, Node> map = new HashMap<>();

    Node head = new Node();
    Node tail = new Node();

    public LRUCache(int capacity) {
        this.capacity = capacity;

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        remove(node);
        insert(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            remove(map.get(key));
        }

        if (map.size() == capacity) {
            map.remove(tail.prev.key);
            remove(tail.prev);
        }

        Node node = new Node();
        node.key = key;
        node.value = value;

        insert(node);
        map.put(key, node);
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        node.next = head.next;
        head.next.prev = node;

        head.next = node;
        node.prev = head;
    }
}
```

Time: O(1)  
Space: O(capacity)

## Key Learning

Combining **two data structures** can achieve optimal performance.


# 3️⃣ Copy List with Random Pointer (LC 138)

Difficulty: Hard  
Pattern: HashMap Mapping  

## Problem

Each node in the linked list has:

- next pointer
- random pointer (pointing to any node in the list or null)

Create a deep copy of the list.

## Example

```
Node1 → Node2 → Node3
  ↓       ↓       ↓
random  random  random
```

The copied list must have the **same structure** but new nodes.

## Hint

Use a HashMap to store mapping between:

original node → copied node

## Solution

```java
public Node copyRandomList(Node head) {

    if (head == null) return null;

    HashMap<Node, Node> map = new HashMap<>();

    Node curr = head;

    while (curr != null) {
        map.put(curr, new Node(curr.val));
        curr = curr.next;
    }

    curr = head;

    while (curr != null) {
        Node copy = map.get(curr);
        copy.next = map.get(curr.next);
        copy.random = map.get(curr.random);
        curr = curr.next;
    }

    return map.get(head);
}
```

Time: O(n)  
Space: O(n)

## Key Learning

Mapping original nodes to copied nodes allows reconstruction of complex pointer structures.


# Summary

These problems test advanced Linked List concepts:

- Segment reversal
- Data structure design
- Pointer cloning

Mastering these problems indicates strong Linked List proficiency.
