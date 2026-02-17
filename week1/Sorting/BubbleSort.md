# Bubble Sort

Bubble Sort is one of the simplest sorting algorithms. It is usually the first sorting technique taught to beginners because it is easy to understand and implement.

The idea of Bubble Sort is very simple: compare two adjacent elements and swap them if they are in the wrong order. By repeating this process, the largest elements gradually move (or "bubble") to the end of the array.

---

## Real-Life Example

Imagine arranging books on a shelf from smallest to largest height. You compare two books at a time and swap them if the taller book comes first. After one full pass, the tallest book reaches the end of the shelf. This is exactly how Bubble Sort works.

---

## How Bubble Sort Works (Step-by-Step)

1. Start from the first element of the array
2. Compare the current element with the next element
3. If the current element is greater, swap them
4. Move one step forward and repeat the comparison
5. After one complete pass, the largest element moves to the last position
6. Repeat the above steps for the remaining unsorted part of the array

---

## Visual Example

Consider the array:
```
[5, 1, 4, 2, 8]
```

### First Pass:
```
(5,1) → swap → [1,5,4,2,8]
(5,4) → swap → [1,4,5,2,8]
(5,2) → swap → [1,4,2,5,8]
(5,8) → no swap → [1,4,2,5,8]
```

After the first pass, the largest element **8** is at the end.

### Second Pass:
```
(1,4) → no swap → [1,4,2,5,8]
(4,2) → swap → [1,2,4,5,8]
(4,5) → no swap → [1,2,4,5,8]
```

### Third Pass:
```
(1,2) → no swap → [1,2,4,5,8]
(2,4) → no swap → [1,2,4,5,8]
```

The array is now sorted!

---

## Java Implementation

```java
class BubbleSort {
    
    // Function to perform Bubble Sort
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        
        // Outer loop controls number of passes
        for (int i = 0; i < n - 1; i++) {
            
            // Inner loop compares adjacent elements
            for (int j = 0; j < n - i - 1; j++) {
                
                // If current element is greater than next
                if (arr[j] > arr[j + 1]) {
                    
                    // Swap the elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    
    // Function to print array
    static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        
        int[] arr = {5, 1, 4, 2, 8};
        
        System.out.print("Original array: ");
        printArray(arr);
        
        bubbleSort(arr);
        
        System.out.print("Sorted array: ");
        printArray(arr);
    }
}
```

### Output:
```
Original array: 5 1 4 2 8
Sorted array:   1 2 4 5 8
```

---

## Optimized Bubble Sort

We can optimize Bubble Sort by detecting if the array is already sorted. If no swaps occur in a pass, the array is sorted and we can stop early.

```java
static void bubbleSortOptimized(int[] arr) {
    int n = arr.length;
    
    for (int i = 0; i < n - 1; i++) {
        boolean swapped = false;  // Track if any swap occurred
        
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                // Swap
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                swapped = true;
            }
        }
        
        // If no swaps occurred, array is sorted
        if (!swapped) break;
    }
}
```

---

## Dry Run with Detailed Steps

**Array:** `[5, 1, 4, 2, 8]`, **Length:** 5

### Pass 1 (i = 0):
| j | Compare | Action | Array State |
|---|---------|--------|-------------|
| 0 | 5 > 1 | Swap | [1, 5, 4, 2, 8] |
| 1 | 5 > 4 | Swap | [1, 4, 5, 2, 8] |
| 2 | 5 > 2 | Swap | [1, 4, 2, 5, 8] |
| 3 | 5 < 8 | No swap | [1, 4, 2, 5, 8] |

**Result:** Largest element (8) is in its correct position.

### Pass 2 (i = 1):
| j | Compare | Action | Array State |
|---|---------|--------|-------------|
| 0 | 1 < 4 | No swap | [1, 4, 2, 5, 8] |
| 1 | 4 > 2 | Swap | [1, 2, 4, 5, 8] |
| 2 | 4 < 5 | No swap | [1, 2, 4, 5, 8] |

**Result:** Second largest element (5) is in its correct position.

### Pass 3 (i = 2):
| j | Compare | Action | Array State |
|---|---------|--------|-------------|
| 0 | 1 < 2 | No swap | [1, 2, 4, 5, 8] |
| 1 | 2 < 4 | No swap | [1, 2, 4, 5, 8] |

**Result:** No swaps occurred → Array is sorted!

---

## Complexity Analysis

### Time Complexity

Bubble Sort uses two nested loops:

- **Outer loop** runs from 0 to n-1 → controls the number of passes
- **Inner loop** runs from 0 to (n - i - 1) → performs comparisons

In the worst case:
- First pass → (n - 1) comparisons
- Second pass → (n - 2) comparisons
- ...
- Last pass → 1 comparison

Total comparisons: `(n - 1) + (n - 2) + ... + 1 = n(n - 1)/2`

Ignoring constants: **Time Complexity = O(n²)**

| Case | Time Complexity | When |
|------|----------------|------|
| Best Case | O(n) | Array is already sorted (with optimization) |
| Average Case | O(n²) | Random order |
| Worst Case | O(n²) | Array is sorted in reverse order |

### Space Complexity

**Auxiliary Space: O(1)** – Only uses a constant amount of extra space (temp variable for swapping).

---

## Why Is It Called "Bubble" Sort?

The largest element moves step-by-step to the end of the array in each pass, just like a bubble rising to the surface of water.

---

## Advantages

- Very easy to understand and implement
- Useful for learning basic sorting concepts
- **Stable sorting algorithm** – maintains relative order of equal elements
- Uses constant extra memory (in-place sorting)
- Can detect if array is already sorted (with optimization)

---

## Disadvantages

- Very slow for large datasets as time complexity is **O(n²)**
- Not suitable for real-world applications with large data
- Much slower than advanced algorithms like Quick Sort, Merge Sort
- Performs many unnecessary comparisons

---

## When to Use Bubble Sort

- When learning sorting algorithms for the first time
- When the dataset is very small (< 10 elements)
- When code simplicity is more important than performance
- When you need a stable sorting algorithm
- When you know the array is nearly sorted

---

## Comparison with Other Sorting Algorithms

| Algorithm | Best Case | Average Case | Worst Case | Space | Stable |
|-----------|-----------|--------------|------------|-------|--------|
| Bubble Sort | O(n) | O(n²) | O(n²) | O(1) | Yes |
| Selection Sort | O(n²) | O(n²) | O(n²) | O(1) | No |
| Insertion Sort | O(n) | O(n²) | O(n²) | O(1) | Yes |
| Merge Sort | O(n log n) | O(n log n) | O(n log n) | O(n) | Yes |
| Quick Sort | O(n log n) | O(n log n) | O(n²) | O(log n) | No |

---

## Practice Problems

Try implementing Bubble Sort for these scenarios:

1. Sort an array in **descending order**
2. Sort an array of **strings** alphabetically
3. Count the number of swaps needed to sort an array
4. Implement bubble sort **recursively**

---

## Key Takeaways

- Bubble Sort repeatedly swaps adjacent elements if they're in wrong order
- After each pass, the largest unsorted element reaches its correct position
- Time complexity is **O(n²)**, making it inefficient for large datasets
- Can be optimized to **O(n)** for already sorted arrays
- It's a **stable** sorting algorithm
- Best used for educational purposes and small datasets
