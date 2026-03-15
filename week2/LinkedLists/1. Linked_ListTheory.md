# Linked List - Theory & Foundations

A Linked List is a linear data structure where elements are stored in nodes, 
and each node is connected using references (pointers).

Unlike arrays, linked lists do NOT store elements in contiguous memory.


# Why Do We Need Linked Lists?

Arrays have limitations:

- Fixed size (in many languages)
- Insertion in middle → O(n)
- Deletion in middle → O(n)
- Requires shifting elements

Linked Lists solve:

✔ Dynamic size  
✔ Efficient insertion (if pointer known)  
✔ Flexible memory allocation  


# Core Idea

A linked list is a collection of nodes.

Each node contains:

1. Data  
2. Reference to another node  

Everything in Linked List problems is about correct pointer manipulation.


# Basic Node Structure (Singly Linked List)

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

- `val` stores data
- `next` stores reference to next node
- If `next == null`, it is the last node


# Memory Representation

Nodes are stored in random memory locations, not next to each other.

Example:

Node A → memory 1000  
Node B → memory 4500  
Node C → memory 2300  

They are connected via references:

1000 → 4500 → 2300 → null  

This is why linked lists do NOT require contiguous memory.


# Head Pointer

The `head` stores the reference to the first node.

```
head → [10] → [20] → [30] → null
```

If:

```
head == null
```

The list is empty.

If you lose the head reference, the entire list becomes inaccessible.


# Pointer Manipulation (Most Important Concept)

Linked Lists are simple conceptually.

But they are fragile.

If you change pointers in the wrong order,
you can permanently lose part of the list.

Example:

1 → 2 → 3 → 4 → null  

If you accidentally do:

```java
curr.next = curr.next.next;
```

without storing the reference first,
you may lose access to nodes.

Always:

✔ Store next reference before modifying  
✔ Update pointers carefully  
✔ Remember that order matters  


# Traversal Concept

Traversal means visiting each node one by one.

Time Complexity: O(n)

Basic idea:

Start from head  
Move using `.next`  
Stop when null  

All Linked List algorithms rely on traversal.


# Time Complexity Overview

| Operation | Time |
|------------|--------|
| Access ith element | O(n) |
| Insert at head | O(1) |
| Insert at tail | O(n) |
| Delete | O(n) |
| Traverse | O(n) |

Linked Lists are good at insertion/deletion,  
but bad at random access.


# Linked List vs Array (Conceptual Comparison)

| Feature | Array | Linked List |
|----------|--------|--------------|
| Memory | Contiguous | Non-contiguous |
| Random Access | O(1) | O(n) |
| Insert/Delete | Expensive | Efficient (pointer-based) |
| Size | Fixed | Dynamic |


# Why Beginners Find Linked Lists Hard

1. Pointer thinking
2. Losing references
3. Handling edge cases
4. Null pointer exceptions
5. Incorrect order of updates

Once pointer flow becomes clear, Linked Lists become easy.


# Mental Checklist While Solving Problems

When solving any Linked List problem, always ask:

1. Where is my head?
2. Do I need a dummy node?
3. Am I modifying next before storing it?
4. What happens if list has only 1 node?
5. What happens if head changes?


# Interview Pattern Preview

Most Linked List problems fall into these categories:

1. Reverse pattern
2. Fast & Slow pointer pattern
3. Dummy node pattern
4. Two pointer gap pattern
5. Merge pattern
6. HashMap + Doubly Linked List (LRU)

Each of these will be covered separately.


# Important Edge Cases

Always check:

✔ head == null  
✔ head.next == null  
✔ Removing head  
✔ Single element list  
✔ Even vs odd length  
✔ Cycle exists  


# Final Takeaway

Linked Lists are:

- Dynamic  
- Pointer-based  
- Powerful for interviews  
- Sensitive to mistakes  

If you master pointer manipulation,  
you master Linked Lists.

Next: Understand the different types of Linked Lists and how they differ structurally.
