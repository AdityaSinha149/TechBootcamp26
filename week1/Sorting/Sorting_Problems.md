# Sorting Practice Problems

These problems help you understand sorting algorithms and how sorting can simplify problem-solving.

## 1. Majority Element

**Difficulty:** Easy

**Problem Statement:**
Given an array `nums` of size `n`, return the majority element. The majority element is the element that appears more than `⌊n / 2⌋` times. You may assume that the majority element always exists in the array.

**Example:**
```java
Input: nums = [3,2,3]
Output: 3
```

**Key Idea:** If an element appears more than `n/2` times, and the array is sorted, the majority element will always be at index `n/2`.
Sort the array and return `nums[n/2]`.

---

## 2. Missing Number

**Difficulty:** Easy

**Problem Statement:**
Given an array `nums` containing `n` distinct numbers in the range `[0, n]`, return the only number in the range that is missing from the array.

**Example:**
```java
Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
```

**Key Idea:** Sort the array. The first index `i` where `nums[i] != i` is the missing number. If all match, then `n` is the missing number.

---

## 3. Sort Colors

**Difficulty:** Medium

**Problem Statement:**
Given an array `nums` with `n` objects colored red, white, or blue, sort them **in-place** so that objects of the same color are adjacent, with the colors in the order red, white, and blue. We will use the integers `0`, `1`, and `2` to represent the color red, white, and blue, respectively.

**Example:**
```java
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
```

**Key Idea:** This is the "Dutch National Flag" problem. You can solve it with a single pass using three pointers: `low`, `mid`, and `high`.
- If `nums[mid]` is 0, swap `nums[low]` and `nums[mid]`, increment `low` and `mid`.
- If `nums[mid]` is 1, increment `mid`.
- If `nums[mid]` is 2, swap `nums[mid]` and `nums[high]`, decrement `high`.
