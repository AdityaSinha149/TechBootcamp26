<h2>Bubble Sort (Java)</h2>

<p>
Bubble Sort is one of the simplest sorting algorithms. It is usually the first sorting
technique taught to beginners because it is easy to understand and implement.
</p>

<p>
The idea of Bubble Sort is very simple: compare two adjacent elements and swap them
if they are in the wrong order. By repeating this process, the largest elements
gradually move (or "bubble") to the end of the array.
</p>

<hr>

<h3>Real-Life Example</h3>

<p>
Imagine arranging books on a shelf from smallest to largest height. You compare two
books at a time and swap them if the taller book comes first. After one full pass,
the tallest book reaches the end of the shelf. This is exactly how Bubble Sort works.
</p>

<hr>

<h3>How Bubble Sort Works (Step-by-Step)</h3>

<ul>
  <li>Start from the first element of the array.</li>
  <li>Compare the current element with the next element.</li>
  <li>If the current element is greater, swap them.</li>
  <li>Move one step forward and repeat the comparison.</li>
  <li>After one complete pass, the largest element moves to the last position.</li>
  <li>Repeat the above steps for the remaining unsorted part of the array.</li>
</ul>

<hr>

<h3>Dry Run Example</h3>

<p>
Consider the array:
</p>

<pre>
[5, 1, 4, 2, 8]
</pre>

<p><b>First Pass:</b></p>
<pre>
(5,1) → swap → [1,5,4,2,8]
(5,4) → swap → [1,4,5,2,8]
(5,2) → swap → [1,4,2,5,8]
(5,8) → no swap
</pre>

<p>
After the first pass, the largest element <b>8</b> is at the end.
</p>

<p><b>Second Pass:</b></p>
<pre>
(1,4) → no swap
(4,2) → swap → [1,2,4,5,8]
(4,5) → no swap
</pre>
<img width=800 src="https://favtutor.com/resources/images/uploads/mceu_61632030011682402256084.png">
<p>
This continues until the array is completely sorted.
</p>

<hr>

<h3>Java Implementation</h3>

<pre><code class="language-java">
class BubbleSort {

    // Function to perform Bubble Sort
    static void bubbleSort(int[] arr) {
        int n = arr.length;

        // Outer loop controls number of passes
        for (int i = 0; i &lt; n - 1; i++) {

            // Inner loop compares adjacent elements
            for (int j = 0; j &lt; n - i - 1; j++) {

                // If current element is greater than next
                if (arr[j] &gt; arr[j + 1]) {

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
</code></pre>

<hr>

<h3>Output</h3>

<pre>
Original array: 5 1 4 2 8
Sorted array:   1 2 4 5 8
</pre>
<hr>

<h3>Time Complexity Analysis (Detailed)</h3>

<p>
Bubble Sort uses two nested loops:
</p>

<ul>
  <li>The <b>outer loop</b> runs from 0 to n-1 → it controls the number of passes.</li>
  <li>The <b>inner loop</b> runs from 0 to (n - i - 1) → it performs comparisons.</li>
</ul>

<p>
In the worst case:
</p>

<ul>
  <li>First pass → (n - 1) comparisons</li>
  <li>Second pass → (n - 2) comparisons</li>
  <li>...</li>
  <li>Last pass → 1 comparison</li>
</ul>

<p>
Total comparisons:
</p>

<pre>
(n - 1) + (n - 2) + ... + 1 = n(n - 1)/2
</pre>

<p>
Ignoring constants:
</p>

<pre>
Time Complexity = O(n²)
</pre>

<ul>
  <li><b>Best Case:</b> O(n) (already sorted array with optimized version)</li>
  <li><b>Average Case:</b> O(n²)</li>
  <li><b>Worst Case:</b> O(n²)</li>
  <li><b>Auxiliary Space:</b> O(1)</li>
</ul>

<hr>

<h3>Why Bubble Sort Is Called "Bubble" Sort</h3>

<p>
The largest element moves step-by-step to the end of the array in each pass,
just like a bubble rising to the surface of water.
</p>

<hr>

<h3>Advantages</h3>

<ul>
  <li>Very easy to understand and implement.</li>
  <li>Useful for learning basic sorting concepts.</li>
  <li>Stable sorting algorithm.</li>
  <li>Uses constant extra memory.</li>
</ul>

<hr>

<h3>Disadvantages</h3>

<ul>
  <li>Very slow for large datasets as time complexity is O(n<sup>2</sup>).</li>
  <li>Not suitable for real-world applications.</li>
  <li>Time complexity is high compared to other algorithms.</li>
</ul>

<hr>

<h3>When to Use Bubble Sort</h3>

<ul>
  <li>When learning sorting algorithms for the first time.</li>
  <li>When the dataset is very small.</li>
  <li>When code simplicity is more important than performance.</li>
</ul>
