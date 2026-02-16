# Two Pointers Technique

## Problem Statement (Two Sum II)
Given a **1-indexed** array of integers that is already **sorted in non-decreasing order**, find two numbers such that they add up to a specific target number.

**Example:**
`numbers = [2, 7, 11, 15], target = 9`

**Output:**
`[1, 2]` (Indices of 2 and 7)

---

## How It Works
Since the array is sorted, we can use two pointers to find the pair efficiently.

1.  Initialize `left` pointer at the **start** (smallest element).
2.  Initialize `right` pointer at the **end** (largest element).
3.  Calculate `sum = numbers[left] + numbers[right]`.

**Logic:**
-   If `sum == target`: We found the pair! Return indices.
-   If `sum < target`: The sum is too small. We need a larger number. **Increment left**.
-   If `sum > target`: The sum is too big. We need a smaller number. **Decrement right**.

---

## Dry Run
**Example:** `numbers = [2, 7, 11, 15], target = 9`

| left | right | nums[left] | nums[right] | sum (nums[l] + nums[r]) | Action |
|------|-------|------------|-------------|-------------------------|--------|
| 0    | 3     | 2          | 15          | 17                      | 17 > 9 -> **right--** |
| 0    | 2     | 2          | 11          | 13                      | 13 > 9 -> **right--** |
| 0    | 1     | 2          | 7           | 9                       | 9 == 9 -> **Found!** |

---

## Java Implementation

```java
public int[] twoSum(int[] numbers, int target) {
    int left = 0;
    int right = numbers.length - 1;
    
    while (left < right) {
        int sum = numbers[left] + numbers[right];
        
        if (sum == target) {
            return new int[]{left + 1, right + 1}; // 1-indexed
        } else if (sum < target) {
            left++; // Need larger sum
        } else {
            right--; // Need smaller sum
        }
    }
    return new int[]{}; // No solution found
}
```

---

## Complexity Analysis

-   **Time Complexity**: `O(N)`
    -   Each step moves one pointer. In the worst case, pointers meet in the middle.
-   **Space Complexity**: `O(1)`
    -   We only use two integer variables.

---

## Other Problems utilizing Two Pointers
-   Container With Most Water
-   Remove Duplicates from Sorted Array
-   3Sum
-   Valid Palindrome
