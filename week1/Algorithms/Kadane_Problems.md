# Kadane's Algorithm Practice Problems

Kadane's Algorithm is a dynamic programming approach used to solve maximum subarray problems.

---

## Core Problem

### 1. Maximum Subarray

**Difficulty:** Medium

**Problem Statement:**
Given an integer array `nums`, find the subarray which has the largest sum and return its sum.

**Example:**
```java
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

Input: nums = [1]
Output: 1

Input: nums = [5,4,-1,7,8]
Output: 23
```

**Key Idea:** Iterate through the array, keeping track of the current subarray sum and the maximum sum found so far. If the current sum becomes negative, reset it to 0 (or start fresh from current element).

**Hints:**
- At each position, decide: extend current subarray or start new one?
- `current = max(num, current + num)`
- Always track the maximum seen so far

**Solution:**
```java
public int maxSubArray(int[] nums) {
    int currentSum = nums[0];
    int maxSum = nums[0];
    
    for (int i = 1; i < nums.length; i++) {
        // Either extend previous subarray or start new one
        currentSum = Math.max(nums[i], currentSum + nums[i]);
        
        // Update global maximum
        maxSum = Math.max(maxSum, currentSum);
    }
    
    return maxSum;
}
```

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

---

## Related Problems

### 2. Best Time to Buy and Sell Stock

**Difficulty:** Easy

**Problem Statement:**
You are given an array `prices` where `prices[i]` is the price of a given stock on the `i`-th day. You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock. Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

**Example:**
```java
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: No profit can be made, so return 0.
```

**Key Idea:** Keep track of the minimum price encountered so far. The profit at any day is the current price minus the minimum price. Update the maximum profit if the current profit is greater. This is a variation of the maximum subarray problem.

**Connection to Kadane's:** If we convert prices to daily profit (difference between consecutive days), this becomes maximum subarray!

**Hints:**
- Track minimum price seen so far
- At each day, calculate profit if sold today
- Update max profit

**Solution (Direct Approach):**
```java
public int maxProfit(int[] prices) {
    int minPrice = Integer.MAX_VALUE;
    int maxProfit = 0;
    
    for (int price : prices) {
        // Update minimum price
        minPrice = Math.min(minPrice, price);
        
        // Calculate profit if sold today
        int profit = price - minPrice;
        
        // Update maximum profit
        maxProfit = Math.max(maxProfit, profit);
    }
    
    return maxProfit;
}
```

**Solution (Kadane's Approach):**
```java
public int maxProfit(int[] prices) {
    int maxProfit = 0;
    int currentProfit = 0;
    
    for (int i = 1; i < prices.length; i++) {
        // Daily change in price
        int dailyChange = prices[i] - prices[i - 1];
        
        // Apply Kadane's algorithm on daily changes
        currentProfit = Math.max(0, currentProfit + dailyChange);
        maxProfit = Math.max(maxProfit, currentProfit);
    }
    
    return maxProfit;
}
```

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

---

### 3. Maximum Product Subarray

**Difficulty:** Medium

**Problem Statement:**
Given an integer array `nums`, find a subarray that has the largest product, and return the product.

**Example:**
```java
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product = 6.

Input: nums = [-2,0,-1]
Output: 0
```

**Key Idea:** Similar to Kadane's, but track both maximum and minimum products (because negative × negative = positive). A negative number can turn a small product into a large one!

**Hints:**
- Track both max and min products ending at current position
- Negative number can make min become max
- Handle zero separately (resets both)

**Solution:**
```java
public int maxProduct(int[] nums) {
    int maxProduct = nums[0];
    int currentMax = nums[0];
    int currentMin = nums[0];
    
    for (int i = 1; i < nums.length; i++) {
        int num = nums[i];
        
        // If current number is negative, swap max and min
        if (num < 0) {
            int temp = currentMax;
            currentMax = currentMin;
            currentMin = temp;
        }
        
        // Update current max and min
        currentMax = Math.max(num, currentMax * num);
        currentMin = Math.min(num, currentMin * num);
        
        // Update global maximum
        maxProduct = Math.max(maxProduct, currentMax);
    }
    
    return maxProduct;
}
```

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

---

### 4. Maximum Sum Circular Subarray

**Difficulty:** Medium

**Problem Statement:**
Given a circular integer array `nums` of length `n`, return the maximum possible sum of a non-empty subarray of `nums`. A circular array means the end of the array connects to the beginning.

**Example:**
```java
Input: nums = [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum = 3.

Input: nums = [5,-3,5]
Output: 10
Explanation: Subarray [5,5] (circular) has maximum sum = 10.
```

**Key Idea:** Maximum circular sum = max(normal Kadane's, total_sum - minimum_subarray_sum). The second case handles wraparound.

**Solution:**
```java
public int maxSubarraySumCircular(int[] nums) {
    int totalSum = 0;
    int maxSum = nums[0];
    int minSum = nums[0];
    int currentMax = nums[0];
    int currentMin = nums[0];
    
    totalSum = nums[0];
    
    for (int i = 1; i < nums.length; i++) {
        totalSum += nums[i];
        
        // Regular Kadane's for maximum
        currentMax = Math.max(nums[i], currentMax + nums[i]);
        maxSum = Math.max(maxSum, currentMax);
        
        // Kadane's for minimum
        currentMin = Math.min(nums[i], currentMin + nums[i]);
        minSum = Math.min(minSum, currentMin);
    }
    
    // If all numbers are negative, return maxSum
    if (maxSum < 0) {
        return maxSum;
    }
    
    // Otherwise return max of normal or circular
    return Math.max(maxSum, totalSum - minSum);
}
```

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

---

### 5. Maximum Alternating Subarray Sum

**Difficulty:** Hard

**Problem Statement:**
A subarray of `nums` is called alternating if any two consecutive elements in it have opposite signs. Return the maximum sum of any alternating subarray of `nums`.

**Example:**
```java
Input: nums = [3,2,-1,4,-2,5]
Output: 13
Explanation: [3,2,-1,4,-2,5] is alternating and has sum 11.
Actually [2,-1,4,-2,5] = 8 is not the max.
The maximum is [3,2,-1,4,-2,5] - wait, that's not alternating!
```

*(Note: This problem needs careful definition of "alternating")*

---

### 6. House Robber (Kadane's Variant)

**Difficulty:** Medium

**Problem Statement:**
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected. Given an integer array `nums` representing the amount of money of each house, return the maximum amount of money you can rob without alerting the police.

**Example:**
```java
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3). Total = 1 + 3 = 4.

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1). Total = 2 + 9 + 1 = 12.
```

**Key Idea:** At each house, decide to rob it (can't rob previous) or skip it (take best up to previous).

**Solution:**
```java
public int rob(int[] nums) {
    if (nums.length == 0) return 0;
    if (nums.length == 1) return nums[0];
    
    int prev2 = 0;     // Best sum up to i-2
    int prev1 = 0;     // Best sum up to i-1
    
    for (int num : nums) {
        int current = Math.max(prev1, prev2 + num);
        prev2 = prev1;
        prev1 = current;
    }
    
    return prev1;
}
```

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

---

## Practice Resources

- [LeetCode - Dynamic Programming](https://leetcode.com/tag/dynamic-programming/)
- [NeetCode - 1D Dynamic Programming](https://www.youtube.com/playlist?list=PLot-Xpze53leU0Ec0VkBhnf4npMRFiNcB)

---

## Key Insights

1. **Core Pattern:** At each step, decide to extend or start fresh
   ```java
   current = max(element, current + element)
   ```

2. **Variations:**
   - **Product instead of sum** → Track both max and min
   - **Circular array** → Also find minimum subarray
   - **Constraints** → Add state (like House Robber)

3. **When to Use Kadane's:**
   - Finding maximum/minimum **subarray** sum/product
   - **Contiguous** elements
   - Can extend or restart at each step

4. **Common Mistake:** Forgetting to handle all negative numbers

---

## Compare with Brute Force

**Brute Force:** O(n²) or O(n³)
```java
// Try all subarrays
for (int i = 0; i < n; i++) {
    for (int j = i; j < n; j++) {
        // Calculate sum from i to j
    }
}
```

**Kadane's:** O(n)
```java
// Single pass, track current and max
for (int i = 0; i < n; i++) {
    current = max(nums[i], current + nums[i]);
    maxSum = max(maxSum, current);
}
```

**Improvement:** From O(n²) → O(n), huge performance gain!

---

## Tips

- Always track **both current sum and max sum**
- Handle **all negative arrays** (return max element)
- For **product**, track both max and min (negatives flip signs)
- For **circular**, consider both normal and wraparound cases
- Test with: all positive, all negative, mixed, single element
