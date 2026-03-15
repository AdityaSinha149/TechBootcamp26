# Reverse Linked List

Reversing a Linked List is one of the most important Linked List problems.

It teaches:
- Pointer manipulation
- Order of updates
- Safe reference handling

If you master this, many advanced problems become easier.


# Problem Statement

Given the head of a singly linked list, reverse the list and return the new head.

Example:

Input:
1 → 2 → 3 → null

Output:
3 → 2 → 1 → null


# Core Idea

We reverse the direction of `.next` pointers.

Original direction:

1 → 2 → 3 → null

After reversing:

1 ← 2 ← 3 ← null

Which becomes:

3 → 2 → 1 → null


# Visual Step-by-Step Explanation

Initial:

prev = null  
curr = 1  

List:
null ← 1 → 2 → 3 → null  

Step 1:

Store next:
nextTemp = 2  

Reverse pointer:
1 → null  

Move pointers:
prev = 1  
curr = 2  

Now:

null ← 1    2 → 3 → null  

Step 2:

nextTemp = 3  
2 → 1  
prev = 2  
curr = 3  

Now:

null ← 1 ← 2    3 → null  

Step 3:

nextTemp = null  
3 → 2  
prev = 3  
curr = null  

Final:

3 → 2 → 1 → null  


# Iterative Solution (Most Important)

Time Complexity: O(n)  
Space Complexity: O(1)

```java
public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;

    while (curr != null) {
        ListNode nextTemp = curr.next;  // store next
        curr.next = prev;               // reverse pointer
        prev = curr;                    // move prev
        curr = nextTemp;                // move curr
    }

    return prev;
}
```

Important Order:

1. Store next
2. Reverse pointer
3. Move prev
4. Move curr

If order changes, you may lose the list.


# Recursive Solution

Concept:
Reverse smaller list and attach head at the end.

```java
public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }

    ListNode newHead = reverseList(head.next);

    head.next.next = head;
    head.next = null;

    return newHead;
}
```

How it works:

1 → 2 → 3  

Recursive call reverses 2 → 3  
Then attach 1 at the end.

Recursive stack depth: O(n)


# Reverse First N Nodes (Concept)

Sometimes problems require reversing only part of list.

Example:
Reverse first 3 nodes of:

1 → 2 → 3 → 4 → 5  

Result:
3 → 2 → 1 → 4 → 5  

This uses similar logic but careful reconnection.


# Reverse Between Left and Right (LC 92 Concept)

Example:

1 → 2 → 3 → 4 → 5  
left = 2, right = 4  

Result:

1 → 4 → 3 → 2 → 5  

Idea:

1. Reach node before left
2. Reverse sublist
3. Reconnect edges


# Reverse in K Groups (Concept Preview)

Example:

1 → 2 → 3 → 4 → 5 → 6  
k = 2  

Result:

2 → 1 → 4 → 3 → 6 → 5  

This uses:
- Loop
- Reverse pattern
- Careful reconnection

Reverse is the base for many advanced problems.


# Common Mistakes

❌ Forgetting to store nextTemp  
❌ Returning head instead of prev  
❌ Not handling single node case  
❌ Losing reference to rest of list  
❌ Infinite loop due to wrong pointer update  


# Edge Cases

✔ head == null  
✔ head.next == null  
✔ Only two nodes  
✔ Large list  


# Why Reverse is So Important

Reverse is used in:

- Palindrome Linked List
- Reorder List
- Reverse in K groups
- Swap pairs
- Rotate list
- Merge operations
- Add Two Numbers (indirectly)

Master reverse → master Linked Lists.


# Final Mental Model

Think of it like:

You are flipping arrows one by one.

Always remember:

Store next  
Flip pointer  
Move forward  

Repeat until null.

Once this becomes natural, Linked Lists become much easier.
