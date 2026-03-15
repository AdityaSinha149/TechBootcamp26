# Linked List Patterns

Most Linked List problems in interviews are not random.

They follow a small number of repeatable patterns.

If you master these patterns, you can solve 80–90% of Linked List questions.


# Pattern 1: Reverse Pattern

Used in:
- Reverse Linked List
- Reverse in K groups
- Palindrome Linked List
- Reorder List

Core Idea:
Reverse the direction of `.next` pointers.

Template:

```java
public ListNode reverse(ListNode head) {
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

Key Learning:
Always store `nextTemp` before modifying `curr.next`.

Time: O(n)  
Space: O(1)


# Pattern 2: Fast and Slow Pointer

Used in:
- Find middle
- Detect cycle
- Find start of cycle
- Palindrome Linked List

Core Idea:
One pointer moves 1 step.
Other pointer moves 2 steps.

Template:

```java
ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
}
```

Why it works:
Fast pointer covers double distance.
Useful for detecting loops and splitting lists.


# Pattern 3: Two Pointer Gap Technique

Used in:
- Remove Nth Node From End
- Find kth node from end

Core Idea:
Maintain a gap of `n` nodes between two pointers.

Template:

```java
ListNode fast = head;
ListNode slow = head;

for (int i = 0; i < n; i++) {
    fast = fast.next;
}

while (fast != null) {
    fast = fast.next;
    slow = slow.next;
}
```

When fast reaches null,
slow is at required position.


# Pattern 4: Dummy Node Pattern

Used in:
- Remove node
- Merge lists
- Edge-case-heavy problems

Core Idea:
Add a fake node before head.

Why?
To avoid special handling when head changes.

Template:

```java
ListNode dummy = new ListNode(0);
dummy.next = head;

ListNode curr = dummy;

// perform operations

return dummy.next;
```

This makes code cleaner and safer.


# Pattern 5: Merge Pattern

Used in:
- Merge Two Sorted Lists
- Merge K Lists
- Sort List

Core Idea:
Use a dummy node and compare values.

Template:

```java
ListNode dummy = new ListNode(0);
ListNode curr = dummy;

while (l1 != null && l2 != null) {
    if (l1.val < l2.val) {
        curr.next = l1;
        l1 = l1.next;
    } else {
        curr.next = l2;
        l2 = l2.next;
    }
    curr = curr.next;
}

curr.next = (l1 != null) ? l1 : l2;

return dummy.next;
```

Important:
Never lose references while merging.


# Pattern 6: HashMap + Linked List

Used in:
- LRU Cache
- Copy List with Random Pointer
- Detect duplicates

Core Idea:
Use a HashMap for O(1) lookup
Use Doubly Linked List for O(1) insertion/deletion

This pattern combines:
- Data structure design
- Pointer manipulation
- Hashing

Example Use Case:
LRU Cache


# Pattern 7: Split and Reconnect

Used in:
- Reorder List
- Palindrome Linked List
- Reverse in K groups

Steps:
1. Find middle (Fast/Slow)
2. Reverse second half
3. Merge or compare

This is a combination pattern.


# Pattern 8: Cycle Detection Logic

Used in:
- Detect cycle
- Find cycle start

Core Idea:
If fast and slow meet → cycle exists.

To find cycle start:

```java
if (slow == fast) {
    ListNode entry = head;
    while (entry != slow) {
        entry = entry.next;
        slow = slow.next;
    }
    return entry;
}
```

This works because of mathematical distance property.


# How to Identify Pattern in a Question

Look for keywords:

"reverse" → Reverse pattern  
"middle" → Fast/Slow  
"nth from end" → Two pointer gap  
"merge" → Merge pattern  
"design cache" → HashMap + Doubly List  
"cycle" → Fast/Slow  

Questions usually hide pattern in description.


# Pattern Combination Problems

Hard problems combine multiple patterns.

Example:
Palindrome Linked List

1. Find middle (Fast/Slow)
2. Reverse second half
3. Compare both halves

This is why mastering individual patterns is important.


# Mental Strategy for Any Linked List Problem

Step 1: Identify pattern  
Step 2: Decide if dummy node is needed  
Step 3: Draw small example  
Step 4: Track pointer movement  
Step 5: Handle edge cases  

Do not directly start coding.


# Final Advice

If you master these patterns:

- Reverse
- Fast & Slow
- Dummy Node
- Two Pointer Gap
- Merge
- HashMap + Doubly List

You will be comfortable with most Linked List interview questions.

Linked Lists are not about memorizing problems.

They are about mastering pointer patterns.
