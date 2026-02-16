# Two Pointers Practice Problems

Here are some standard problems to master the Two Pointers technique. These are chosen to build your intuition for when and how to use this pattern.

## 1. Valid Palindrome

**Difficulty:** Easy

**Problem Statement:**
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers. Given a string `s`, return `true` if it is a palindrome, or `false` otherwise.

**Example:**
```java
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
```

**Key Idea:** Use two pointers, one at the start and one at the end. Move them towards each other, skipping non-alphanumeric characters. If characters at pointers don't match, it's not a palindrome.

---

## 2. Reverse String

**Difficulty:** Easy

**Problem Statement:**
Write a function that reverses a string. The input string is given as an array of characters `s`. You must do this by modifying the input array in-place with O(1) extra memory.

**Example:**
```java
Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
```

**Key Idea:** Swap the characters at the start and end pointers, then move start forward and end backward until they meet.

---

## 3. Two Sum II - Input Array Is Sorted

**Difficulty:** Medium (Concept is Easy)

**Problem Statement:**
Given a 1-indexed array of integers `numbers` that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number.

**Example:**
```java
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2.
```

**Key Idea:** Since the array is sorted, if the sum of elements at left and right pointers is less than target, increment left. If greater, decrement right.

---

## 4. Move Zeroes

**Difficulty:** Easy

**Problem Statement:**
Given an integer array `nums`, move all `0`'s to the end of it while maintaining the relative order of the non-zero elements. Note that you must do this in-place without making a copy of the array.

**Example:**
```java
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
```

**Key Idea:** Use a "read" pointer to iterate through the array and a "write" pointer to keep track of the position for the next non-zero element.
