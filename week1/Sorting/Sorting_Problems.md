# Sorting Practice Problems

These problems help you understand sorting algorithms and how sorting can simplify problem-solving.

---

## Easy Problems

### 1. Majority Element

**Difficulty:** Easy

**Problem Statement:**
Given an array `nums` of size `n`, return the majority element. The majority element is the element that appears more than `⌊n / 2⌋` times. You may assume that the majority element always exists in the array.

**Example:**
```java
Input: nums = [3,2,3]
Output: 3

Input: nums = [2,2,1,1,1,2,2]
Output: 2
```

**Key Idea (Using Sorting):** If an element appears more than `n/2` times, and the array is sorted, the majority element will always be at index `n/2`.

**Hints:**
- After sorting, the middle element is guaranteed to be the majority element
- Alternative: Use Boyer-Moore Voting Algorithm for O(1) space

**Solution:**
```java
import java.util.Arrays;

public int majorityElement(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length / 2];
}
```

**Time Complexity:** O(n log n) – due to sorting  
**Space Complexity:** O(1) or O(n) depending on sorting implementation

---

### 2. Missing Number

**Difficulty:** Easy

**Problem Statement:**
Given an array `nums` containing `n` distinct numbers in the range `[0, n]`, return the only number in the range that is missing from the array.

**Example:**
```java
Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 
2 is the missing number since it does not appear in nums.

Input: nums = [0,1]
Output: 2

Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
```

**Key Idea (Using Sorting):** Sort the array. The first index `i` where `nums[i] != i` is the missing number. If all match, then `n` is the missing number.

**Hints:**
- After sorting, each number should equal its index
- Handle edge case where n is missing

**Solution:**
```java
import java.util.Arrays;

public int missingNumber(int[] nums) {
    Arrays.sort(nums);
    
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] != i) {
            return i;
        }
    }
    
    return nums.length; // n is missing
}
```

**Time Complexity:** O(n log n)  
**Space Complexity:** O(1)

**Better Solution (O(n) time):**
```java
public int missingNumber(int[] nums) {
    int n = nums.length;
    int expectedSum = n * (n + 1) / 2;
    int actualSum = 0;
    
    for (int num : nums) {
        actualSum += num;
    }
    
    return expectedSum - actualSum;
}
```

---

### 3. Sort Colors (Dutch National Flag)

**Difficulty:** Medium

**Problem Statement:**
Given an array `nums` with `n` objects colored red, white, or blue, sort them **in-place** so that objects of the same color are adjacent, with the colors in the order red, white, and blue. We will use the integers `0`, `1`, and `2` to represent the color red, white, and blue, respectively.

**Example:**
```java
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Input: nums = [2,0,1]
Output: [0,1,2]
```

**Key Idea:** This is the "Dutch National Flag" problem. You can solve it with a single pass using three pointers: `low`, `mid`, and `high`.

**Algorithm:**
- `low` points to the position for next 0
- `mid` is the current element being examined
- `high` points to the position for next 2
- Move `mid` through array and swap appropriately

**Hints:**
- When you see 0, swap with low position
- When you see 2, swap with high position
- When you see 1, just move mid forward
- Stop when mid > high

**Solution:**
```java
public void sortColors(int[] nums) {
    int low = 0, mid = 0, high = nums.length - 1;
    
    while (mid <= high) {
        if (nums[mid] == 0) {
            // Swap with low position
            int temp = nums[low];
            nums[low] = nums[mid];
            nums[mid] = temp;
            low++;
            mid++;
        } else if (nums[mid] == 1) {
            // Just move forward
            mid++;
        } else { // nums[mid] == 2
            // Swap with high position
            int temp = nums[high];
            nums[high] = nums[mid];
            nums[mid] = temp;
            high--;
            // Don't increment mid! Need to check swapped element
        }
    }
}
```

**Time Complexity:** O(n) – single pass  
**Space Complexity:** O(1)

---

### 4. Merge Sorted Array

**Difficulty:** Easy

**Problem Statement:**
You are given two integer arrays `nums1` and `nums2`, sorted in non-decreasing order, and two integers `m` and `n`, representing the number of elements in `nums1` and `nums2` respectively. Merge `nums2` into `nums1` as one sorted array. The final sorted array should not be returned by the function, but instead be stored inside the array `nums1`. To accommodate this, `nums1` has a length of `m + n`.

**Example:**
```java
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
```

**Key Idea:** Fill `nums1` from the end to avoid overwriting unprocessed elements. Compare elements from the end of both arrays.

**Solution:**
```java
public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1;      // Last element in nums1
    int j = n - 1;      // Last element in nums2
    int k = m + n - 1;  // Last position in nums1
    
    while (j >= 0) {
        if (i >= 0 && nums1[i] > nums2[j]) {
            nums1[k] = nums1[i];
            i--;
        } else {
            nums1[k] = nums2[j];
            j--;
        }
        k--;
    }
}
```

**Time Complexity:** O(m + n)  
**Space Complexity:** O(1)

---

### 5. Squares of a Sorted Array

**Difficulty:** Easy

**Problem Statement:**
Given an integer array `nums` sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

**Example:**
```java
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
```

**Key Idea:** Since array can have negative numbers, the largest squares could be at either end. Use two pointers from both ends.

**Solution:**
```java
public int[] sortedSquares(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    int left = 0, right = n - 1;
    
    // Fill result from end to beginning
    for (int i = n - 1; i >= 0; i--) {
        int leftSquare = nums[left] * nums[left];
        int rightSquare = nums[right] * nums[right];
        
        if (leftSquare > rightSquare) {
            result[i] = leftSquare;
            left++;
        } else {
            result[i] = rightSquare;
            right--;
        }
    }
    
    return result;
}
```

**Time Complexity:** O(n)  
**Space Complexity:** O(n)

---

### 6. Sort Array By Parity

**Difficulty:** Easy

**Problem Statement:**
Given an integer array `nums`, move all the even integers at the beginning of the array followed by all the odd integers. Return any array that satisfies this condition.

**Example:**
```java
Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
```

**Key Idea:** Use two pointers - one for even positions (start) and one for odd positions (end).

**Solution:**
```java
public int[] sortArrayByParity(int[] nums) {
    int left = 0, right = nums.length - 1;
    
    while (left < right) {
        // If left is odd and right is even, swap
        if (nums[left] % 2 > nums[right] % 2) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        
        // Move pointers
        if (nums[left] % 2 == 0) left++;
        if (nums[right] % 2 == 1) right--;
    }
    
    return nums;
}
```

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

---

## Medium Problems

### 7. Kth Largest Element in an Array

**Difficulty:** Medium

**Problem Statement:**
Given an integer array `nums` and an integer `k`, return the `kth` largest element in the array. Note that it is the `kth` largest element in the sorted order, not the `kth` distinct element.

**Example:**
```java
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
```

**Solution 1 (Using Sorting):**
```java
import java.util.Arrays;

public int findKthLargest(int[] nums, int k) {
    Arrays.sort(nums);
    return nums[nums.length - k];
}
```

**Time Complexity:** O(n log n)  
**Space Complexity:** O(1)

**Solution 2 (Using PriorityQueue - Better):**
```java
import java.util.PriorityQueue;

public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    
    for (int num : nums) {
        minHeap.offer(num);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
    }
    
    return minHeap.peek();
}
```

**Time Complexity:** O(n log k)  
**Space Complexity:** O(k)

---

## Practice Resources

- [LeetCode - Sorting Problems](https://leetcode.com/tag/sorting/)
- [GeeksforGeeks - Sorting](https://www.geeksforgeeks.org/sorting-algorithms/)
- [HackerRank - Sorting](https://www.hackerrank.com/domains/algorithms?filters%5Bsubdomains%5D%5B%5D=arrays-and-sorting)

---

## Common Sorting Patterns

### Pattern 1: Sort then Process
Many problems become easier after sorting:
- Finding pairs/triplets
- Removing duplicates
- Finding median
- Merging intervals

### Pattern 2: Two Pointers After Sorting
- Two Sum II
- 3Sum
- Container With Most Water
- Squares of Sorted Array

### Pattern 3: Partitioning (Dutch National Flag)
- Sort Colors
- Sort Array By Parity
- Move Zeros

### Pattern 4: Custom Comparators
```java
Arrays.sort(arr, (a, b) -> a[0] - b[0]); // Sort by first element
Arrays.sort(strings, (a, b) -> a.length() - b.length()); // Sort by length
```

---

## Tips

1. **When to sort:**
   - When you need to find pairs/groups
   - When order helps simplify the problem
   - When looking for duplicates or ranges

2. **Time complexity trade-offs:**
   - Sorting: O(n log n)
   - After sorting, many operations become O(n) or O(log n)
   - Sometimes sorting makes the solution simpler even if not optimal

3. **In-place vs extra space:**
   - In-place sorting: `Arrays.sort()`
   - New array: `Arrays.stream(arr).sorted().toArray()`

4. **Stability matters when:**
   - Sorting objects with multiple fields
   - Need to preserve original order for equal elements
