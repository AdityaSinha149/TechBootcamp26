# Two Pointers Technique - Complete Guide

The Two Pointers technique is a powerful algorithmic pattern used to solve array and string problems efficiently. This guide will teach you everything you need to know to master this technique.

---

## Table of Contents
1. [What is Two Pointers?](#what-is-two-pointers)
2. [When to Use Two Pointers](#when-to-use-two-pointers)
3. [Types of Two Pointer Patterns](#types-of-two-pointer-patterns)
4. [Pattern 1: Opposite Direction](#pattern-1-opposite-direction-pointers)
5. [Pattern 2: Same Direction (Fast & Slow)](#pattern-2-same-direction-fast--slow)
6. [Pattern 3: Sliding Window Variant](#pattern-3-sliding-window-variant)
7. [Common Use Cases](#common-use-cases)
8. [Complexity Analysis](#complexity-analysis)
9. [Practice Exercises](#practice-exercises)

---

## What is Two Pointers?

The **Two Pointers technique** uses two references (pointers) to traverse through a data structure, typically an array or string. Instead of using nested loops (O(n²)), we use two pointers that move based on certain conditions, reducing time complexity to O(n).

### Simple Analogy
Imagine you're searching for a specific pair of books on a sorted bookshelf:
- **Naive approach**: Check every possible pair → O(n²)
- **Two pointers**: Start with one pointer at the beginning and one at the end, moving them intelligently → O(n)

---

## When to Use Two Pointers

Use the Two Pointers technique when:

✅ The array/string is **sorted** (or you can sort it)  
✅ You need to find **pairs, triplets, or subsequences**  
✅ You want to **partition** the array into sections  
✅ You need to **compare elements from opposite ends**  
✅ You want to **remove duplicates** in-place  
✅ You're dealing with **palindromes**  

❌ Don't use when:
- Elements need to be accessed randomly
- Order doesn't matter and sorting isn't helpful
- The problem requires examining all pairs explicitly

---

## Types of Two Pointer Patterns

### 1. Opposite Direction Pointers
Pointers start at opposite ends and move towards each other.

```
[1, 2, 3, 4, 5, 6]
 ↑              ↑
left          right
```

### 2. Same Direction (Fast & Slow)
Both pointers start at the beginning, one moves faster.

```
[1, 2, 3, 4, 5, 6]
 ↑  ↑
slow fast
```

### 3. Sliding Window Variant
Pointers create a window that expands or contracts.

```
[1, 2, 3, 4, 5, 6]
 ↑        ↑
left    right
```

---

## Pattern 1: Opposite Direction Pointers

### Concept
Start with one pointer at the **beginning** and one at the **end**. Move them towards each other based on some condition.

### When to Use
- Finding pairs in a sorted array
- Palindrome checking
- Reversing arrays/strings
- Container with most water problems

### Template Code
```java
public void oppositeDirection(int[] arr) {
    int left = 0;
    int right = arr.length - 1;
    
    while (left < right) {
        // Process current pair
        processElement(arr[left], arr[right]);
        
        // Move pointers based on condition
        if (someCondition) {
            left++;    // Move left pointer right
        } else {
            right--;   // Move right pointer left
        }
    }
}
```

### Example Problem: Two Sum II (Sorted Array)

**Problem:** Find two numbers in a sorted array that add up to a target.

**Input:** `numbers = [2, 7, 11, 15], target = 9`  
**Output:** `[1, 2]` (indices are 1-indexed)

**Visual Walkthrough:**

```
Step 1: numbers = [2, 7, 11, 15], target = 9
                   ↑            ↑
                  left        right
        sum = 2 + 15 = 17 > 9 → Move right left

Step 2: numbers = [2, 7, 11, 15]
                   ↑        ↑
                  left    right
        sum = 2 + 11 = 13 > 9 → Move right left

Step 3: numbers = [2, 7, 11, 15]
                   ↑  ↑
                  left right
        sum = 2 + 7 = 9 == 9 → Found! Return [1, 2]
```

**Why This Works:**
- Array is sorted: smaller values on left, larger on right
- If sum is too large → decrease it by moving `right` left
- If sum is too small → increase it by moving `left` right
- If equal → we found our pair!

**Complete Solution:**
```java
public int[] twoSum(int[] numbers, int target) {
    int left = 0;
    int right = numbers.length - 1;
    
    while (left < right) {
        int sum = numbers[left] + numbers[right];
        
        if (sum == target) {
            return new int[]{left + 1, right + 1}; // 1-indexed
        } else if (sum < target) {
            left++;  // Need larger sum
        } else {
            right--; // Need smaller sum
        }
    }
    
    return new int[]{}; // No solution found
}
```

**Complexity:**
- Time: O(n) - Each pointer moves at most n times
- Space: O(1) - Only using two variables

---

### Example Problem: Valid Palindrome

**Problem:** Check if a string is a palindrome (reads same forwards and backwards), ignoring non-alphanumeric characters.

**Input:** `"A man, a plan, a canal: Panama"`  
**Output:** `true` → "amanaplanacanalpanama" is a palindrome

**Visual Walkthrough:**
```
Step 1: "A man, a plan, a canal: Panama"
         ↑                              ↑
        left                          right
        'A' vs 'a' (after lowercase) → Match! Move both

Step 2: "A man, a plan, a canal: Panama"
           ↑                          ↑
          left                      right
          ' ' is not alphanumeric → Skip left

Step 3: "A man, a plan, a canal: Panama"
             ↑                    ↑
            left                right
            'm' vs 'm' → Match! Continue...
```

**Complete Solution:**
```java
public boolean isPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;
    
    while (left < right) {
        // Skip non-alphanumeric characters from left
        while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
            left++;
        }
        
        // Skip non-alphanumeric characters from right
        while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
            right--;
        }
        
        // Compare characters (case-insensitive)
        if (Character.toLowerCase(s.charAt(left)) != 
            Character.toLowerCase(s.charAt(right))) {
            return false;
        }
        
        left++;
        right--;
    }
    
    return true;
}
```

---

## Pattern 2: Same Direction (Fast & Slow)

### Concept
Both pointers start at the **beginning**. One moves **faster** than the other, creating a gap between them.

### When to Use
- Removing duplicates in-place
- Moving elements (e.g., move zeros to end)
- Partitioning arrays
- Finding middle of linked list

### Template Code
```java
public void fastSlow(int[] arr) {
    int slow = 0;  // Position for next valid element
    
    for (int fast = 0; fast < arr.length; fast++) {
        if (isValid(arr[fast])) {
            arr[slow] = arr[fast];
            slow++;
        }
    }
    
    // slow now points to the position after last valid element
}
```

### Example Problem: Remove Duplicates from Sorted Array

**Problem:** Remove duplicates in-place so each element appears only once.

**Input:** `nums = [1, 1, 2, 2, 2, 3, 4, 4]`  
**Output:** `4` (first 4 elements are `[1, 2, 3, 4]`)

**Visual Walkthrough:**
```
Initial: [1, 1, 2, 2, 2, 3, 4, 4]
          ↑  ↑
        slow fast

fast=1: nums[fast]=1 == nums[slow]=1 → Duplicate, skip
        [1, 1, 2, 2, 2, 3, 4, 4]
          ↑     ↑
        slow  fast

fast=2: nums[fast]=2 != nums[slow]=1 → Unique!
        slow++, copy nums[fast] to nums[slow]
        [1, 2, 2, 2, 2, 3, 4, 4]
             ↑     ↑
           slow  fast

fast=3: nums[fast]=2 == nums[slow]=2 → Duplicate, skip
        [1, 2, 2, 2, 2, 3, 4, 4]
             ↑        ↑
           slow     fast

fast=4: nums[fast]=2 == nums[slow]=2 → Duplicate, skip
        ...continues...

Result: [1, 2, 3, 4, _, _, _, _]
                    ↑
                  slow (length = 4)
```

**Why This Works:**
- `slow` points to the position for the next unique element
- `fast` scans through all elements
- When `nums[fast] != nums[slow]`, we found a new unique element
- Copy it to `slow + 1` and increment `slow`

**Complete Solution:**
```java
public int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;
    
    int slow = 0; // Position of last unique element
    
    for (int fast = 1; fast < nums.length; fast++) {
        if (nums[fast] != nums[slow]) {
            slow++;
            nums[slow] = nums[fast];
        }
    }
    
    return slow + 1; // Length of unique elements
}
```

**Complexity:**
- Time: O(n) - Single pass through array
- Space: O(1) - In-place modification

---

### Example Problem: Move Zeros

**Problem:** Move all zeros to the end while maintaining order of non-zero elements.

**Input:** `[0, 1, 0, 3, 12]`  
**Output:** `[1, 3, 12, 0, 0]`

**Visual Walkthrough:**
```
Initial:  [0, 1, 0, 3, 12]
           ↑  ↑
         slow fast

fast=0: nums[fast]=0 → Skip (don't increment slow)
        [0, 1, 0, 3, 12]
         ↑  ↑
       slow  fast

fast=1: nums[fast]=1 → Non-zero! Swap with slow position
        [1, 0, 0, 3, 12]
            ↑  ↑
          slow fast

fast=2: nums[fast]=0 → Skip
        [1, 0, 0, 3, 12]
            ↑     ↑
          slow  fast

fast=3: nums[fast]=3 → Non-zero! Swap
        [1, 3, 0, 0, 12]
               ↑     ↑
             slow  fast

fast=4: nums[fast]=12 → Non-zero! Swap
        [1, 3, 12, 0, 0]
                  ↑     ↑
                slow  fast
```

**Complete Solution:**
```java
public void moveZeroes(int[] nums) {
    int slow = 0; // Position for next non-zero element
    
    for (int fast = 0; fast < nums.length; fast++) {
        if (nums[fast] != 0) {
            // Swap nums[slow] and nums[fast]
            int temp = nums[slow];
            nums[slow] = nums[fast];
            nums[fast] = temp;
            slow++;
        }
    }
}
```

---

## Pattern 3: Sliding Window Variant

### Concept
Create a window with `left` and `right` pointers. The window **expands** (move right) or **contracts** (move left) based on conditions.

### When to Use
- Finding subarrays with specific properties
- Longest/shortest substring problems
- Maximum/minimum in a window

### Template Code
```java
public void slidingWindow(int[] arr) {
    int left = 0;
    
    for (int right = 0; right < arr.length; right++) {
        // Expand window by including arr[right]
        addToWindow(arr[right]);
        
        // Contract window while condition is violated
        while (windowConditionViolated()) {
            removeFromWindow(arr[left]);
            left++;
        }
        
        // Process current valid window
        updateResult();
    }
}
```

---

## Common Use Cases

| Problem Type | Pattern | Time Complexity |
|--------------|---------|-----------------|
| Two Sum (sorted) | Opposite Direction | O(n) |
| Three Sum | Opposite Direction (with outer loop) | O(n²) |
| Container With Most Water | Opposite Direction | O(n) |
| Valid Palindrome | Opposite Direction | O(n) |
| Remove Duplicates | Fast & Slow | O(n) |
| Move Zeros | Fast & Slow | O(n) |
| Longest Substring | Sliding Window | O(n) |
| Max Sum Subarray | Sliding Window | O(n) |

---

## Complexity Analysis

### Time Complexity
**O(n)** for most two-pointer problems because:
- Each pointer moves at most `n` times
- Total operations: 2n → O(n)

**Comparison with nested loops:**
- Nested loops: O(n²) → Check all pairs
- Two pointers: O(n) → Smart traversal

**Example: Finding a pair with target sum**
```java
// Brute force: O(n²)
for (int i = 0; i < n; i++) {
    for (int j = i + 1; j < n; j++) {
        if (arr[i] + arr[j] == target) {
            return new int[]{i, j};
        }
    }
}

// Two pointers: O(n)
int left = 0, right = n - 1;
while (left < right) {
    int sum = arr[left] + arr[right];
    if (sum == target) return new int[]{left, right};
    else if (sum < target) left++;
    else right--;
}
```

### Space Complexity
**O(1)** - Only using two pointer variables

---

## Practice Exercises

### Exercise 1: Container With Most Water
**Problem:** Given heights `[1,8,6,2,5,4,8,3,7]`, find two lines that form a container with the most water.

**Hint:** Start with widest container (left=0, right=n-1). Move the pointer with smaller height.

**Why?** Moving the smaller height might find a taller line, potentially increasing area.

---

### Exercise 2: Sort Colors (Dutch National Flag)
**Problem:** Sort `[2,0,2,1,1,0]` in-place where 0=red, 1=white, 2=blue.

**Hint:** Use three pointers: `low` (position for next 0), `mid` (current), `high` (position for next 2).

---

### Exercise 3: Reverse Words in String
**Problem:** Reverse "the sky is blue" to "blue is sky the".

**Hint:** Reverse entire string, then reverse each word individually.

---

## Tips and Common Pitfalls

### ✅ Do's
1. **Check boundaries:** Always ensure `left < right` or `left <= right` as appropriate
2. **Handle edge cases:** Empty array, single element, all same elements
3. **Update pointers correctly:** Make sure pointers move in right direction
4. **Sort if needed:** Many problems require sorted array

### ❌ Don'ts
1. **Infinite loops:** Ensure pointers move in each iteration
2. **Off-by-one errors:** Be careful with `<` vs `<=`
3. **Forget to handle duplicates:** Plan for duplicate elements
4. **Wrong pointer movement:** Moving wrong pointer can miss solutions

---

## Key Takeaways

1. **Two Pointers** reduces O(n²) to O(n) by smart traversal
2. **Three main patterns:** Opposite direction, Fast & slow, Sliding window
3. **Works best** with sorted arrays or when order matters
4. **Always O(1) space** - just using pointer variables
5. **Practice pattern recognition** - knowing when to use which pattern

---

## Next Steps

Now that you understand the Two Pointers technique, practice with:
- [Two Pointers Practice Problems](TwoPointers_Problems.md)
- Start with easy problems (Valid Palindrome, Remove Duplicates)
- Progress to medium (Container With Most Water, 3Sum)
- Master the patterns through repetition

**Remember:** The key is recognizing the pattern, not memorizing solutions! 🎯
