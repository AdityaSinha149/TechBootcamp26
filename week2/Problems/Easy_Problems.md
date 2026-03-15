# Easy Linked List Problems

These problems reinforce core Linked List patterns.

Master these before moving to medium problems.

# 1️⃣ Reverse Linked List (LC 206)

Difficulty: Easy  
Pattern: Reverse Pattern  

## Problem

Given the head of a singly linked list, reverse the list and return the new head.

## Example

Input:
1 → 2 → 3 → null  

Output:
3 → 2 → 1 → null  

## Hint

Use three pointers:
- prev
- curr
- nextTemp

## Solution (Iterative)

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

## Key Learning

Master pointer order:
Store → Reverse → Move  


# 2️⃣ Middle of Linked List (LC 876)

Difficulty: Easy  
Pattern: Fast & Slow Pointer  

## Problem

Return the middle node of a linked list.  
If there are two middle nodes, return the second one.

## Example

Input:
1 → 2 → 3 → 4 → 5  

Output:
3  

## Hint

Move:
- Slow pointer 1 step
- Fast pointer 2 steps

## Solution

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

Time: O(n)  
Space: O(1)

## Key Learning

Fast pointer reaching end guarantees slow at middle.


# 3️⃣ Linked List Cycle (LC 141)

Difficulty: Easy  
Pattern: Fast & Slow Pointer  

## Problem

Return true if there is a cycle in the linked list.

## Example

```
1 → 2 → 3 → 4
      ↑       ↓
      └───────┘
```

Output:
true  

## Hint

If fast and slow meet → cycle exists.

## Solution

```java
public boolean hasCycle(ListNode head) {
    if (head == null) return false;

    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;

        if (slow == fast) {
            return true;
        }
    }

    return false;
}
```

Time: O(n)  
Space: O(1)

## Key Learning

Fast catches slow inside a loop.


# 4️⃣ Merge Two Sorted Lists (LC 21)

Difficulty: Easy  
Pattern: Merge Pattern + Dummy Node  

## Problem

Merge two sorted linked lists into one sorted list.

## Example

List 1:
1 → 3 → 5  

List 2:
2 → 4 → 6  

Output:
1 → 2 → 3 → 4 → 5 → 6  

## Hint

Use a dummy node to simplify head handling.

## Solution

```java
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;

    while (l1 != null && l2 != null) {
        if (l1.val <= l2.val) {
            curr.next = l1;
            l1 = l1.next;
        } else {
            curr.next = l2;
            l2 = l2.next;
        }
        curr = curr.next;
    }

    if (l1 != null) curr.next = l1;
    if (l2 != null) curr.next = l2;

    return dummy.next;
}
```

Time: O(n + m)  
Space: O(1)

## Key Learning

Dummy node removes edge case complexity.


# 5️⃣ Remove Linked List Elements (LC 203)

Difficulty: Easy  
Pattern: Dummy Node  

## Problem

Remove all nodes with a given value.

## Example

Input:
1 → 2 → 6 → 3 → 4 → 5 → 6  
Remove value = 6  

Output:
1 → 2 → 3 → 4 → 5  

## Hint

Use a dummy node to handle deletion at head.

## Solution

```java
public ListNode removeElements(ListNode head, int val) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode curr = dummy;

    while (curr.next != null) {
        if (curr.next.val == val) {
            curr.next = curr.next.next;
        } else {
            curr = curr.next;
        }
    }

    return dummy.next;
}
```

Time: O(n)  
Space: O(1)

## Key Learning

Dummy node prevents special handling of head removal.


# Summary

After completing these problems, students should be comfortable with:

- Reverse pattern
- Fast & Slow pointers
- Merge pattern
- Dummy node technique
- Safe pointer manipulation

Do not move to medium problems unless these feel easy.
