# Linked List Implementations

This folder contains reference implementations for different types of linked lists.

Included implementations:

- Singly Linked List
- Doubly Linked List
- Circular Linked List


# How You Should Use These Implementations

Try not to immediately read the code.

The goal is to **understand how pointers work**, not just copy the implementation.

Follow this learning process instead.


# Step 1: Draw the Structure

Before coding, draw the linked list on paper.

Example:

Singly Linked List

```
head → 1 → 2 → 3 → null
```

Doubly Linked List

```
null ← 1 ⇄ 2 ⇄ 3 → null
```

Circular Linked List

```
1 → 2 → 3 → 4
↑           ↓
└───────────┘
```


# Step 2: Simulate Operations

For each operation, draw how pointers change.

Example: Insert at Head

Before

```
head → 2 → 3 → 4 → null
```

Insert 1

After

```
head → 1 → 2 → 3 → 4 → null
```

Think about:

- What happens to `head`?
- What happens to `next` pointers?


# Step 3: Try Implementing Yourself

Before opening the solution files:

Try writing your own implementation for:

- insertAtHead
- insertAtTail
- delete
- traversal

Even if it is not perfect, that is okay.


# Step 4: Compare With the Reference Code

After attempting your own implementation:

Open the files in this folder and compare:

- How pointers were updated
- How edge cases were handled
- Whether your logic was correct


# Step 5: Dry Run the Code

Take a small example and trace pointer changes manually.

Example list:

```
1 → 2 → 3 → null
```

Now simulate:

- inserting a node
- deleting a node
- traversing the list

Understanding pointer movement is the key to mastering Linked Lists.


# Important Advice

Linked Lists are not difficult because of syntax.

They are difficult because of **pointer thinking**.

The more diagrams you draw, the easier they become.


# Final Tip

If you can implement:

- Insert
- Delete
- Traverse

without looking at code, then you truly understand Linked Lists.
