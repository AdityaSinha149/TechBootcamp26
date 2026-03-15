# Linked List Types

Linked Lists can be classified based on how nodes are connected.

There are three primary types:

1. Singly Linked List  
2. Doubly Linked List  
3. Circular Linked List  

This file focuses only on structural differences and use-cases.


# 1️⃣ Singly Linked List

## Structure

Each node contains:
- Data
- Pointer to next node

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

## Visualization

```
head → [10] → [20] → [30] → null
```

- Each node points forward only
- Last node points to null


## Properties

- Unidirectional traversal
- Simplest linked list
- Most common in interviews


## Advantages

✔ Less memory usage  
✔ Simple implementation  
✔ Efficient insertion at head  


## Disadvantages

❌ Cannot traverse backwards  
❌ Need previous node reference to delete a node  


## Common Interview Usage

- Reverse Linked List
- Detect Cycle
- Find Middle
- Merge Lists
- Remove Nth Node


Most Linked List problems use Singly Linked Lists.


# 2️⃣ Doubly Linked List

## Structure

Each node contains:
- Data
- Pointer to next node
- Pointer to previous node

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

## Visualization

```
null ← [10] ⇄ [20] ⇄ [30] → null
```

- Each node links in both directions
- First node’s prev is null
- Last node’s next is null


## Properties

- Bidirectional traversal
- Easier deletion (no need to search for previous node separately)
- Requires extra memory


## Advantages

✔ Can move forward and backward  
✔ Easier removal of node (given pointer)  
✔ Useful for cache design  


## Disadvantages

❌ Extra memory per node  
❌ Slightly more complex pointer updates  


## Common Usage

- LRU Cache
- Browser history
- Undo / Redo functionality
- Backtracking systems


Doubly Linked Lists are important for design problems.


# 3️⃣ Circular Linked List

In a circular linked list, the last node connects back to the head.

There is no null at the end.

## Structure (Singly Circular)

```java
class CircularNode {
    int val;
    CircularNode next;

    CircularNode(int val) {
        this.val = val;
    }
}
```

## Visualization

```
      ↓
[1] → [2] → [3] → [4]
 ↑                   ↓
 ← ← ← ← ← ← ← ← ← ←
```

The last node links back to the first node.


## Properties

- No null termination
- Traversal must stop manually
- Can start from any node


## Advantages

✔ Useful for cyclic processes  
✔ Good for simulations  
✔ Efficient for round-based systems  


## Disadvantages

❌ Risk of infinite loops  
❌ Must carefully define stopping condition  


## Common Usage

- Round Robin scheduling
- Multiplayer turn systems
- Circular buffers
- Music playlists


# 4️⃣ Circular Doubly Linked List

Each node has:

- prev pointer
- next pointer
- Last node connects to first
- First node connects to last

## Visualization

```
       ⇄
  [1] ⇄ [2] ⇄ [3] ⇄ [4]
   ↑                     ↓
   ← ← ← ← ← ← ← ← ← ← ←
```

Used in more advanced system-level implementations.


# Comparison Summary

| Feature | Singly | Doubly | Circular |
|----------|--------|--------|----------|
| Direction | One-way | Two-way | Circular |
| Memory Usage | Low | Higher | Depends |
| Backward Traversal | No | Yes | Depends |
| Null Termination | Yes | Yes | No |
| Interview Frequency | Very High | High | Medium |


# When To Choose Which?

Use Singly Linked List when:
- Solving standard interview problems
- Practicing pointer manipulation
- Implementing basic data structures

Use Doubly Linked List when:
- You need O(1) deletion given a node
- Designing LRU Cache
- Maintaining order with frequent removals

Use Circular Linked List when:
- Modeling cyclic systems
- Simulating rotation-based logic
- Implementing round-robin scheduling


# Final Note

For interviews and competitive programming:

Master Singly Linked List first.

Understand Doubly Linked List for design problems.

Circular Linked Lists are usually conceptual unless explicitly asked.
