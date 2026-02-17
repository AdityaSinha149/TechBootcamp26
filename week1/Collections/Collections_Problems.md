# Java Collections Practice Problems

These problems are designed to help you get comfortable with Java's `ArrayList`, `HashSet`, `HashMap`, `Queue`, and `Deque`.

---

## Easy Problems

### 1. Contains Duplicate

**Difficulty:** Easy

**Problem Statement:**
Given an integer array `nums`, return `true` if any value appears **at least twice** in the array, and return `false` if every element is distinct.

**Example:**
```java
Input: nums = [1,2,3,1]
Output: true

Input: nums = [1,2,3,4]
Output: false
```

**Key Idea:** Use a `HashSet` to store elements as you iterate. If an element is already in the set, you've found a duplicate.

**Hints:**
- Use `HashSet.contains()` to check if element exists
- `HashSet.add()` returns `false` if element already exists

**Solution:**
```java
public boolean containsDuplicate(int[] nums) {
    HashSet<Integer> seen = new HashSet<>();
    
    for (int num : nums) {
        if (seen.contains(num)) {
            return true;  // Found a duplicate
        }
        seen.add(num);
    }
    
    return false;  // No duplicates found
}
```

**Time Complexity:** O(n)  
**Space Complexity:** O(n)

---

### 2. Valid Anagram

**Difficulty:** Easy

**Problem Statement:**
Given two strings `s` and `t`, return `true` if `t` is an anagram of `s`, and `false` otherwise. An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

**Example:**
```java
Input: s = "anagram", t = "nagaram"
Output: true

Input: s = "rat", t = "car"
Output: false
```

**Key Idea:** Use a `HashMap` to count the occurrences of each character in `s`. Then decrement the counts for each character in `t`. If all counts are zero, it's an anagram.

**Hints:**
- Use `HashMap<Character, Integer>` to store character frequencies
- Can also use `getOrDefault()` for cleaner code
- Both strings must have the same length

**Solution:**
```java
public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }
    
    HashMap<Character, Integer> charCount = new HashMap<>();
    
    // Count characters in s
    for (char c : s.toCharArray()) {
        charCount.put(c, charCount.getOrDefault(c, 0) + 1);
    }
    
    // Decrement for characters in t
    for (char c : t.toCharArray()) {
        if (!charCount.containsKey(c)) {
            return false;
        }
        charCount.put(c, charCount.get(c) - 1);
        if (charCount.get(c) < 0) {
            return false;
        }
    }
    
    return true;
}
```

**Time Complexity:** O(n)  
**Space Complexity:** O(1) or O(26) for lowercase English letters

---

### 3. Intersection of Two Arrays

**Difficulty:** Easy

**Problem Statement:**
Given two integer arrays `nums1` and `nums2`, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

**Example:**
```java
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4] or [4,9]
```

**Key Idea:** Add elements of `nums1` to a `HashSet`. Then iterate through `nums2` and check if the element exists in the set. If it does, add it to a result set to ensure uniqueness.

**Hints:**
- Use two `HashSet`s: one for nums1, one for results
- Can convert result `HashSet` to array at the end

**Solution:**
```java
public int[] intersection(int[] nums1, int[] nums2) {
    HashSet<Integer> set1 = new HashSet<>();
    HashSet<Integer> resultSet = new HashSet<>();
    
    // Add all elements from nums1 to set
    for (int num : nums1) {
        set1.add(num);
    }
    
    // Check which elements from nums2 are in set1
    for (int num : nums2) {
        if (set1.contains(num)) {
            resultSet.add(num);
        }
    }
    
    // Convert set to array
    int[] result = new int[resultSet.size()];
    int i = 0;
    for (int num : resultSet) {
        result[i++] = num;
    }
    
    return result;
}
```

**Time Complexity:** O(n + m) where n and m are lengths of arrays  
**Space Complexity:** O(n + m)

---

### 4. Two Sum

**Difficulty:** Easy

**Problem Statement:**
Given an array of integers `nums` and an integer `target`, return indices of the two numbers such that they add up to `target`. You may assume that each input would have exactly one solution, and you may not use the same element twice.

**Example:**
```java
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: nums[0] + nums[1] = 2 + 7 = 9
```

**Key Idea:** Use a `HashMap` to store each number and its index. For each element, check if `target - current` exists in the map.

**Hints:**
- HashMap: key = number, value = index
- Check for complement before adding to map

**Solution:**
```java
public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        
        if (map.containsKey(complement)) {
            return new int[] {map.get(complement), i};
        }
        
        map.put(nums[i], i);
    }
    
    return new int[] {}; // No solution found
}
```

**Time Complexity:** O(n)  
**Space Complexity:** O(n)

---

### 5. First Unique Character in a String

**Difficulty:** Easy

**Problem Statement:**
Given a string `s`, find the first non-repeating character in it and return its index. If it does not exist, return `-1`.

**Example:**
```java
Input: s = "leetcode"
Output: 0

Input: s = "loveleetcode"
Output: 2

Input: s = "aabb"
Output: -1
```

**Key Idea:** Use a `HashMap` to count frequency of each character. Then iterate through the string again to find the first character with frequency 1.

**Solution:**
```java
public int firstUniqChar(String s) {
    HashMap<Character, Integer> charCount = new HashMap<>();
    
    // Count frequencies
    for (char c : s.toCharArray()) {
        charCount.put(c, charCount.getOrDefault(c, 0) + 1);
    }
    
    // Find first unique character
    for (int i = 0; i < s.length(); i++) {
        if (charCount.get(s.charAt(i)) == 1) {
            return i;
        }
    }
    
    return -1;
}
```

**Time Complexity:** O(n)  
**Space Complexity:** O(1) – at most 26 lowercase letters

---

### 6. Group Anagrams

**Difficulty:** Medium

**Problem Statement:**
Given an array of strings `strs`, group the anagrams together. You can return the answer in any order.

**Example:**
```java
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
```

**Key Idea:** Sort each string and use it as a key in a `HashMap`. All anagrams will have the same sorted key.

**Hints:**
- HashMap: key = sorted string, value = list of original strings
- Use `Arrays.sort()` and `new String(charArray)` to create key

**Solution:**
```java
import java.util.*;

public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, List<String>> map = new HashMap<>();
    
    for (String str : strs) {
        // Sort the string to use as key
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String key = new String(chars);
        
        // Add to map
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(str);
    }
    
    return new ArrayList<>(map.values());
}
```

**Time Complexity:** O(n * k log k) where n is number of strings, k is max length  
**Space Complexity:** O(n * k)

---

## Practice Resources

- [LeetCode - Hash Table Problems](https://leetcode.com/tag/hash-table/)
- [HackerRank - Data Structures](https://www.hackerrank.com/domains/data-structures)
- [GeeksforGeeks - Java Collections](https://www.geeksforgeeks.org/collections-in-java-2/)

---

## Tips for Using Collections

1. **HashSet** is best for:
   - Checking if an element exists (O(1))
   - Removing duplicates
   - Set operations (union, intersection)

2. **HashMap** is best for:
   - Counting frequencies
   - Finding pairs/complements
   - Caching results

3. **ArrayList** is best for:
   - Sequential access
   - Dynamic arrays
   - When order matters

4. **LinkedList** is best for:
   - Frequent insertions/deletions
   - Queue/Stack operations

5. **TreeSet/TreeMap** is best for:
   - Sorted data
   - Range queries
   - When you need min/max efficiently

---

## Common Patterns

### Pattern 1: Frequency Counting
```java
HashMap<Integer, Integer> freq = new HashMap<>();
for (int num : arr) {
    freq.put(num, freq.getOrDefault(num, 0) + 1);
}
```

### Pattern 2: Finding Complement
```java
HashMap<Integer, Integer> map = new HashMap<>();
for (int num : arr) {
    int complement = target - num;
    if (map.containsKey(complement)) {
        // Found pair
    }
    map.put(num, index);
}
```

### Pattern 3: Removing Duplicates
```java
HashSet<Integer> set = new HashSet<>();
for (int num : arr) {
    set.add(num);
}
```

### Pattern 4: Checking Existence
```java
HashSet<Integer> set = new HashSet<>(Arrays.asList(arr));
if (set.contains(target)) {
    // Element exists
}
```
