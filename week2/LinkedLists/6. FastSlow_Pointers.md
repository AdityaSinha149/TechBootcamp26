# Fast and Slow Pointer Technique

The Fast & Slow pointer technique is one of the most powerful patterns in Linked Lists.

It is used in:

- Finding the middle of a list
- Detecting a cycle
- Finding the start of a cycle
- Checking palindrome
- Splitting a list into two halves

This pattern reduces many problems from complex to simple.


# Core Idea

Use two pointers:

- Slow pointer → moves 1 step at a time
- Fast pointer → moves 2 steps at a time

Because fast moves twice as quickly, interesting relationships emerge.


# Pattern Template

```java
ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
}
```

Important:
Always check `fast != null && fast.next != null`.


# 1️⃣ Finding the Middle of Linked List

Example:

1 → 2 → 3 → 4 → 5

Movement:

Step 1:
slow = 2  
fast = 3  

Step 2:
slow = 3  
fast = 5  

Step 3:
fast.next is null → stop  

Middle = 3  

Code:

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


Even length case:

1 → 2 → 3 → 4  

Slow ends at 3  
(Second middle)

This is expected behavior in most problems.


# 2️⃣ Detecting a Cycle (Floyd’s Algorithm)

If there is a cycle:

The fast pointer will eventually meet the slow pointer.

Example:

1 → 2 → 3 → 4  
      ↑       ↓
      ← ← ← ← ←

Why they meet:

Fast moves 2 steps  
Slow moves 1 step  

Inside a loop, fast "laps" slow.


Code:

```java
public boolean hasCycle(ListNode head) {
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


# 3️⃣ Why Cycle Detection Works (Mathematical Insight)

Let:

- Distance from head to cycle start = L
- Cycle length = C
- Distance inside cycle where they meet = X

When slow enters cycle:
Fast is already ahead.

Since fast moves twice as fast:

Distance fast = 2 × distance slow

When they meet:

2(L + X) = L + X + kC

Solving:

L = kC − X

This means:

If you start one pointer at head,
and one at meeting point,
and move both 1 step at a time,

They meet at cycle start.


# 4️⃣ Finding Start of Cycle

After slow and fast meet:

Step 1:
Place one pointer at head

Step 2:
Move both pointers one step at a time

They meet at cycle start.


Code:

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


# 5️⃣ Using Fast/Slow for Palindrome

Steps:

1. Find middle using fast/slow
2. Reverse second half
3. Compare both halves

This combines multiple patterns.


# 6️⃣ Splitting a Linked List

Fast/Slow is used to split list into two halves.

Used in:
- Merge Sort on Linked List
- Reorder List


# Common Mistakes

❌ Forgetting to check `fast.next != null`  
❌ Using wrong loop condition  
❌ Moving fast only one step  
❌ Not resetting pointer when finding cycle start  


# Edge Cases

✔ head == null  
✔ head.next == null  
✔ Two nodes only  
✔ Single node cycle  
✔ No cycle  


# How to Recognize This Pattern in Questions

Look for words like:

- Middle
- Cycle
- Loop
- Split
- Half
- Palindrome
- Nth from end (sometimes combined)

If you see these → Think Fast/Slow.


# Final Mental Model

Slow pointer walks normally.  
Fast pointer runs ahead.

If there's no cycle → fast hits null.  
If there's a cycle → fast eventually catches slow.

This small trick solves many powerful problems.

Master this pattern and Linked Lists become much easier.
