# Sliding Window Practice Problems

These problems will help you master the Sliding Window technique, progressing from fixed-size to variable-size windows.

---

## Easy Problems (Fixed-Size Window)

### 1. Maximum Sum Subarray of Size K

**Difficulty:** Easy

**Problem Statement:**
Given an array of integers and a number K, find the maximum sum of any contiguous subarray of size K.

**Example:**
```java
Input: arr = [2, 1, 5, 1, 3, 2], k = 3
Output: 9
Explanation: Subarray with maximum sum is [5, 1, 3]

Input: arr = [2, 3, 4, 1, 5], k = 2
Output: 7
Explanation: Subarray with maximum sum is [3, 4]
```

**Key Idea:**
Use a sliding window of size K. Add the new element and subtract the element that left the window.

**Hints:**
1. Build the first window by summing first K elements
2. Slide the window: add arr[i], subtract arr[i-k]
3. Track the maximum sum seen

**Solution:**
```java
public int maxSumSubarray(int[] arr, int k) {
    if (arr.length < k) return -1;
    
    // Build first window
    int windowSum = 0;
    for (int i = 0; i < k; i++) {
        windowSum += arr[i];
    }
    
    int maxSum = windowSum;
    
    // Slide window
    for (int i = k; i < arr.length; i++) {
        windowSum += arr[i] - arr[i - k];
        maxSum = Math.max(maxSum, windowSum);
    }
    
    return maxSum;
}
```

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

---

### 2. Average of Subarrays of Size K

**Difficulty:** Easy

**Problem Statement:**
Given an array and K, find the average of all contiguous subarrays of size K.

**Example:**
```java
Input: arr = [1, 3, 2, 6, -1, 4, 1, 8, 2], k = 5
Output: [2.2, 2.8, 2.4, 3.6, 2.8]
```

**Solution:**
```java
public double[] findAverages(int[] arr, int k) {
    double[] result = new double[arr.length - k + 1];
    double windowSum = 0;
    
    // First window
    for (int i = 0; i < k; i++) {
        windowSum += arr[i];
    }
    result[0] = windowSum / k;
    
    // Slide window
    for (int i = k; i < arr.length; i++) {
        windowSum += arr[i] - arr[i - k];
        result[i - k + 1] = windowSum / k;
    }
    
    return result;
}
```

**Time Complexity:** O(n)  
**Space Complexity:** O(1) - not counting output array

---

### 3. Maximum of All Subarrays of Size K

**Difficulty:** Medium

**Problem Statement:**
Given an array and K, find the maximum element in each subarray of size K.

**Example:**
```java
Input: arr = [1, 3, -1, -3, 5, 3, 6, 7], k = 3
Output: [3, 3, 5, 5, 6, 7]
Explanation:
  Window [1, 3, -1] → max = 3
  Window [3, -1, -3] → max = 3
  Window [-1, -3, 5] → max = 5
  ...
```

**Key Idea:**
Use a deque to maintain elements in decreasing order within the window.

**Hints:**
1. Use deque to store indices (not values)
2. Keep deque in decreasing order of values
3. Remove indices outside current window
4. Front of deque is always the maximum

**Solution:**
```java
public int[] maxSlidingWindow(int[] arr, int k) {
    int n = arr.length;
    if (n == 0 || k == 0) return new int[0];
    
    int[] result = new int[n - k + 1];
    Deque<Integer> deque = new LinkedList<>();
    
    for (int i = 0; i < n; i++) {
        // Remove indices outside window
        while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
            deque.pollFirst();
        }
        
        // Remove smaller elements (they won't be max)
        while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
            deque.pollLast();
        }
        
        deque.offerLast(i);
        
        // Add to result if window is complete
        if (i >= k - 1) {
            result[i - k + 1] = arr[deque.peekFirst()];
        }
    }
    
    return result;
}
```

**Time Complexity:** O(n) - each element added/removed once  
**Space Complexity:** O(k) - deque size

---

## Medium Problems (Variable-Size Window)

### 4. Longest Substring Without Repeating Characters

**Difficulty:** Medium

**Problem Statement:**
Find the length of the longest substring without repeating characters.

**Example:**
```java
Input: s = "abcabcbb"
Output: 3
Explanation: "abc" is the longest without repeats

Input: s = "bbbbb"
Output: 1
Explanation: "b" is the longest

Input: s = "pwwkew"
Output: 3
Explanation: "wke" is the longest
```

**Key Idea:**
Use a HashMap to track last seen position of each character. Shrink window when duplicate found.

**Hints:**
1. Use HashMap to store character → index mapping
2. When you see a duplicate, move left pointer
3. Update max length at each step

**Solution:**
```java
public int lengthOfLongestSubstring(String s) {
    HashMap<Character, Integer> window = new HashMap<>();
    int left = 0;
    int maxLength = 0;
    
    for (int right = 0; right < s.length(); right++) {
        char c = s.charAt(right);
        
        // If duplicate found, shrink window
        while (window.containsKey(c)) {
            window.remove(s.charAt(left));
            left++;
        }
        
        window.put(c, right);
        maxLength = Math.max(maxLength, right - left + 1);
    }
    
    return maxLength;
}
```

**Time Complexity:** O(n)  
**Space Complexity:** O(min(n, m)) where m is charset size

---

### 5. Longest Substring with At Most K Distinct Characters

**Difficulty:** Medium

**Problem Statement:**
Find the length of the longest substring that contains at most K distinct characters.

**Example:**
```java
Input: s = "eceba", k = 2
Output: 3
Explanation: "ece" has 2 distinct characters

Input: s = "aa", k = 1
Output: 2
Explanation: "aa" has 1 distinct character
```

**Hints:**
1. Expand window with right pointer
2. When distinct count > k, shrink from left
3. Track frequency to know when to remove from map

**Solution:**
```java
public int lengthOfLongestSubstringKDistinct(String s, int k) {
    if (k == 0) return 0;
    
    HashMap<Character, Integer> window = new HashMap<>();
    int left = 0;
    int maxLength = 0;
    
    for (int right = 0; right < s.length(); right++) {
        char c = s.charAt(right);
        window.put(c, window.getOrDefault(c, 0) + 1);
        
        // Shrink window if too many distinct characters
        while (window.size() > k) {
            char leftChar = s.charAt(left);
            window.put(leftChar, window.get(leftChar) - 1);
            if (window.get(leftChar) == 0) {
                window.remove(leftChar);
            }
            left++;
        }
        
        maxLength = Math.max(maxLength, right - left + 1);
    }
    
    return maxLength;
}
```

**Time Complexity:** O(n)  
**Space Complexity:** O(k)

---

### 6. Fruits Into Baskets

**Difficulty:** Medium

**Problem Statement:**
You have two baskets, and each basket can only hold one type of fruit. Find the maximum number of fruits you can collect (given an array where each element is a fruit type).

**Note:** This is the same as "longest substring with at most 2 distinct characters"!

**Example:**
```java
Input: fruits = [1, 2, 1, 2, 3]
Output: 4
Explanation: Pick [1, 2, 1, 2] (two types: 1 and 2)

Input: fruits = [0, 1, 2, 2]
Output: 3
Explanation: Pick [1, 2, 2] or [2, 2]
```

**Solution:**
```java
public int totalFruit(int[] fruits) {
    HashMap<Integer, Integer> basket = new HashMap<>();
    int left = 0;
    int maxFruits = 0;
    
    for (int right = 0; right < fruits.length; right++) {
        basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);
        
        // More than 2 types? Shrink window
        while (basket.size() > 2) {
            basket.put(fruits[left], basket.get(fruits[left]) - 1);
            if (basket.get(fruits[left]) == 0) {
                basket.remove(fruits[left]);
            }
            left++;
        }
        
        maxFruits = Math.max(maxFruits, right - left + 1);
    }
    
    return maxFruits;
}
```

**Time Complexity:** O(n)  
**Space Complexity:** O(1) - at most 3 entries in map

---

### 7. Longest Repeating Character Replacement

**Difficulty:** Medium

**Problem Statement:**
You can replace at most K characters in a string to make all characters the same. Find the length of the longest substring you can get.

**Example:**
```java
Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace two 'A's with 'B's or vice versa

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace one 'B' → "AAAA"
```

**Key Idea:**
Window is valid if: `windowSize - maxFrequency ≤ k`

**Hints:**
1. Track frequency of each character in window
2. Track max frequency character
3. If replacements needed > k, shrink window

**Solution:**
```java
public int characterReplacement(String s, int k) {
    HashMap<Character, Integer> freq = new HashMap<>();
    int left = 0;
    int maxFreq = 0;
    int maxLength = 0;
    
    for (int right = 0; right < s.length(); right++) {
        char c = s.charAt(right);
        freq.put(c, freq.getOrDefault(c, 0) + 1);
        maxFreq = Math.max(maxFreq, freq.get(c));
        
        // If too many replacements needed, shrink
        while (right - left + 1 - maxFreq > k) {
            char leftChar = s.charAt(left);
            freq.put(leftChar, freq.get(leftChar) - 1);
            left++;
        }
        
        maxLength = Math.max(maxLength, right - left + 1);
    }
    
    return maxLength;
}
```

**Time Complexity:** O(n)  
**Space Complexity:** O(1) - at most 26 letters

---

## Hard Problems

### 8. Minimum Window Substring

**Difficulty:** Hard

**Problem Statement:**
Given strings S and T, find the minimum window in S which contains all characters from T (including duplicates).

**Example:**
```java
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: Smallest window containing A, B, C

Input: s = "a", t = "a"
Output: "a"

Input: s = "a", t = "aa"
Output: ""
Explanation: Not possible
```

**Key Idea:**
Expand until all chars found, then contract while maintaining all chars.

**Hints:**
1. Use two HashMaps: required and window
2. Track how many required chars are satisfied
3. Expand to satisfy, contract to minimize

**Solution:**
```java
public String minWindow(String s, String t) {
    if (s.length() < t.length()) return "";
    
    HashMap<Character, Integer> required = new HashMap<>();
    for (char c : t.toCharArray()) {
        required.put(c, required.getOrDefault(c, 0) + 1);
    }
    
    HashMap<Character, Integer> window = new HashMap<>();
    int left = 0, formed = 0;
    int minLen = Integer.MAX_VALUE, minLeft = 0;
    
    for (int right = 0; right < s.length(); right++) {
        char c = s.charAt(right);
        window.put(c, window.getOrDefault(c, 0) + 1);
        
        // Check if requirement satisfied for this character
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

**Time Complexity:** O(|S| + |T|)  
**Space Complexity:** O(|S| + |T|)

---

## When to Use Sliding Window

Use Sliding Window when you see:
- ✅ "Contiguous subarray/substring"
- ✅ "Maximum/minimum sum of size K"
- ✅ "Longest/shortest substring with..."
- ✅ "All subarrays/substrings that..."

---

## Common Patterns

### Pattern 1: Fixed Window
```java
// Build first window
for (int i = 0; i < k; i++) add(arr[i]);

// Slide window
for (int i = k; i < n; i++) {
    add(arr[i]);
    remove(arr[i - k]);
    updateResult();
}
```

### Pattern 2: Variable Window (Maximum)
```java
int left = 0, maxLen = 0;
for (int right = 0; right < n; right++) {
    add(arr[right]);
    while (invalid()) {
        remove(arr[left]);
        left++;
    }
    maxLen = Math.max(maxLen, right - left + 1);
}
```

### Pattern 3: Variable Window (Minimum)
```java
int left = 0, minLen = Integer.MAX_VALUE;
for (int right = 0; right < n; right++) {
    add(arr[right]);
    while (valid()) {
        minLen = Math.min(minLen, right - left + 1);
        remove(arr[left]);
        left++;
    }
}
```

---

## Tips for Success

1. **Identify window type:** Fixed or variable?
2. **Use HashMap** for distinct elements / frequency
3. **Update max/min** after shrinking/expanding
4. **Handle edge cases:** Empty string, k=0, k>n
5. **Draw it out:** Visualize the window movement

---

## Practice Resources

- [LeetCode Sliding Window Problems](https://leetcode.com/tag/sliding-window/)
- [NeetCode Sliding Window Playlist](https://www.youtube.com/watch?v=jM2dhDPYMQM&list=PLot-Xpze53ldVwtstag2TL4HQhAnC8ATf)

---

**Remember:** Sliding Window is about efficient reuse of computation - don't recalculate from scratch! 🪟
