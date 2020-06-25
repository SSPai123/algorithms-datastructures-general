---


---

<h1 id="quick-sort">Quick Sort</h1>
<h2 id="introduction">Introduction</h2>
<ul>
<li>The algorithm was developed by a British computer scientist Tony Hoare in 1959.</li>
<li>The name “Quick Sort” comes from the fact that, quick sort is capable of sorting a list of data elements significantly faster (twice or thrice faster) than any of the common sorting algorithms.</li>
<li>It is one of the most efficient sorting algorithms and is based on the splitting of an array (partition) into smaller ones and sorting (exchange) based on the comparison with ‘pivot’ element selected. Due to this, quick sort is also called as “Partition Exchange” sort.</li>
<li>Like Merge sort, Quick sort also falls into the category of divide and conquer approach of problem-solving methodology.</li>
</ul>
<h2 id="applications">Applications</h2>
<p>Before diving into any algorithm, its very much necessary for us to understand what are the real world applications of it.</p>
<p>Quick sort provides a fast and methodical approach to sort any lists of things. Following are some of the applications where quick sort is used.</p>
<ul>
<li><em><strong>Commercial computing:</strong></em> Used in various government and private organizations for the purpose of sorting various data like sorting of accounts/profiles by name or any given ID, sorting transactions by time or locations, sorting files by name or date of creation etc.</li>
<li><em><strong>Numerical computations:</strong></em> Most of the efficiently developed algorithms use priority queues and inturn sorting to achieve accuracy in all the calculations.</li>
<li><em><strong>Information search:</strong></em> Sorting algorithms aid in better search of information and what faster way exists than to achieve sorting using quick sort.</li>
</ul>
<p>Basically, quick sort is used everywhere for faster results and in the cases where there are space constraints.</p>
<h2 id="explanation">Explanation</h2>
<p>Taking the analogical view in perspective, consider a situation where one had to sort the papers bearing the names of the students, by name from A-Z. One might use the approach as follows:</p>
<ol>
<li>Select any splitting value, say L. The splitting value is also known as  <strong>Pivot</strong>.</li>
<li>Divide the stack of papers into two. A-L and M-Z. It is not necessary that the piles should be equal.</li>
<li>Repeat the above two steps with the A-L pile, splitting it into its significant two halves. And M-Z pile, split into its halves. The process is repeated until the piles are small enough to be sorted easily.</li>
<li>Ultimately, the smaller piles can be placed one on top of the other to produce a fully sorted and ordered set of papers.</li>
<li>The approach used here is  <strong>recursion</strong>  at each split to get to the single-element array.</li>
<li>At every split, the pile was divided and then the same approach was used for the smaller piles.</li>
</ol>
<p>Technically, quick sort follows the below steps:<br>
<strong>Step 1</strong> − Make the right-most index element as pivot<br>
<strong>Step 2</strong> − Partition the array on the basis of pivot<br>
<strong>Step 3</strong> − Apply quick sort on left partition recursively<br>
<strong>Step 4</strong> − Apply quick sort on right partition recursively</p>
<h2 id="step-wise-explanation-with-example">Step wise explanation with example</h2>
<h3 id="problem-statement">Problem Statement</h3>
<p>Consider the following array: 50, 23, 9, 18, 61, 32. We need to sort this array in the most efficient manner without using extra place (inplace sorting).</p>
<h3 id="solution">Solution</h3>
<p><strong>Step 1</strong>:</p>
<ul>
<li><strong><strong>Make the right-most index element as pivot:</strong></strong> Decide any value to be the pivot from the list (generally the last value). Suppose for two values “Low” and “High” corresponding to the first index, and last index.
<ul>
<li>In our case low is 0 and high is 5.</li>
<li>Values at low and high are 50 and 32 and Value of pivot is 32.</li>
</ul>
</li>
<li><strong><strong>Partition the array on the basis of pivot:</strong></strong> Call for partitioning which rearranges the array in such a way that pivot (32) comes to its actual position (of the sorted array). And to the left of the pivot, the array has all the elements less than it, and to the right greater than it.
<ul>
<li>In the partition function, we start from the first element and compare it with the pivot. Since 50 is greater than 32, we don’t make any change and move on to the next element 23.</li>
<li>Compare again with the pivot. Since 23 is less than 32, we swap 50 and 23. The array becomes <code>23, 50, 9, 18, 61, 32</code></li>
<li>We move on to the next element 9 which is again less than pivot (32) thus swapping it with 50 makes our array as <code>23, 9, 50, 18, 61, 32</code>.</li>
<li>Similarly, for next element 18 which is less than 32, the array becomes <code>23, 9, 18, 50, 61, 32</code>. Now 61 is greater than pivot (32), hence no changes.</li>
<li>Lastly, we swap our pivot with 50 so that it comes to the correct position.</li>
</ul>
</li>
</ul>
<p>Thus the pivot (32) comes at its actual position and all elements to its left are lesser, and all elements to the right are greater than itself.</p>
<p><strong>Step 2</strong>: The main array after the first step becomes</p>
<pre><code>23, 9, 18, 32, 61, 50
</code></pre>
<p><strong>Step 3</strong>: Now the list is divided into two parts:</p>
<ol>
<li>Sublist before pivot element</li>
<li>Sublist after pivot element</li>
</ol>
<p><strong>Step 4</strong>: Repeat the steps for the left and right sublists recursively. The final array thus becomes<br>
<code>9, 18, 23, 32, 50, 61</code>.</p>
<p>The following diagram depicts the workflow of the Quick Sort algorithm which was described above.<br>
<img src="https://i.pinimg.com/564x/fe/f8/08/fef8085a6420538e38f6ccfaba04d12f.jpg" alt="Quick Sort Flow"></p>
<h2 id="pseudo-code">Pseudo Code</h2>
<p><em><strong><strong>Quick Sort</strong></strong></em></p>
<pre><code>/**
* The main function that implements quick sort.
* @Parameters: array, starting index and ending index
*/
quickSort(arr[], low, high)
{
    if (low &lt; high)
    {
        // pivot_index is partitioning index, arr[pivot_index] is now at correct place in sorted array
        pivot_index = partition(arr, low, high);

        quickSort(arr, low, pivot_index - 1);  // Before pivot_index
        quickSort(arr, pivot_index + 1, high); // After pivot_index
    }
}
</code></pre>
<p><em><strong><strong>Partition Method</strong></strong></em></p>
<pre><code>/**
* The function selects the last element as pivot element, places that pivot element correctly in the array in such a way
* that all the elements to the left of the pivot are lesser than the pivot and
* all the elements to the right of pivot are greater than it.
* @Parameters: array, starting index and ending index
* @Returns: index of pivot element after placing it correctly in sorted array
*/
partition (arr[], low, high)
{
    // pivot - Element at right most position
    pivot = arr[high];  
    i = (low - 1);  // Index of smaller element
    for (j = low; j &lt;= high-1; j++)
    {
        // If current element is smaller than the pivot, swap the element with pivot
        if (arr[j] &lt; pivot)
        {
            i++;    // increment index of smaller element
            swap(arr[i], arr[j]);
        }
    }
    swap(arr[i + 1], arr[high]);
    return (i + 1);
}
</code></pre>
<h2 id="complexity-analysis">Complexity Analysis</h2>
<p><strong><strong>Time Complexity:</strong></strong></p>
<ul>
<li>
<p><strong>Best case scenario:</strong> The best case scenario occurs when the partitions are as evenly balanced as possible, i.e their sizes on either side of the pivot element are either are equal or are have size difference of 1 of each other.</p>
<ul>
<li>Case 1: The case when sizes of sublist on either side of pivot  becomes equal occurs when the subarray has an odd number of elements and the pivot is right in the middle after partitioning. Each partition will have <code>(n-1)/2</code>  elements.</li>
<li>Case 2: The size difference of 1 between the two sublists on either side of pivot happens if the subarray has an even number, <code>n</code>, of elements. One partition will have <code>n/2</code> elements with the other having <code>(n/2)-1</code>.</li>
</ul>
<p>In either of these cases, each partition will have at most <code>n/2</code> elements, and the tree representation of the subproblem sizes will be as below:<br>
<img src="https://i.pinimg.com/564x/9b/99/78/9b9978bbfb94d485d91e88b923fac989.jpg" alt="Best Case"><br>
The best case complexity of quick sort algorithm is <code>O(log n)</code></p>
</li>
<li>
<p><strong>Worst case scenario:</strong> This happens when we encounter the most unbalanced partitions possible, then the original call takes <code>n</code> time, the recursive call on <code>n-1</code> elements will take <code>(n-1)</code> time, the recursive call on <code>(n-2)</code> elements will take <code>(n-2)</code> time, and so on.  The worst case time complexity of Quick Sort would be <code>O( n &lt;sup&gt;2&lt;/sup&gt;)</code>.</p>
</li>
</ul>
<p><img src="https://i.pinimg.com/564x/49/3c/2e/493c2ea77dc9ea4ce978b485b8b46bae.jpg" alt="Quick Sort - Worst Case"></p>
<p><strong><strong>Space Complexity:</strong></strong><br>
The space complexity is calculated based on the space used in the recursion stack. The worst case space used will be <code>O(n)</code> . The average case space used will be of the order <code>O(log n)</code>. The worst case space complexity becomes <code>O(n)</code>, when the algorithm encounters its worst case where for getting a sorted list, we need to make <code>n</code> recursive calls.</p>
<h2 id="additional-information">Additional Information</h2>
<ul>
<li>
<p>The <strong>average case run time</strong> of quick sort is <code>O(n logn)</code> . This case happens when we dont exactly get evenly balanced partitions. We might get at worst a 3-to-1 split on either side of pivot element. The proof of this is quite mathematically rigorous and is out of scope of the discussion.</p>
</li>
<li>
<p>Quick sort is <strong>not a stable</strong> algorithm because the swapping of elements is done according to pivot’s position (without considering their original positions). A sorting algorithm is said to be stable if it maintains the relative order of records in the case of equality of keys.</p>
</li>
<li>
<p>Quick sort is an <strong>inplace algorithm</strong> which means the numbers are all <strong>sorted within</strong> the original array itself.</p>
</li>
<li>
<p><strong><strong>Randomised Quick Sort:</strong></strong></p>
<ul>
<li>Sometimes, it happens that by choosing the rightmost element at all times might result in the worst case scenario.</li>
<li>In such cases, choosing a random element as your pivot at each step will reduce the probability of triggering the worst case behavior. We will be more likely choosing pivots closer to the center of the array, and when this happens, the recursion branches more evenly and thus the algorithm terminates a lot faster.</li>
<li>The runtime complexity is expected to be <code>O(n log n)</code> as the selected random pivots are supposed to avoid the worst case behavior.</li>
</ul>
</li>
<li>
<p><strong><strong>Why Quick Sort is better than Merge Sort?</strong></strong></p>
<ul>
<li><strong>Auxiliary Space :</strong> Quick sort is an in-place sorting algorithm whereas Merge sort uses extra space.  In-place sorting means no additional storage space is used to perform sorting (except recursion stack). Merge sort requires a new temporary array to merge the sorted arrays thereby making Quick sort the better option.</li>
<li><strong>Worst Cases :</strong> The worst case runtime of quick sort  is <code>O(n&lt;sup&gt;2&lt;/sup&gt;)</code>  can be avoided by using randomized quicksort as explained in the previous point.  Obtaining average case behavior by choosing random pivot element improves the performance and becomes as efficient as merge sort.</li>
<li><strong>Cache Friendly:</strong> Quick Sort is also a cache friendly sorting algorithm as it has good locality of reference when used for arrays.</li>
</ul>
</li>
</ul>

