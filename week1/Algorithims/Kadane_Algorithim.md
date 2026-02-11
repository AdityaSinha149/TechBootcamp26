# Kadane's Algorithim
## Problem Statement
In an integer array(which can contain negative numbers) we have to find the maximum sum of a continous subarray

Example:
`
[-2,1,-3,4,-1,2,1,-5,4]
`

Output:
`
6
`

Explanation:
`
[4,-1,2,1]
`

## How It Works
Kadane’s Algorithm scans the array from **left to right**.

At each index `i`, we compute:

- `current_sum` → Maximum subarray sum **ending at index i**
- `maximum_sum` → Maximum subarray sum found **so far**

At every step, we decide:

- Extend the previous subarray  
- OR start a new subarray from the current element
  
## Dry Run
Example : `[5,4,-1,7,8]`

| i | nums[i] | current = max(nums[i], current + nums[i]) | best = max(best, current) |
| - | ------- | ----------------------------------------- | ------------------------- |
| 0 | 5       | 5                                         | 5                         |
| 1 | 4       | max(4, 5 + 4 = 9) = 9                     | 9                         |
| 2 | -1      | max(-1, 9 - 1 = 8) = 8                    | 9                         |
| 3 | 7       | max(7, 8 + 7 = 15) = 15                   | 15                        |
| 4 | 8       | max(8, 15 + 8 = 23) = 23                  | 23                        |

## Java Implementation
```

public static int maxSubArray(int[] A) {
    int curr_sum = A[0];
    int max_sum = A[0];
    for (int i = 1; i < A.length; i++) {
        curr_sum = Math.max(A[i], curr_sum + A[i]);
        max_sum = Math.max(max_sum, curr_sum);
    }
    return max_sum;
}

```

## Time Complexity Analysis
Let n be the size of the array
- the algorithim goes through the array once
- Each iteration performs constant-time operations
- total time taken is proportional to n
  
`Time Complexity: O(n)`

## Space Complexity Analysis
Let n be the size of the array
we use two variables only
- curr_sum
- max_sum

no auxillary space is used

`Space Complexity:O(1)`

## Edge Cases to consider
- All negative numbers
- single element array

