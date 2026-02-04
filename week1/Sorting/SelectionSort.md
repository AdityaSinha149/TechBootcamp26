<h2>Selection Sort (Java)</h2>

<p>
Selection Sort is a comparison-based sorting algorithm. It sorts an array by repeatedly
finding the smallest element from the unsorted portion and swapping it with the first
unsorted element. This process continues until the entire array is sorted.
</p>

<h3>How Selection Sort Works</h3>
<ul>
  <li>Find the smallest element in the array and swap it with the first element.</li>
  <li>Find the smallest element in the remaining unsorted portion and swap it with the second element.</li>
  <li>Repeat the process until the array is fully sorted.</li>
</ul>
<img src="https://private-user-images.githubusercontent.com/148266037/398221406-ae349bdd-141b-47eb-be04-ca3a464579bd.png?jwt=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3NzAyMjk5MTMsIm5iZiI6MTc3MDIyOTYxMywicGF0aCI6Ii8xNDgyNjYwMzcvMzk4MjIxNDA2LWFlMzQ5YmRkLTE0MWItNDdlYi1iZTA0LWNhM2E0NjQ1NzliZC5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjYwMjA0JTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI2MDIwNFQxODI2NTNaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT1mOGNmM2MyMjhhNmJiMzdhMzg1NGU3NjQyODMxMTM5MTUxZGEzOTA0ZWM5MTgxMjhjNzJhZjM0ODgwMWUwOGU1JlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.3F0GoE1BCdo1LeYnMG4o5Hj8FhmgPfPo-Buz3Xlingk">
<h3>Java Implementation</h3>

<pre><code class="language-java">
class SelectionSort {

    static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i &lt; n - 1; i++) {

            // Assume the current index holds the minimum
            int minIndex = i;

            // Find the minimum element in remaining array
            for (int j = i + 1; j &lt; n; j++) {
                if (arr[j] &lt; arr[minIndex]) {
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
</code></pre>

<h3>Output</h3>

<pre>
Original array: 64 25 12 22 11
Sorted array:   11 12 22 25 64
</pre>

<h3>Complexity Analysis</h3>
<ul>
  <li><b>Time Complexity:</b> O(n<sup>2</sup>)<br>
  <ul>
    <li>One loop to select an element of Array one by one = O(n)</li>
<li>Another loop to compare that element with every other Array element = O(n)</li>
<li>Therefore overall complexity = O(n) * O(n) = O(n*n) = O(n2)</li>
  </ul></li>
  <li><b>Auxiliary Space:</b> O(1)</li>
</ul>

<h3>Advantages</h3>
<ul>
  <li>Simple and easy to understand.</li>
  <li>Uses constant extra space.</li>
  <li>Performs fewer swaps compared to many sorting algorithms.</li>
</ul>

<h3>Disadvantages</h3>
<ul>
  <li>Time complexity of O(n<sup>2</sup>) makes it inefficient for large datasets.</li>
  <li>Not a stable sorting algorithm i.e. does not maintain the relative order of equal elements.</li>
</ul>

<h3>References</h3>
<ul>
  <li><a href="https://takeuforward.org/sorting/selection-sort-algorithm/">Take U Forward</a></li>
  <li><a href="https://www.geeksforgeeks.org/selection-sort-algorithm-2/">GeeksforGeeks</a></li>
</ul>
