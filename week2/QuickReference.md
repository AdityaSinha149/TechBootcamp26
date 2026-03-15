# Linked Lists - Quick Reference Sheet

This document contains essential patterns, templates, and code snippets
for solving Linked List problems in Java.

Use this for:
- Quick revision
- Interview preparation
- Contest reference
- Exam preparation

---

# 1️⃣ Basic Node Structure (Singly Linked List)

```java
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
```

---

# 2️⃣ Doubly Linked List Node

```java
class DoublyNode {
    int val;
    DoublyNode prev;
    DoublyNode next;

    DoublyNode(int val) {
        this.val = val;
    }
}
```

---

# 3️⃣ Reverse Linked List (LC 206)

## Pattern: 3 Pointer Technique

Visual:

1 → 2 → 3 → null  
Becomes  
3 → 2 → 1 → null  

```java
public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;

    while (curr != null) {
        ListNode nextTemp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nextTemp;
    }

    return prev;
}
```

Time: O(n)  
Space: O(1)

---

# 4️⃣ Fast & Slow Pointer Pattern

## When to Use:
- Find middle
- Detect cycle
- Find start of cycle
- Palindrome check

```java
ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
}
```

---

# 5️⃣ Find Middle of Linked List (LC 876)

```java
public ListNode middleNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    return slow;
}
```

---

# 6️⃣ Detect Cycle (LC 141)

```java
public boolean hasCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;

        if (slow == fast) return true;
    }

    return false;
}
```

---

# 7️⃣ Find Start of Cycle (LC 142)

```java
public ListNode detectCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;

        if (slow == fast) {
            ListNode entry = head;

            while (entry != slow) {
                entry = entry.next;
                slow = slow.next;
            }

            return entry;
        }
    }

    return null;
}
```

---

# 8️⃣ Remove Nth Node From End (LC 19)

## Pattern: Two Pointers + Dummy Node

```java
public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode fast = dummy;
    ListNode slow = dummy;

    for (int i = 0; i <= n; i++) {
        fast = fast.next;
    }

    while (fast != null) {
        fast = fast.next;
        slow = slow.next;
    }

    slow.next = slow.next.next;

    return dummy.next;
}
```

---

# 9️⃣ Merge Two Sorted Lists (LC 21)

```java
public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;

    while (list1 != null && list2 != null) {
        if (list1.val < list2.val) {
            curr.next = list1;
            list1 = list1.next;
        } else {
            curr.next = list2;
            list2 = list2.next;
        }
        curr = curr.next;
    }

    if (list1 != null) curr.next = list1;
    if (list2 != null) curr.next = list2;

    return dummy.next;
}
```

---

# 🔟 Intersection of Two Linked Lists (LC 160)

```java
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) return null;

    ListNode a = headA;
    ListNode b = headB;

    while (a != b) {
        a = (a == null) ? headB : a.next;
        b = (b == null) ? headA : b.next;
    }

    return a;
}
```

Time: O(n + m)  
Space: O(1)

---

# 1️⃣1️⃣ Palindrome Linked List (LC 234)

```java
public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) return true;

    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    ListNode secondHalf = reverseList(slow);
    ListNode firstHalf = head;

    while (secondHalf != null) {
        if (firstHalf.val != secondHalf.val) return false;
        firstHalf = firstHalf.next;
        secondHalf = secondHalf.next;
    }

    return true;
}
```

---

# 1️⃣2️⃣ Add Two Numbers (LC 2)

```java
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;

    int carry = 0;

    while (l1 != null || l2 != null || carry != 0) {
        int sum = carry;

        if (l1 != null) {
            sum += l1.val;
            l1 = l1.next;
        }

        if (l2 != null) {
            sum += l2.val;
            l2 = l2.next;
        }

        curr.next = new ListNode(sum % 10);
        carry = sum / 10;
        curr = curr.next;
    }

    return dummy.next;
}
```

---

# 1️⃣3️⃣ LRU Cache (LC 146)

## Core Idea:
- HashMap for O(1) lookup
- Doubly Linked List for O(1) insert/remove

```java
import java.util.*;

class LRUCache {

    class Node {
        int key, value;
        Node prev, next;
    }

    private int capacity;
    private Map<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node();
        tail = new Node();
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

---

# Dummy Node Pattern

Use when:
- Removing head
- Merging lists
- Handling edge cases

```java
ListNode dummy = new ListNode(0);
dummy.next = head;
```

---

# ⭐ Important Edge Cases Checklist

✔ head == null  
✔ Single node  
✔ Removing head  
✔ Removing last node  
✔ Even vs Odd length  
✔ Cycle exists  
✔ n equals length  

---

# ⭐ Time Complexity Summary

| Operation | Time |
|------------|--------|
| Traverse | O(n) |
| Reverse | O(n) |
| Detect Cycle | O(n) |
| Insert at head | O(1) |
| Merge Lists | O(n) |
| LRU get/put | O(1) |

---

# 🚀 Master These 5 Patterns

1. Reverse  
2. Fast & Slow  
3. Dummy Node  
4. Merge  
5. HashMap + Doubly List  

If you master these, you can solve 90% of Linked List problems.
