# Kadane's Algorithm - Complete Guide

Kadane's Algorithm is an elegant and powerful technique for solving the **Maximum Subarray Problem**. This guide will teach you everything from basic intuition to advanced applications.

---

## Table of Contents
1. [The Problem: Maximum Subarray](#the-problem-maximum-subarray)
2. [Building Intuition](#building-intuition)
3. [The Brute Force Approach](#the-brute-force-approach)
4. [Discovering Kadane's Algorithm](#discovering-kadanes-algorithm)
5. [How Kadane's Algorithm Works](#how-kadanes-algorithm-works)
6. [Detailed Examples](#detailed-examples)
7. [Why Does It Work?](#why-does-it-work)
8. [Edge Cases](#edge-cases)
9. [Variations and Extensions](#variations-and-extensions)
10. [Practice Exercises](#practice-exercises)

---

## The Problem: Maximum Subarray

### Problem Statement
Given an integer array (which may contain negative numbers), find the **contiguous subarray** with the **largest sum** and return that sum.

### Examples

**Example 1:**
```
Input: [-2, 1, -3, 4, -1, 2, 1, -5, 4]
Output: 6
Explanation: The subarray [4, -1, 2, 1] has the largest sum = 6
```

**Example 2:**
```
Input: [5, 4, -1, 7, 8]
Output: 23
Explanation: The entire array [5, 4, -1, 7, 8] has sum = 23
```

**Example 3:**
```
Input: [-2, -3, -1, -5]
Output: -1
Explanation: All numbers are negative, so we choose the least negative: -1
```

---

## Building Intuition

Let's understand the problem step by step with a simple array.

### Simple Example: `[1, -3, 2, -1, 3]`

**Think about it:**
- Should I include `-3` in my subarray? It decreases the sum!
- But if I skip it, I miss `2` which comes after
- When should I "start fresh" vs "continue"?

**Let's try all possibilities:**
```
[1]           → sum = 1
[1, -3]       → sum = -2 (worse!)
[1, -3, 2]    → sum = 0  (still not great)
[2]           → sum = 2  (better to start fresh here!)
[2, -1]       → sum = 1
[2, -1, 3]    → sum = 4  (best!)
[3]           → sum = 3
```

**Key Insight:** Starting from `2` and going to the end gives us the maximum sum of 4.

**The Question:** How do we know when to "start fresh" vs "keep going"?

---

## The Brute Force Approach

### Idea
Check every possible subarray and track the maximum sum.

### Code
```java
public int maxSubArrayBruteForce(int[] nums) {
    int maxSum = Integer.MIN_VALUE;
    
    // Try all starting positions
    for (int start = 0; start < nums.length; start++) {
        int currentSum = 0;
        
        // Try all ending positions from start
        for (int end = start; end < nums.length; end++) {
            currentSum += nums[end];
            maxSum = Math.max(maxSum, currentSum);
        }
    }
    
    return maxSum;
}
```

### Complexity
- **Time:** O(n²) - Two nested loops
- **Space:** O(1)

### Why Is This Slow?
For an array of size 10,000:
- Brute force: ~50 million operations
- Kadane's: ~10,000 operations (5000x faster!)

---

## Discovering Kadane's Algorithm

### The Key Observation

At each position, we have two choices:
1. **Extend** the existing subarray (add current element to previous sum)
2. **Start fresh** from current element (abandon previous sum)

**When to start fresh?**
- When the previous sum becomes **negative**
- A negative sum will only make our total worse!

### The "Aha!" Moment

```
Array: [-2, 1, -3, 4, -1, 2, 1, -5, 4]

At index 0: currentSum = -2, start here
At index 1: Should I take (-2 + 1 = -1) or just (1)?
            1 is better! Start fresh.
At index 2: Should I take (1 + (-3) = -2) or just (-3)?
            -2 is better (less bad). Continue.
At index 3: Should I take (-2 + 4 = 2) or just (4)?
            4 is better! Start fresh.
At index 4: Should I take (4 + (-1) = 3) or just (-1)?
            3 is better. Continue.
...and so on
```

**Pattern:** Start fresh whenever current element alone is better than (previous sum + current element)

**Formula:** `currentSum = max(nums[i], currentSum + nums[i])`

---

## How Kadane's Algorithm Works

### The Algorithm

```java
public int maxSubArray(int[] nums) {
    int currentSum = nums[0];  // Best sum ending at current position
    int maxSum = nums[0];      // Best sum found so far
    
    for (int i = 1; i < nums.length; i++) {
        // Decide: extend previous subarray OR start new one
        currentSum = Math.max(nums[i], currentSum + nums[i]);
        
        // Update global maximum
        maxSum = Math.max(maxSum, currentSum);
    }
    
    return maxSum;
}
```

### What Each Variable Means

**`currentSum`:** 
- Maximum sum of subarray **ending at current position**
- Answers: "What's the best I can do ending right here?"

**`maxSum`:**
- Maximum sum found **so far** in the entire array
- Answers: "What's the best I've seen up to now?"

---

## Detailed Examples

### Example 1: Mixed Positive and Negative

**Array:** `[-2, 1, -3, 4, -1, 2, 1, -5, 4]`

Let's trace through step by step:

| i | nums[i] | currentSum calculation | currentSum | maxSum | Explanation |
|---|---------|------------------------|------------|--------|-------------|
| 0 | -2 | Start | -2 | -2 | Initialize |
| 1 | 1 | max(1, -2+1=-1) | **1** | 1 | Better to start fresh at 1 |
| 2 | -3 | max(-3, 1-3=-2) | **-2** | 1 | Continue (less bad) |
| 3 | 4 | max(4, -2+4=2) | **4** | 4 | Better to start fresh at 4 |
| 4 | -1 | max(-1, 4-1=3) | **3** | 4 | Continue (still positive) |
| 5 | 2 | max(2, 3+2=5) | **5** | 5 | Continue |
| 6 | 1 | max(1, 5+1=6) | **6** | 6 | Continue |
| 7 | -5 | max(-5, 6-5=1) | **1** | 6 | Continue |
| 8 | 4 | max(4, 1+4=5) | **5** | 6 | Continue |

**Answer:** maxSum = **6** (subarray [4, -1, 2, 1])

**Visual Representation:**
```
[-2, 1, -3, 4, -1, 2, 1, -5, 4]
            ↑  ↑  ↑  ↑
            └──────────┘
         Maximum subarray
```

---

### Example 2: All Positive Numbers

**Array:** `[5, 4, -1, 7, 8]`

| i | nums[i] | currentSum | maxSum | Decision |
|---|---------|------------|--------|----------|
| 0 | 5 | 5 | 5 | Start |
| 1 | 4 | 9 | 9 | Extend (5+4 > 4) |
| 2 | -1 | 8 | 9 | Extend (9-1 > -1) |
| 3 | 7 | 15 | 15 | Extend (8+7 > 7) |
| 4 | 8 | 23 | 23 | Extend (15+8 > 8) |

**Answer:** maxSum = **23** (entire array)

**Why?** When running sum stays positive, keep extending!

---

### Example 3: All Negative Numbers

**Array:** `[-5, -2, -3, -1, -4]`

| i | nums[i] | currentSum | maxSum | Decision |
|---|---------|------------|--------|----------|
| 0 | -5 | -5 | -5 | Start |
| 1 | -2 | -2 | -2 | Start fresh (-2 > -5-2) |
| 2 | -3 | -3 | -2 | Start fresh |
| 3 | -1 | -1 | -1 | Start fresh |
| 4 | -4 | -4 | -1 | Start fresh |

**Answer:** maxSum = **-1** (just the element -1)

**Why?** We're finding the "least bad" option when all are negative.

---

### Example 4: Single Element

**Array:** `[5]`

Simple! maxSum = **5**

---

## Why Does It Work?

### The Greedy Principle

Kadane's algorithm makes a **greedy local decision** at each step that leads to the **globally optimal solution**.

**Local Decision:** At each position:
- If extending makes it better → extend
- If starting fresh is better → start fresh

**Global Optimum:** The best local decision at each step leads to the best overall answer.

### Mathematical Proof (Intuitive)

**Claim:** The maximum subarray either:
1. Includes the current element as part of an extending subarray, OR
2. Starts fresh from the current element

**Why?**
- If previous sum < 0: Adding it makes things worse → start fresh
- If previous sum ≥ 0: Adding it might help → consider extending

This covers all possibilities, so we'll always find the maximum!

---

### Comparison with Dynamic Programming

Kadane's Algorithm IS dynamic programming! It follows the DP principle:

**DP State:** `dp[i]` = maximum sum ending at index i

**DP Transition:** `dp[i] = max(nums[i], dp[i-1] + nums[i])`

**Space Optimization:** We only need the previous state, so we can use O(1) space instead of O(n)

---

## Edge Cases

### Edge Case 1: Empty Array
```java
if (nums == null || nums.length == 0) return 0;
```

### Edge Case 2: Single Element
```java
// Algorithm handles this automatically
// currentSum = nums[0], maxSum = nums[0]
```

### Edge Case 3: All Negative
```java
// Works correctly! Returns the maximum (least negative) element
```

### Edge Case 4: Mix of Large Positive and Negative
```java
// Array: [1000, -1, 1000]
// currentSum will correctly keep extending
// Result: 1999
```

---

## Variations and Extensions

### Variation 1: Return the Subarray (Not Just Sum)

```java
public int[] maxSubArray(int[] nums) {
    int currentSum = nums[0];
    int maxSum = nums[0];
    
    int start = 0, end = 0;        // Result indices
    int tempStart = 0;             // Temporary start for current subarray
    
    for (int i = 1; i < nums.length; i++) {
        if (nums[i] > currentSum + nums[i]) {
            // Start fresh
            currentSum = nums[i];
            tempStart = i;
        } else {
            // Extend
            currentSum = currentSum + nums[i];
        }
        
        if (currentSum > maxSum) {
            maxSum = currentSum;
            start = tempStart;
            end = i;
        }
    }
    
    return Arrays.copyOfRange(nums, start, end + 1);
}
```

### Variation 2: Maximum Product Subarray

Similar idea, but track both max and min (negatives flip signs!)

```java
public int maxProduct(int[] nums) {
    int maxProduct = nums[0];
    int currentMax = nums[0];
    int currentMin = nums[0];  // Track min too!
    
    for (int i = 1; i < nums.length; i++) {
        if (nums[i] < 0) {
            // Negative number flips max and min
            int temp = currentMax;
            currentMax = currentMin;
            currentMin = temp;
        }
        
        currentMax = Math.max(nums[i], currentMax * nums[i]);
        currentMin = Math.min(nums[i], currentMin * nums[i]);
        
        maxProduct = Math.max(maxProduct, currentMax);
    }
    
    return maxProduct;
}
```

### Variation 3: Circular Array (Array wraps around)

Maximum sum could wrap from end to beginning!

**Idea:** Max circular sum = max(normal Kadane, totalSum - min subarray)

---

## Practice Exercises

### Exercise 1: Trace Through Manually
Array: `[3, -2, 5, -1, 2]`

Fill in the table:

| i | nums[i] | currentSum | maxSum |
|---|---------|------------|--------|
| 0 | 3 | ? | ? |
| 1 | -2 | ? | ? |
| 2 | 5 | ? | ? |
| 3 | -1 | ? | ? |
| 4 | 2 | ? | ? |

### Exercise 2: Modify for Minimum Subarray
How would you modify Kadane's to find the **minimum** subarray sum?

**Hint:** Change `max` to `min` in the right places!

### Exercise 3: At Least K Elements
What if the subarray must contain at least K elements?

**Hint:** Use a sliding window or modified Kadane's with constraints.

---

## Complexity Analysis

### Time Complexity: **O(n)**
- Single pass through array
- Constant work per element
- Linear in array size

### Space Complexity: **O(1)**
- Only using two variables (`currentSum`, `maxSum`)
- No additional data structures
- Constant extra space

### Comparison

| Approach | Time | Space | Efficiency |
|----------|------|-------|------------|
| Brute Force | O(n²) | O(1) | Slow for large arrays |
| Kadane's | O(n) | O(1) | Optimal! |
| DP Array | O(n) | O(n) | Slower memory usage |

---

## Key Takeaways

1. **Kadane's Algorithm** solves maximum subarray in O(n) time
2. **Key decision:** At each position, extend or start fresh
3. **Formula:**` currentSum = max(nums[i], currentSum + nums[i])`
4. **Works on** all arrays: positive, negative, mixed
5. **Greedy + DP:** Local optimal decisions → global optimum
6. **Variations exist:** product, circular, with constraints

---

## Common Mistakes to Avoid

❌ **Forgetting to handle negative numbers**
```java
// Wrong: resets to 0 (fails on all-negative arrays)
currentSum = Math.max(0, currentSum + nums[i]);

// Correct: compares with the number itself
currentSum = Math.max(nums[i], currentSum + nums[i]);
```

❌ **Not updating maxSum inside loop**
```java
// Wrong: maxSum might miss best intermediate value
for (...) {
    currentSum = ...;
}
return currentSum; // This is wrong!

// Correct: track max at each step
for (...) {
    currentSum = ...;
    maxSum = Math.max(maxSum, currentSum);
}
return maxSum;
```

❌ **Starting from index 1 without initializing**
```java
// Wrong: doesn't consider nums[0]
int currentSum = 0; // Should be nums[0]
```

---

## Next Steps

Now that you understand Kadane's Algorithm:

1. **Practice:** Solve problems in [Kadane_Problems.md](Kadane_Problems.md)
2. **Start with:** Maximum Subarray (core problem)
3. **Progress to:** Maximum Product, Circular Array
4. **Challenge yourself:** House Robber variations

**Remember:** Understanding WHY it works is more important than memorizing code! 🚀

---

## Visual Summary

```
Kadane's Algorithm: Choose at Each Step

          Current Element
               ↓
    ┌─────────────────────┐
    │                     │
    │  Which is better?   │
    │                     │
    └─────────────────────┘
            ↓
    ┌───────────────┐     ┌─────────────────────┐
    │  Just nums[i] │ vs  │ previousSum+nums[i] │
    └───────────────┘     └─────────────────────┘
            ↓                       ↓
       Start Fresh              Extend
```

**The Magic:** This simple choice at each step finds the global maximum! ✨
