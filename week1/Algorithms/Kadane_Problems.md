# Kadane's Algorithm Practice Problems

Kadane's Algorithm is a dynamic programming approach used to solve maximum subarray problems.

## 1. Maximum Subarray

**Difficulty:** Medium

**Problem Statement:**
Given an integer array `nums`, find the subarray which has the largest sum and return its sum.

**Example:**
```java
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
```

**Key Idea:** Iterate through the array, keeping track of the current subarray sum and the maximum sum found so far. If the current sum becomes negative, reset it to 0 (or the current element if all are negative).

---

## 2. Best Time to Buy and Sell Stock

**Difficulty:** Easy

**Problem Statement:**
You are given an array `prices` where `prices[i]` is the price of a given stock on the `i`-th day. You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock. Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

**Example:**
```java
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
```

**Key Idea:** Keep track of the minimum price encountered so far. The profit at any day is the current price minus the minimum price. Update the maximum profit if the current profit is greater. This is a variation of the maximum subarray problem.
