# Kadane's Algorithm

## Problem Statement
In an integer array (which can contain negative numbers), we have to find the maximum sum of a continuous subarray.

**Example:**
`[-2, 1, -3, 4, -1, 2, 1, -5, 4]`

**Output:**
`6`

**Explanation:**
The subarray `[4, -1, 2, 1]` has the largest sum = 6.

---

## How It Works
Kadane’s Algorithm scans the array from **left to right**.

At each index `i`, we compute:
- `current_sum` → Maximum subarray sum **ending at index i**.
- `maximum_sum` → Maximum subarray sum found **so far**.

At every step, we decide whether to:
1.  **Extend** the previous subarray (add current element).
2.  **Start a new** subarray from the current element (if previous sum was negative).

---

## Dry Run
**Example:** `[5, 4, -1, 7, 8]`

| i | nums[i] | current_sum (max(nums[i], current + nums[i])) | max_sum (max(best, current)) |
| - | ------- | --------------------------------------------- | ---------------------------- |
| 0 | 5       | 5                                             | 5                            |
| 1 | 4       | max(4, 5+4=9) = 9                             | 9                            |
| 2 | -1      | max(-1, 9-1=8) = 8                            | 9                            |
| 3 | 7       | max(7, 8+7=15) = 15                           | 15                           |
| 4 | 8       | max(8, 15+8=23) = 23                          | 23                           |

---

## Java Implementation

```java
public static int maxSubArray(int[] A) {
    if (A == null || A.length == 0) return 0;
    
    int currentSum = A[0];
    int maxSum = A[0];
    
    for (int i = 1; i < A.length; i++) {
        // Either extend the previous subarray or start a new one
        currentSum = Math.max(A[i], currentSum + A[i]);
        
        // Update global maximum
        maxSum = Math.max(maxSum, currentSum);
    }
    return maxSum;
}
```

---

## Complexity Analysis

-   **Time Complexity**: `O(N)`
    -   We traverse the array once.
-   **Space Complexity**: `O(1)`
    -   We only use two variables (`currentSum`, `maxSum`).

---

## Edge Cases
-   **All negative numbers**: The algorithm correctly returns the largest single element (least negative).
-   **Single element array**: Returns that element.
