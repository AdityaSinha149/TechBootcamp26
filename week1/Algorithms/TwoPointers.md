# Two Pointers
## Problem Statement (Two Sum II)
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be **numbers[index1]** and **numbers[index2]** where **1 <= index1 < index2 <= numbers.length**

Note: Problem assumes there is only 1 unique solution

Example:
`
numbers = [2,7,11,15], target = 9
`

Output:
`
[1,2]
`

## How It Works
Since the array is sorted we initialize two pointers `l` and `r` where l will point to the smallest element(at the beginning of the array) and r points to the largest element(at the end of the array)

at each step we compute:
- if `numbers[l]+numbers[r]==target` we return the answer
- if `numbers[l]+numbers[r]<target` we increment l (increasing the value of the sum)
- else if `numbers[l]+numbers[r]>target ` we decrement r (decreasing the value of the sum)
  
## Dry Run
Example : `numbers = [2,7,11,15], target = 9`

| l | r | numbers[l] | numbers[r] | numbers[l]+numbers[r] | Action |
|------|--------|---------------|----------------|-----|--------|
| 0    | 3      | 2             | 15             | 17  | numbers[l]+numbers[r] > target → r-- |
| 0    | 2      | 2             | 11             | 13  | numbers[l]+numbers[r] > target → r-- |
| 0    | 1      | 2             | 7              | 9   | numbers[l]+numbers[r] == target → return |


## Java Implementation

```java
    public int[] twoSum(int[] numbers, int target) {
        int n=numbers.length;
        int l=0;
        int r=n-1;
        while(l<r){
            if(numbers[l]+numbers[r]==target){
                return new int[]{l+1, r+1};
            }
            else if(numbers[l]+numbers[r]<target){
                l++;
            }
            else{
                r--;
            }
        }
        return new int[]{};
    }

```

## Time Complexity Analysis
Let n be the size of the array
- Each step moves either left forward or right backward.
- Each pointer moves at most n times.
  
`Time Complexity: O(n)`

## Space Complexity Analysis
Let n be the size of the array

we use two variables only
- l
- r

no auxillary space is used

`Space Complexity:O(1)`

## More Two Pointer Problems
- Container with most water
- Remove duplicates from sorted array
- 3Sum

