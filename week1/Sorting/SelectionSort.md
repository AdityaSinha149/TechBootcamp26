# Selection Sort

Selection Sort is a comparison-based sorting algorithm. It sorts an array by repeatedly finding the smallest element from the unsorted portion and swapping it with the first unsorted element. This process continues until the entire array is sorted.

---

## How Selection Sort Works

1. Find the smallest element in the array and swap it with the first element
2. Find the smallest element in the remaining unsorted portion and swap it with the second element
3. Repeat the process until the array is fully sorted

---

## Visual Example

Consider the array:
```
[64, 25, 12, 22, 11]
```

### Pass 1:
- Find minimum in `[64, 25, 12, 22, 11]` → **11**
- Swap with first element (64)
- Result: `[11, 25, 12, 22, 64]`

### Pass 2:
- Find minimum in `[25, 12, 22, 64]` → **12**
- Swap with first unsorted element (25)
- Result: `[11, 12, 25, 22, 64]`

### Pass 3:
- Find minimum in `[25, 22, 64]` → **22**
- Swap with first unsorted element (25)
- Result: `[11, 12, 22, 25, 64]`

### Pass 4:
- Find minimum in `[25, 64]` → **25**
- Already in correct position
- Result: `[11, 12, 22, 25, 64]`

Array is now sorted!

---

## Dry Run with Detailed Steps

**Array:** `[64, 25, 12, 22, 11]`, **Length:** 5

| Pass | Unsorted Portion | Min Element | Min Index | Swap With | Array After Swap |
|------|------------------|-------------|-----------|-----------|------------------|
| 1 | [64, 25, 12, 22, 11] | 11 | 4 | 64 (index 0) | [11, 25, 12, 22, 64] |
| 2 | [25, 12, 22, 64] | 12 | 2 | 25 (index 1) | [11, 12, 25, 22, 64] |
| 3 | [25, 22, 64] | 22 | 3 | 25 (index 2) | [11, 12, 22, 25, 64] |
| 4 | [25, 64] | 25 | 3 | 25 (index 3) | [11, 12, 22, 25, 64] |

---

## Java Implementation

```java
class SelectionSort {
    
    static void selectionSort(int[] arr) {
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            
            // Assume the current index holds the minimum
            int minIndex = i;
            
            // Find the minimum element in remaining array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            
            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    
    static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        
        System.out.print("Original array: ");
        printArray(arr);
        
        selectionSort(arr);
        
        System.out.print("Sorted array: ");
        printArray(arr);
    }
}
```

### Output:
```
Original array: 64 25 12 22 11
Sorted array:   11 12 22 25 64
```

---

## Algorithm Explanation

### Step-by-Step Logic

1. **Initialize**: Start with index `i = 0`
2. **Find Minimum**: 
   - Set `minIndex = i`
   - Scan from `i+1` to end of array
   - Update `minIndex` whenever a smaller element is found
3. **Swap**: Swap `arr[i]` with `arr[minIndex]`
4. **Repeat**: Move to next index (`i++`) and repeat until array is sorted

---

## Complexity Analysis

### Time Complexity

Selection Sort uses two nested loops:

- **Outer loop**: Runs from index 0 to n-2 (n-1 iterations)
- **Inner loop**: Runs from index i+1 to n-1

**Number of comparisons:**
- Pass 1: (n - 1) comparisons
- Pass 2: (n - 2) comparisons
- ...
- Pass n-1: 1 comparison

Total: `(n-1) + (n-2) + ... + 1 = n(n-1)/2 = O(n²)`

| Case | Time Complexity | Explanation |
|------|----------------|-------------|
| Best Case | **O(n²)** | Even if sorted, still makes all comparisons |
| Average Case | **O(n²)** | Random order |
| Worst Case | **O(n²)** | Reverse sorted |

**Key Point:** Unlike Bubble Sort, Selection Sort **always** takes O(n²) time, regardless of input!

### Space Complexity

**Auxiliary Space: O(1)** – Only uses a few variables (`i`, `j`, `minIndex`, `temp`)

---

## Number of Swaps

Selection Sort makes **at most (n - 1) swaps**, which is much fewer than Bubble Sort.

**Example:** For array `[3, 1, 2]`
- Bubble Sort: 2 swaps
- Selection Sort: 2 swaps

**Example:** For array `[5, 4, 3, 2, 1]`
- Bubble Sort: 10 swaps
- Selection Sort: 2 swaps (only swap positions 0↔4 and 1↔3)

---

## Advantages

- **Simple and easy to understand** – Good for learning sorting concepts
- **Uses constant extra space** – O(1) auxiliary space
- **Performs fewer swaps** compared to Bubble Sort – useful when writing to memory is expensive
- **In-place sorting** – Doesn't require additional arrays

---

## Disadvantages

- **Time complexity of O(n²)** makes it inefficient for large datasets
- **Not stable** – Does not maintain the relative order of equal elements
- **No early termination** – Always makes O(n²) comparisons even if array is sorted

---

## Stability Example

Selection Sort is **NOT stable**. Consider:
```
Original: [4a, 3, 4b, 2]
After Selection Sort: [2, 3, 4b, 4a]
```

Notice that `4b` comes before `4a` in the sorted array, changing the original relative order.

---

## When to Use Selection Sort

- When **memory writes are expensive** (fewer swaps than Bubble Sort)
- When the dataset is **small** (< 20 elements)
- When you need a **simple implementation** for educational purposes
- When **auxiliary space is limited** (in-place sorting)

---

## Comparison with Other Sorting Algorithms

| Algorithm | Best Case | Average Case | Worst Case | Space | Stable | Swaps |
|-----------|-----------|--------------|------------|-------|--------|-------|
| **Selection Sort** | O(n²) | O(n²) | O(n²) | O(1) | No | O(n) |
| Bubble Sort | O(n) | O(n²) | O(n²) | O(1) | Yes | O(n²) |
| Insertion Sort | O(n) | O(n²) | O(n²) | O(1) | Yes | O(n²) |
| Merge Sort | O(n log n) | O(n log n) | O(n log n) | O(n) | Yes | - |
| Quick Sort | O(n log n) | O(n log n) | O(n²) | O(log n) | No | - |

---

## Practice Problems

Try these exercises to master Selection Sort:

1. **Sort in descending order** – Modify the algorithm to sort from largest to smallest
2. **Find kth smallest element** – Use Selection Sort logic to find the kth smallest element
3. **Count comparisons** – Track how many comparisons are made for different inputs
4. **Sort strings** – Implement Selection Sort for an array of strings

---

## Key Takeaways

- Selection Sort divides array into **sorted** and **unsorted** portions
- In each pass, it finds the **minimum element** from unsorted portion
- Swaps minimum with the **first unsorted element**
- Time complexity is **always O(n²)**, regardless of input
- Makes **fewer swaps** than Bubble Sort (O(n) vs O(n²))
- **Not stable** – doesn't preserve relative order of equal elements
- Best used for **small datasets** or when **memory writes are expensive**

---

## Additional Resources

- [GeeksforGeeks - Selection Sort](https://www.geeksforgeeks.org/selection-sort-algorithm-2/)
- [Visualgo - Sorting Visualizations](https://visualgo.net/en/sorting)
- [CS50 - Sorting Algorithms](https://cs50.harvard.edu/x/)
