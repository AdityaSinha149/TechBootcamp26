# Sliding Window Technique - Complete Guide

The Sliding Window technique is a powerful pattern for solving array and string problems efficiently. This guide will teach you everything you need to master this essential technique.

---

## Table of Contents
1. [What is Sliding Window?](#what-is-sliding-window)
2. [When to Use Sliding Window](#when-to-use-sliding-window)
3. [Types of Sliding Windows](#types-of-sliding-windows)
4. [Pattern 1: Fixed-Size Window](#pattern-1-fixed-size-window)
5. [Pattern 2: Variable-Size Window](#pattern-2-variable-size-window)
6. [Common Patterns and Templates](#common-patterns-and-templates)
7. [Complexity Analysis](#complexity-analysis)
8. [Practice Exercises](#practice-exercises)

---

## What is Sliding Window?

The **Sliding Window** technique is a method for efficiently processing **subarrays** or **substrings** by maintaining a "window" that slides over the data structure.

### Simple Analogy
Imagine you're looking through a window at a street. Instead of standing up and walking to see different sections (inefficient), you slide the window smoothly from one end to the other!

```
Array:  [1, 3, -1, -3, 5, 3, 6, 7]
Window: [1, 3, -1]        ← Initial position
            ↓
        [3, -1, -3]       ← Slide right
            ↓
        [-1, -3, 5]       ← Keep sliding
            ↓
        ...
```

### Why Use It?
**Without Sliding Window (Brute Force):**
- Recalculate sum/max/min for each subarray → O(n×k) or O(n²)

**With Sliding Window:**
- Add new element, remove old element → O(n)

**Speed Improvement:** Up to 1000x faster for large arrays!

---

## When to Use Sliding Window

Use Sliding Window when you see these keywords in a problem:

✅ **"Contiguous" subarray or substring**  
✅ **"Maximum/Minimum sum of size K"**  
✅ **"Longest substring with..."**  
✅ **"Find all subarrays that..."**  
✅ **"Smallest window containing..."**  

❌ Don't use when:
- Elements can be non-contiguous
- You need all possible combinations
- Window can jump (not slide continuously)

---

## Types of Sliding Windows

### 1. Fixed-Size Window
Window size is **constant** (given as K).

```
K = 3
[1, 3, -1, -3, 5, 3, 6, 7]
 └─────┘
    └─────┘
       └─────┘
          └─────┘
```

### 2. Variable-Size Window
Window size **changes** based on conditions.

```
[1, 2, 3, 1, 4, 5]
 ↑  ↑           (size = 2)
    ↑     ↑     (size = 4)
          ↑  ↑  (size = 2)
```

---

## Pattern 1: Fixed-Size Window

### Concept
Maintain a window of exactly K elements. Slide it across the array one element at a time.

### When to Use
- "Maximum sum subarray of size K"
- "Average of all subarrays of size K"
- "First negative in every window of size K"

### Template Code
```java
public void fixedSizeWindow(int[] arr, int k) {
    int windowSum = 0;
    
    // Build first window
    for (int i = 0; i < k; i++) {
        windowSum += arr[i];
    }
    
    int result = windowSum; // or whatever we're tracking
    
    // Slide the window
    for (int i = k; i < arr.length; i++) {
        windowSum += arr[i];      // Add new element
        windowSum -= arr[i - k];  // Remove old element
        result = Math.max(result, windowSum); // Update result
    }
}
```

### Example Problem: Maximum Sum Subarray of Size K

**Problem:** Find the maximum sum of any contiguous subarray of size K.

**Input:** `arr = [2, 1, 5, 1, 3, 2], k = 3`  
**Output:** `9` (subarray `[5, 1, 3]`)

**Visual Walkthrough:**

```
Step 1: Build first window (k=3)
[2, 1, 5, 1, 3, 2]
 └─────┘
sum = 2 + 1 + 5 = 8

Step 2: Slide window right
[2, 1, 5, 1, 3, 2]
    └─────┘
Remove 2, Add 1
sum = 8 - 2 + 1 = 7

Step 3: Continue sliding
[2, 1, 5, 1, 3, 2]
       └─────┘
Remove 1, Add 3
sum = 7 - 1 + 3 = 9 ← Maximum!

Step 4: Last window
[2, 1, 5, 1, 3, 2]
          └─────┘
Remove 5, Add 2
sum = 9 - 5 + 2 = 6
```

**Complete Solution:**
```java
public int maxSumSubarray(int[] arr, int k) {
    // Handle edge case
    if (arr.length < k) return -1;
    
    // Build first window
    int windowSum = 0;
    for (int i = 0; i < k; i++) {
        windowSum += arr[i];
    }
    
    int maxSum = windowSum;
    
    // Slide the window
    for (int i = k; i < arr.length; i++) {
        windowSum += arr[i];      // Add right element
        windowSum -= arr[i - k];  // Remove left element
        maxSum = Math.max(maxSum, windowSum);
    }
    
    return maxSum;
}
```

**Why This Works:**
- We don't recalculate sum from scratch each time
- We just adjust: `new_sum = old_sum - left_element + right_element`
- This is O(1) per window!

**Complexity:**
- Time: O(n) - One pass through array
- Space: O(1) - Only storing sum and max

---

### Another Example: First Negative in Every Window

**Problem:** Find the first negative number in every window of size K.

**Input:** `arr = [12, -1, -7, 8, -15, 30, 16, 28], k = 3`  
**Output:** `[-1, -1, -7, -15, -15, 0]`

**Approach:** Use a queue to store negative numbers in current window.

```java
public int[] firstNegativeInWindow(int[] arr, int k) {
    int n = arr.length;
    int[] result = new int[n - k + 1];
    Queue<Integer> negatives = new LinkedList<>();
    
    // Process first window
    for (int i = 0; i < k; i++) {
        if (arr[i] < 0) {
            negatives.offer(i);
        }
    }
    
    // First result
    result[0] = negatives.isEmpty() ? 0 : arr[negatives.peek()];
    
    // Slide window
    for (int i = k; i < n; i++) {
        // Remove elements outside window
        while (!negatives.isEmpty() && negatives.peek() <= i - k) {
            negatives.poll();
        }
        
        // Add new negative if present
        if (arr[i] < 0) {
            negatives.offer(i);
        }
        
        // Store result
        result[i - k + 1] = negatives.isEmpty() ? 0 : arr[negatives.peek()];
    }
    
    return result;
}
```

---

## Pattern 2: Variable-Size Window

### Concept
Window size **changes dynamically** based on certain conditions. Use two pointers (left and right) to expand or contract the window.

### When to Use
- "Longest substring with K distinct characters"
- "Smallest subarray with sum ≥ K"
- "Longest substring without repeating characters"

### Template Code
```java
public void variableSizeWindow(int[] arr) {
    int left = 0;
    int result = 0; // or Integer.MAX_VALUE for minimum
    
    for (int right = 0; right < arr.length; right++) {
        // Expand window by including arr[right]
        addToWindow(arr[right]);
        
        // Contract window while condition is violated
        while (windowInvalid()) {
            removeFromWindow(arr[left]);
            left++;
        }
        
        // Update result with current valid window
        result = Math.max(result, right - left + 1);
    }
}
```

### Example Problem: Longest Substring Without Repeating Characters

**Problem:** Find the length of the longest substring without repeating characters.

**Input:** `"abcabcbb"`  
**Output:** `3` (substring `"abc"`)

**Visual Walkthrough:**

```
Step 1: right=0, s="a", window={a:0}
        left=0, length=1

Step 2: right=1, s="ab", window={a:0, b:1}
        left=0, length=2

Step 3: right=2, s="abc", window={a:0, b:1, c:2}
        left=0, length=3 ← Current max

Step 4: right=3, s="abca", found duplicate 'a'!
        Shrink window: remove s[0]='a'
        left=1, window={b:1, c:2, a:3}
        length=3

Step 5: right=4, s="bcab", found duplicate 'b'!
        Shrink: remove s[1]='b'
        left=2, window={c:2, a:3, b:4}
        length=3

...and so on
```

**Complete Solution:**
```java
public int lengthOfLongestSubstring(String s) {
    HashMap<Character, Integer> window = new HashMap<>();
    int left = 0;
    int maxLength = 0;
    
    for (int right = 0; right < s.length(); right++) {
        char c = s.charAt(right);
        
        // If character exists in window, shrink from left
        while (window.containsKey(c)) {
            char leftChar = s.charAt(left);
            window.remove(leftChar);
            left++;
        }
        
        // Add current character
        window.put(c, right);
        
        // Update max length
        maxLength = Math.max(maxLength, right - left + 1);
    }
    
    return maxLength;
}
```

**Why This Works:**
- Expand window by moving `right`
- When we find duplicate, contract from `left` until no duplicates
- Track maximum window size seen

**Complexity:**
- Time: O(n) - Each character visited at most twice (once by right, once by left)
- Space: O(min(n, m)) - where m is charset size

---

### Example Problem: Minimum Window Substring

**Problem:** Find the smallest substring in S containing all characters from T.

**Input:** `S = "ADOBECODEBANC", T = "ABC"`  
**Output:** `"BANC"`

**Approach:**
1. Expand window until all characters of T are included
2. Contract from left while maintaining all characters
3. Track minimum window size

```java
public String minWindow(String s, String t) {
    if (s.length() < t.length()) return "";
    
    // Count required characters
    HashMap<Character, Integer> required = new HashMap<>();
    for (char c : t.toCharArray()) {
        required.put(c, required.getOrDefault(c, 0) + 1);
    }
    
    HashMap<Character, Integer> window = new HashMap<>();
    int left = 0, formed = 0;
    int minLen = Integer.MAX_VALUE;
    int minLeft = 0;
    
    for (int right = 0; right < s.length(); right++) {
        char c = s.charAt(right);
        window.put(c, window.getOrDefault(c, 0) + 1);
        
        // Check if current character frequency matches required
        if (required.containsKey(c) && 
            window.get(c).intValue() == required.get(c).intValue()) {
            formed++;
        }
        
        // Try to contract window
        while (formed == required.size()) {
            // Update result
            if (right - left + 1 < minLen) {
                minLen = right - left + 1;
                minLeft = left;
            }
            
            // Remove left character
            char leftChar = s.charAt(left);
            window.put(leftChar, window.get(leftChar) - 1);
            if (required.containsKey(leftChar) && 
                window.get(leftChar) < required.get(leftChar)) {
                formed--;
            }
            left++;
        }
    }
    
    return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
}
```

---

## Common Patterns and Templates

### Pattern 1: Fixed Window with Sum/Average
```java
// Maximum sum of k consecutive elements
int maxSum = Integer.MIN_VALUE;
int windowSum = 0;

for (int i = 0; i < k; i++) windowSum += arr[i];
maxSum = windowSum;

for (int i = k; i < arr.length; i++) {
    windowSum += arr[i] - arr[i - k];
    maxSum = Math.max(maxSum, windowSum);
}
```

### Pattern 2: Variable Window with HashMap
```java
// Longest substring with at most k distinct characters
HashMap<Character, Integer> window = new HashMap<>();
int left = 0, maxLen = 0;

for (int right = 0; right < s.length(); right++) {
    window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
    
    while (window.size() > k) {
        char leftChar = s.charAt(left);
        window.put(leftChar, window.get(leftChar) - 1);
        if (window.get(leftChar) == 0) window.remove(leftChar);
        left++;
    }
    
    maxLen = Math.max(maxLen, right - left + 1);
}
```

### Pattern 3: Variable Window with Counter
```java
// Longest substring with at most k replacements
int left = 0, maxFreq = 0, maxLen = 0;
HashMap<Character, Integer> freq = new HashMap<>();

for (int right = 0; right < s.length(); right++) {
    char c = s.charAt(right);
    freq.put(c, freq.getOrDefault(c, 0) + 1);
    maxFreq = Math.max(maxFreq, freq.get(c));
    
    // If replacements needed > k, shrink window
    while (right - left + 1 - maxFreq > k) {
        freq.put(s.charAt(left), freq.get(s.charAt(left)) - 1);
        left++;
    }
    
    maxLen = Math.max(maxLen, right - left + 1);
}
```

---

## Complexity Analysis

### Time Complexity

**Fixed-Size Window:** O(n)
- Build first window: O(k)
- Slide n-k times: O(n-k)
- Total: O(k + n - k) = O(n)

**Variable-Size Window:** O(n)
- Right pointer moves n times: O(n)
- Left pointer moves at most n times: O(n)
- Total: O(2n) = O(n)

**Key Insight:** Each element is processed at most twice!

### Space Complexity

**With HashMap:** O(k) or O(m)
- k = window size
- m = charset size
- Example: For ASCII, m = 128

**Without Extra Storage:** O(1)

---

## Sliding Window vs Other Techniques

| Problem Type | Technique | Time | Why? |
|--------------|-----------|------|------|
| Maximum in fixed subarray | Sliding Window | O(n) | Deque optimization |
| Two elements sum to target | Two Pointers | O(n) | No window needed |
| Maximum subarray sum | Kadane's | O(n) | No window constraint |
| Longest valid substring | Sliding Window | O(n) | Variable window |

---

## Practice Exercises

### Exercise 1: Count Subarrays with Sum = K
**Problem:** Count how many subarrays have exactly sum K (fixed-size window).

**Hint:** Use prefix sum for efficient calculation.

---

### Exercise 2: Longest Subarray with Sum ≤ K
**Problem:** Find length of longest subarray where sum ≤ K (variable window).

**Hint:** Expand with right, contract when sum > K.

---

### Exercise 3: All Anagrams in String
**Problem:** Find all starting indices of anagrams of pattern P in string S.

**Hint:** Fixed window of size |P|, use frequency map.

---

## Tips and Common Pitfalls

### ✅ Do's
1. **Initialize window properly:** Build first window before sliding
2. **Update both pointers:** Don't forget to move left when needed
3. **Use HashMap for distinct elements:** Efficient for variable windows
4. **Handle edge cases:** Empty array, k > n, etc.

### ❌ Don'ts
1. **Don't recalculate from scratch:** Use incremental updates
2. **Don't forget to shrink window:** In variable-size problems
3. **Don't use nested loops:** That defeats the purpose (O(n²))
4. **Don't mix with Two pointers inappropriately:** Different patterns!

---

## Key Takeaways

1. **Sliding Window** optimizes subarray problems from O(n²) to O(n)
2. **Two types:** Fixed-size and Variable-size
3. **Fixed:** Slide by adding new, removing old
4. **Variable:** Expand with right, contract with left
5. **Use HashMap** for distinct elements, frequency tracking
6. **Pattern recognition:** Look for "contiguous," "substring," "subarray"

---

## Next Steps

Now that you understand Sliding Window:

1. **Practice:** Solve problems in [SlidingWindow_Problems.md](SlidingWindow_Problems.md)
2. **Start with:** Maximum Sum of Size K (fixed window)
3. **Progress to:** Longest Substring Without Repeating (variable)
4. **Master:** Minimum Window Substring (hard)

**Remember:** Sliding Window is just Two Pointers with additional state tracking! 🎯

---

## Visual Summary

```
Fixed-Size Window (K=3):
┌─────────────────────────┐
│ [1, 3, -1, -3, 5, 3, 6] │
│  └──┬──┘                │
│     └──┬──┘             │
│        └──┬──┘          │
│           └──┬──┘       │
└─────────────────────────┘

Variable-Size Window:
┌─────────────────────────┐
│ [1, 2, 3, 1, 4, 5]      │
│  ↑                      │  Expand →
│  ↑──────↑              │
│     ↑──────────↑       │  
│        ← Shrink        │
└─────────────────────────┘
```

Happy Sliding! 🪟✨
