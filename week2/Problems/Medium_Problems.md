# Medium Linked List Problems

These problems combine multiple Linked List patterns.

Students should attempt these only after completing the easy problems.

Common patterns used here include:

- Dummy Node
- Two Pointer Gap
- Fast & Slow Pointer
- Reverse Pattern
- Pattern Combination


# 1️⃣ Remove Nth Node From End (LC 19)

Difficulty: Medium  
Pattern: Two Pointer Gap + Dummy Node  

## Problem

Given the head of a linked list, remove the nth node from the end of the list and return its head.

## Example

Input:
1 → 2 → 3 → 4 → 5  
n = 2  

Output:
1 → 2 → 3 → 5  

## Hint

Maintain a gap of **n nodes** between two pointers.

## Solution

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

Time: O(n)  
Space: O(1)

## Key Learning

Maintaining a fixed gap allows us to locate nodes from the end in one traversal.


# 2️⃣ Linked List Cycle II (LC 142)

Difficulty: Medium  
Pattern: Fast & Slow Pointer  

## Problem

Given a linked list, return the node where the cycle begins.  
If there is no cycle, return null.

## Example

```
1 → 2 → 3 → 4
      ↑       ↓
      └───────┘
```

Output: Node with value 2

## Hint

After slow and fast meet, start one pointer from head.

## Solution

```java
public ListNode detectCycle(ListNode head) {
    if (head == null) return null;

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

Time: O(n)  
Space: O(1)

## Key Learning

The meeting point inside the cycle can help determine the start of the cycle.


# 3️⃣ Intersection of Two Linked Lists (LC 160)

Difficulty: Medium  
Pattern: Two Pointer Switching  

## Problem

Return the node where two linked lists intersect.  
If they do not intersect, return null.

## Example

```
List A: 1 → 2 → 3 \
                     → 7 → 8
List B:      4 → 5 /
```

Output: Node with value 7

## Hint

Switch heads when pointer reaches null.

## Solution

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

## Key Learning

Pointer switching ensures both pointers travel equal distance.


# 4️⃣ Add Two Numbers (LC 2)

Difficulty: Medium  
Pattern: Linked List Simulation  

## Problem

Two numbers are represented as linked lists where digits are stored in reverse order.

Add the numbers and return the sum as a linked list.

## Example

Input:

2 → 4 → 3  
5 → 6 → 4  

Output:

7 → 0 → 8  

Explanation:
342 + 465 = 807

## Hint

Simulate column-wise addition.

## Solution

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

Time: O(n)  
Space: O(1)

## Key Learning

Linked lists can represent numbers and support digit-by-digit operations.


# 5️⃣ Palindrome Linked List (LC 234)

Difficulty: Medium  
Pattern: Fast/Slow + Reverse  

## Problem

Check whether a linked list is a palindrome.

## Example

Input:
1 → 2 → 2 → 1  

Output:
true

## Hint

1. Find middle  
2. Reverse second half  
3. Compare both halves  

## Solution

```java
public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) return true;

    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    ListNode prev = null;
    ListNode curr = slow;

    while (curr != null) {
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }

    ListNode first = head;
    ListNode second = prev;

    while (second != null) {
        if (first.val != second.val) return false;
        first = first.next;
        second = second.next;
    }

    return true;
}
```

Time: O(n)  
Space: O(1)

## Key Learning

Combining patterns often solves medium-level problems.


# 6️⃣ Reverse Linked List II (LC 92)

Difficulty: Medium  
Pattern: Reverse Sublist  

## Problem

Reverse the nodes of a linked list from position **left** to **right**.

## Example

Input:
1 → 2 → 3 → 4 → 5  
left = 2, right = 4  

Output:
1 → 4 → 3 → 2 → 5  

## Hint

Find node before left and reverse the sublist.

## Solution

```java
public ListNode reverseBetween(ListNode head, int left, int right) {
    if (head == null) return null;

    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode prev = dummy;

    for (int i = 1; i < left; i++) {
        prev = prev.next;
    }

    ListNode curr = prev.next;

    for (int i = 0; i < right - left; i++) {
        ListNode temp = curr.next;
        curr.next = temp.next;
        temp.next = prev.next;
        prev.next = temp;
    }

    return dummy.next;
}
```

Time: O(n)  
Space: O(1)

## Key Learning

Sublist reversal requires careful pointer reconnection.


# Summary

After completing these problems, students should understand:

- Two pointer gap technique
- Detecting and locating cycles
- Pointer switching tricks
- Combining patterns
- Sublist reversal
- Linked list arithmetic

These problems bridge the gap between basic Linked List operations and advanced interview problems.
