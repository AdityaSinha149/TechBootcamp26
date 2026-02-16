# Java Collections Practice Problems

These problems are designed to help you get comfortable with Java's `ArrayList`, `HashSet`, and `HashMap`.

## 1. Contains Duplicate

**Difficulty:** Easy

**Problem Statement:**
Given an integer array `nums`, return `true` if any value appears **at least twice** in the array, and return `false` if every element is distinct.

**Example:**
```java
Input: nums = [1,2,3,1]
Output: true
```

**Key Idea:** Use a `HashSet` to store elements as you iterate. If an element is already in the set, you've found a duplicate.

---

## 2. Valid Anagram

**Difficulty:** Easy

**Problem Statement:**
Given two strings `s` and `t`, return `true` if `t` is an anagram of `s`, and `false` otherwise. An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

**Example:**
```java
Input: s = "anagram", t = "nagaram"
Output: true
```

**Key Idea:** Use a `HashMap` (or a frequency array if characters are limited) to count the occurrences of each character in `s`. Then decrement the counts for each character in `t`. If all counts ensure to be zero, it's an anagram.

---

## 3. Intersection of Two Arrays

**Difficulty:** Easy

**Problem Statement:**
Given two integer arrays `nums1` and `nums2`, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

**Example:**
```java
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
```

**Key Idea:** Add elements of `nums1` to a `HashSet`. Then iterate through `nums2` and check if the element exists in the set. If it does, add it to a result list (or another set to ensure uniqueness) and remove it from the first set to avoid duplicates.

---

## 4. Single Number

**Difficulty:** Easy

**Problem Statement:**
Given a non-empty array of integers `nums`, every element appears twice except for one. Find that single one. You must implement a solution with a linear runtime complexity and use only constant extra space.

**Example:**
```java
Input: nums = [2,2,1]
Output: 1
```

**Key Idea:** While this can be solved with a `HashSet` (add if not present, remove if present, the last one remaining is the answer), the optimal solution uses XOR bitwise operation. However, for collections practice, try the `HashSet` or `HashMap` approach first.
