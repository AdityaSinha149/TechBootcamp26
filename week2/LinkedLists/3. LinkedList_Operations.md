# Linked List Operations

This file covers the basic operations on a Singly Linked List.

These operations form the foundation for solving Linked List problems.

All examples use this node structure:

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

# 1️⃣ Traversal

Traversal means visiting each node sequentially.

Time Complexity: O(n)

```java
public void printList(ListNode head) {
    ListNode curr = head;

    while (curr != null) {
        System.out.print(curr.val + " ");
        curr = curr.next;
    }
}
```

Always start from head and move using `.next` until null.


# 2️⃣ Find Length of Linked List

Time Complexity: O(n)

```java
public int length(ListNode head) {
    int count = 0;
    ListNode curr = head;

    while (curr != null) {
        count++;
        curr = curr.next;
    }

    return count;
}
```


# 3️⃣ Insert at Head

Time Complexity: O(1)

```java
public ListNode insertAtHead(ListNode head, int val) {
    ListNode newNode = new ListNode(val);
    newNode.next = head;
    return newNode;
}
```

Important:
Always return the new head.


# 4️⃣ Insert at Tail

Time Complexity: O(n)

```java
public ListNode insertAtTail(ListNode head, int val) {
    ListNode newNode = new ListNode(val);

    if (head == null) return newNode;

    ListNode curr = head;
    while (curr.next != null) {
        curr = curr.next;
    }

    curr.next = newNode;
    return head;
}
```


# 5️⃣ Insert at a Given Position (0-based index)

If position is 0 → insert at head.

```java
public ListNode insertAtPosition(ListNode head, int val, int pos) {
    if (pos == 0) {
        return insertAtHead(head, val);
    }

    ListNode curr = head;
    int index = 0;

    while (curr != null && index < pos - 1) {
        curr = curr.next;
        index++;
    }

    if (curr == null) return head;

    ListNode newNode = new ListNode(val);
    newNode.next = curr.next;
    curr.next = newNode;

    return head;
}
```

Be careful:
Always stop at position - 1.


# 6️⃣ Delete Head

Time Complexity: O(1)

```java
public ListNode deleteHead(ListNode head) {
    if (head == null) return null;
    return head.next;
}
```


# 7️⃣ Delete Tail

Time Complexity: O(n)

```java
public ListNode deleteTail(ListNode head) {
    if (head == null || head.next == null) return null;

    ListNode curr = head;

    while (curr.next.next != null) {
        curr = curr.next;
    }

    curr.next = null;
    return head;
}
```


# 8️⃣ Delete by Value

Deletes first occurrence of given value.

```java
public ListNode deleteByValue(ListNode head, int key) {
    if (head == null) return null;

    if (head.val == key) return head.next;

    ListNode curr = head;

    while (curr.next != null && curr.next.val != key) {
        curr = curr.next;
    }

    if (curr.next != null) {
        curr.next = curr.next.next;
    }

    return head;
}
```


# 9️⃣ Delete at Position (0-based index)

```java
public ListNode deleteAtPosition(ListNode head, int pos) {
    if (head == null) return null;

    if (pos == 0) return head.next;

    ListNode curr = head;
    int index = 0;

    while (curr.next != null && index < pos - 1) {
        curr = curr.next;
        index++;
    }

    if (curr.next != null) {
        curr.next = curr.next.next;
    }

    return head;
}
```


# 🔟 Delete Node Without Head Pointer

Given only the node to delete (not the head).

Constraint:
Node is NOT the last node.

Example:
1 → 2 → 3 → 4  
Delete node with value 3  

Solution:
Copy next node’s value and skip next node.

```java
public void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
}
```

Why this works:
We overwrite current node with next node’s data.


# Pointer Update Order (Very Important)

When inserting or deleting:

Always store next reference before modifying.

Example:

```java
ListNode nextTemp = curr.next;
curr.next = newNode;
newNode.next = nextTemp;
```

If you change pointers in wrong order,
you may lose access to the remaining list.


# Common Mistakes

❌ Forgetting to update head  
❌ Not handling null list  
❌ Infinite loops  
❌ Incorrect position logic  
❌ Losing reference to next node  


# Time Complexity Summary

| Operation | Time |
|------------|--------|
| Traverse | O(n) |
| Length | O(n) |
| Insert at head | O(1) |
| Insert at tail | O(n) |
| Insert at position | O(n) |
| Delete head | O(1) |
| Delete tail | O(n) |
| Delete by value | O(n) |


# Final Advice

Before moving to advanced problems:

Make sure you can:

✔ Write all operations without looking  
✔ Handle edge cases  
✔ Understand pointer flow  

If operations are clear, advanced Linked List problems become much easier.
