# Two Pointers Practice Problems

Here are some standard problems to master the Two Pointers technique. These are chosen to build your intuition for when and how to use this pattern.

---

## Easy Problems

### 1. Valid Palindrome

**Difficulty:** Easy

**Problem Statement:**
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers. Given a string `s`, return `true` if it is a palindrome, or `false` otherwise.

**Example:**
```java
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Input: s = "race a car"
Output: false
```

**Key Idea:** Use two pointers, one at the start and one at the end. Move them towards each other, skipping non-alphanumeric characters. If characters at pointers don't match, it's not a palindrome.

**Hints:**
- Use `Character.isLetterOrDigit()` to check valid characters
- Use `Character.toLowerCase()` for case-insensitive comparison
- Skip invalid characters by moving pointers

**Solution:**
```java
public boolean isPalindrome(String s) {
    int left = 0, right = s.length() - 1;
    
    while (left < right) {
        // Skip non-alphanumeric characters from left
        while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
            left++;
        }
        
        // Skip non-alphanumeric characters from right
        while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
            right--;
        }
        
        // Compare characters
        if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
            return false;
        }
        
        left++;
        right--;
    }
    
    return true;
}
```

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

---

### 2. Reverse String

**Difficulty:** Easy

**Problem Statement:**
Write a function that reverses a string. The input string is given as an array of characters `s`. You must do this by modifying the input array in-place with O(1) extra memory.

**Example:**
```java
Input: s = ['h','e','l','l','o']
Output: ['o','l','l','e','h']

Input: s = ['H','a','n','n','a','h']
Output: ['h','a','n','n','a','H']
```

**Key Idea:** Swap the characters at the start and end pointers, then move start forward and end backward until they meet.

**Solution:**
```java
public void reverseString(char[] s) {
    int left = 0, right = s.length - 1;
    
    while (left < right) {
        // Swap
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        
        // Move pointers
        left++;
        right--;
    }
}
```

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

---

### 3. Two Sum II - Input Array Is Sorted

**Difficulty:** Medium (Concept is Easy)

**Problem Statement:**
Given a 1-indexed array of integers `numbers` that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Return the indices of the two numbers (1-indexed).

**Example:**
```java
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2.

Input: numbers = [2,3,4], target = 6
Output: [1,3]
```

**Key Idea:** Since the array is sorted, if the sum of elements at left and right pointers is less than target, increment left. If greater, decrement right.

**Solution:**
```java
public int[] twoSum(int[] numbers, int target) {
    int left = 0, right = numbers.length - 1;
    
    while (left < right) {
        int sum = numbers[left] + numbers[right];
        
        if (sum == target) {
            return new int[] {left + 1, right + 1}; // 1-indexed
        } else if (sum < target) {
            left++;  // Need larger sum
        } else {
            right--; // Need smaller sum
        }
    }
    
    return new int[] {}; // No solution found
}
```

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

---

### 4. Move Zeroes

**Difficulty:** Easy

**Problem Statement:**
Given an integer array `nums`, move all `0`'s to the end of it while maintaining the relative order of the non-zero elements. Note that you must do this in-place without making a copy of the array.

**Example:**
```java
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Input: nums = [0]
Output: [0]
```

**Key Idea:** Use a "write" pointer to keep track of the position for the next non-zero element. Use a "read" pointer to iterate through the array.

**Hints:**
- One pointer finds non-zero elements
- Other pointer marks position to place them
- Fill remaining positions with zeros

**Solution:**
```java
public void moveZeroes(int[] nums) {
    int writePos = 0; // Position to write next non-zero
    
    // Move all non-zeros to the front
    for (int readPos = 0; readPos < nums.length; readPos++) {
        if (nums[readPos] != 0) {
            nums[writePos] = nums[readPos];
            writePos++;
        }
    }
    
    // Fill remaining positions with zeros
    while (writePos < nums.length) {
        nums[writePos] = 0;
        writePos++;
    }
}
```

**Alternative Solution (Swap on the fly):**
```java
public void moveZeroes(int[] nums) {
    int left = 0; // Position for next non-zero
    
    for (int right = 0; right < nums.length; right++) {
        if (nums[right] != 0) {
            // Swap
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
        }
    }
}
```

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

---

### 5. Remove Duplicates from Sorted Array

**Difficulty:** Easy

**Problem Statement:**
Given an integer array `nums` sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. Return the number of unique elements.

**Example:**
```java
Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]

Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
```

**Key Idea:** Use slow pointer for unique elements and fast pointer to scan array.

**Solution:**
```java
public int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;
    
    int slow = 0; // Position for next unique element
    
    for (int fast = 1; fast < nums.length; fast++) {
        if (nums[fast] != nums[slow]) {
            slow++;
            nums[slow] = nums[fast];
        }
    }
    
    return slow + 1; // Length of unique elements
}
```

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

---

## Medium Problems

### 6. Container With Most Water

**Difficulty:** Medium

**Problem Statement:**
You are given an integer array `height` of length `n`. There are `n` vertical lines drawn such that the two endpoints of the `ith` line are `(i, 0)` and `(i, height[i])`. Find two lines that together with the x-axis form a container that contains the most water.

**Example:**
```java
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: Max area is between index 1 (height 8) and index 8 (height 7): 7 * 7 = 49
```

**Key Idea:** Start with the widest container. Move the pointer with the smaller height inward, as only a taller line can potentially increase the area.

**Solution:**
```java
public int maxArea(int[] height) {
    int left = 0, right = height.length - 1;
    int maxWater = 0;
    
    while (left < right) {
        // Calculate current area
        int width = right - left;
        int minHeight = Math.min(height[left], height[right]);
        int currentArea = width * minHeight;
        
        maxWater = Math.max(maxWater, currentArea);
        
        // Move pointer with smaller height
        if (height[left] < height[right]) {
            left++;
        } else {
            right--;
        }
    }
    
    return maxWater;
}
```

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

---

### 7. 3Sum

**Difficulty:** Medium

**Problem Statement:**
Given an integer array `nums`, return all the triplets `[nums[i], nums[j], nums[k]]` such that `i != j`, `i != k`, and `j != k`, and `nums[i] + nums[j] + nums[k] == 0`.

**Example:**
```java
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
```

**Key Idea:** Sort the array first. Fix one element and use two pointers for the remaining two elements.

**Solution:**
```java
import java.util.*;

public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    
    for (int i = 0; i < nums.length - 2; i++) {
        // Skip duplicates for first element
        if (i > 0 && nums[i] == nums[i - 1]) continue;
        
        int left = i + 1, right = nums.length - 1;
        
        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];
            
            if (sum == 0) {
                result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                
                // Skip duplicates for second and third elements
                while (left < right && nums[left] == nums[left + 1]) left++;
                while (left < right && nums[right] == nums[right - 1]) right--;
                
                left++;
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
    }
    
    return result;
}
```

**Time Complexity:** O(n²)  
**Space Complexity:** O(1) excluding output

---

## Practice Resources

- [LeetCode - Two Pointers](https://leetcode.com/tag/two-pointers/)
- [NeetCode - Two Pointers Playlist](https://www.youtube.com/playlist?list=PLot-Xpze53ldVwtstag2TL4HQhAnC8ATf)

---

## When to Use Two Pointers

- Array/String is **sorted** or you can sort it
- Need to find **pairs** or **triplets**
- Need to **partition** array into sections
- **Opposite ends** moving toward each other
- **Sliding window** with dynamic size
- **Fast and slow** pointers (cycle detection)

---

## Common Patterns

### Pattern 1: Opposite Direction
```java
int left = 0, right = arr.length - 1;
while (left < right) {
    // Process and move pointers
    if (condition) left++;
    else right--;
}
```

### Pattern 2: Same Direction (Fast & Slow)
```java
int slow = 0;
for (int fast = 0; fast < arr.length; fast++) {
    if (condition) {
        arr[slow] = arr[fast];
        slow++;
    }
}
```

### Pattern 3: Partitioning (Dutch National Flag)
```java
int low = 0, mid = 0, high = arr.length - 1;
while (mid <= high) {
    if (arr[mid] == 0) swap(arr, low++, mid++);
    else if (arr[mid] == 1) mid++;
    else swap(arr, mid, high--);
}
```
