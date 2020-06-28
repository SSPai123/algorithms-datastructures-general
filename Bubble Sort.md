---


---

<h1 id="bubble-sort">Bubble Sort</h1>
<h2 id="introduction">Introduction</h2>
<ul>
<li><strong>Bubble sort</strong>, also referred to as <strong>comparison sort</strong>, is a simple sorting algorithm that repeatedly goes through the list, compares adjacent elements and swaps them if they are in the wrong order.</li>
<li>This is the most simplest algorithm and inefficient at the same time. Yet, it is very much necessary to learn about it as it represents the basic foundations of sorting.</li>
</ul>
<h2 id="applications">Applications</h2>
<ul>
<li>Bubble sort is mainly used in educational purposes for helping students understand the foundations of sorting.</li>
<li>Due to the nature of algorithm working by repeatedly stepping through the list and comparing the elements, bubble sort is not used in industrial and real life applications as it becomes very slow and ineffective.</li>
<li>The only significant advantage of bubble sort over other effecient implementations of sorting is its built-in  ability to detect whether the list is sorted efficiently. When the list is already sorted (which is the best-case scenario), the complexity of bubble sort is only <code>O(n)</code>.</li>
<li>Bubble sort is avoided in cases of large collections. It can be used only when the collections are very small (which doesn’t happen in real world scenarios).</li>
</ul>
<h2 id="explanation">Explanation</h2>
<p><strong>Algorithm</strong>: We compare adjacent elements and see if their order is wrong (i.e <code>a[i] &gt; a[j] for 1 &lt;= i &lt; j &lt;= size of array</code>; if array is to be in ascending order, and vice-versa). If yes, then swap them.<br>
<strong>Explanation</strong>:</p>
<ul>
<li>Let us say, we have an array of length <code>n</code>. To sort this array we do the above step (swapping) for <code>n - 1</code> passes.</li>
<li>In simple terms, in the ith pass, the ith largest element goes at its right place in the array by swappings. First, the largest element goes at its extreme right place then, second largest to the last by one place, and so on.</li>
<li>In mathematical terms, in <code>ith</code> pass, at least one element from <code>(n - i + 1)</code> elements from start will go at its right place. That element will be the ith <code>(for 1 &lt;= i &lt;= n - 1)</code> largest element of the array. Because in the <code>ith</code> pass of the array, in the <code>jth</code> iteration <code>(for 1 &lt;= j &lt;= n - i)</code>, we are checking <code>if a[j] &gt; a[j + 1]</code>, and <code>a[j]</code> will always be greater than <code>a[j + 1]</code> when it is the largest element in range <code>[1, n - i + 1]</code>. Now we will swap it. This will continue until <code>ith</code> largest element is at the <code>(n - i + 1)</code>th position of the array.</li>
</ul>
<h2 id="example">Example</h2>
<h3 id="problem-statement">Problem Statement</h3>
<p>Consider the following array: Arr=<code>14, 33, 27, 35, 10</code>. We need to sort this array using bubble sort algorithm.</p>
<p><img src="https://tutorials-image.s3-us-west-2.amazonaws.com/unsorrted+array.png" alt="Initial array"></p>
<h3 id="solution">Solution</h3>
<p><strong>First Pass</strong>:</p>
<ul>
<li>
<p>We proceed with the first and second element i.e., Arr[0] and Arr[1]. Check if <code>14 &gt; 33</code> which is false. So, <strong>no swapping</strong> happens and the array remains the same.<br>
<img src="https://tutorials-image.s3-us-west-2.amazonaws.com/unsorrted+array.png" alt=""></p>
</li>
<li>
<p>We proceed with the second and third element i.e., Arr[1] and Arr[2]. Check if <code>33 &gt; 27</code> which is true. So, we swap Arr[1] and Arr[2].<br>
<img src="https://tutorials-image.s3-us-west-2.amazonaws.com/bubble+sort.png" alt=""><br>
Thus the array becomes:<br>
<img src="https://tutorials-image.s3-us-west-2.amazonaws.com/bubble+sort+1.png" alt=""></p>
</li>
<li>
<p>We proceed with the third and fourth element i.e., Arr[2] and Arr[3]. Check if <code>33 &gt; 35</code> which is false. So, no swapping happens and the array remains the same.<br>
<img src="https://tutorials-image.s3-us-west-2.amazonaws.com/bubble+sort+1.png" alt=""></p>
</li>
<li>
<p>We proceed with the fourth and fifth element i.e., Arr[3] and Arr[4]. Check if <code>35 &gt; 10</code> which is true. So, we swap Arr[3] and Arr[4].<br>
<img src="https://tutorials-image.s3-us-west-2.amazonaws.com/bubble+sort+3.png" alt=""><br>
Thus, after swapping the array becomes:<br>
<img src="https://tutorials-image.s3-us-west-2.amazonaws.com/bubble+sort+4.png" alt=""></p>
</li>
</ul>
<p>Thus, marks the end of the first pass, where the <strong>Largest element reaches its final(last) position.</strong></p>
<p><strong>Second Pass</strong>:</p>
<ul>
<li>
<p>We proceed with the first and second element i.e., Arr[0] and Arr[1]. Check if <code>14 &gt; 27</code> which is false. So, no swapping happens and the array remains the same.<br>
<img src="https://tutorials-image.s3-us-west-2.amazonaws.com/bubble+sort+4.png" alt="">We now proceed with the second and third element i.e., Arr[1] and Arr[2]. Check if 27 &gt; 33 which is false. So, no swapping happens and the <strong>array remains the same.</strong></p>
</li>
<li>
<p>We now proceed with the third and fourth element i.e., Arr[2] and Arr[3]. Check if <code>33 &gt; 10</code> which is true. So, we swap Arr[2] and Arr[3].<br>
<img src="https://tutorials-image.s3-us-west-2.amazonaws.com/bubble+sort+5.png" alt=""><br>
Now, the array becomes<br>
<img src="https://tutorials-image.s3-us-west-2.amazonaws.com/bubble+sort+6.png" alt=""></p>
</li>
</ul>
<p>Thus marks the  end of second pass where the <strong>second largest element in the array has occupied its correct position.</strong></p>
<p><strong>Third Pass:</strong><br>
After the third pass, the <strong>third largest element will be at the third last position</strong> in the array.<br>
<img src="https://i.pinimg.com/564x/9f/e7/0c/9fe70c83b7617d894550fac611f7f85a.jpg" alt="enter image description here"><br>
.</p>
<p>.</p>
<p><strong>i-th Pass:</strong><br>
After the ith pass, the <strong>ith largest element will be at the ith last position</strong> in the array.</p>
<p>.</p>
<p>.<br>
<strong>n-th Pass:</strong><br>
After the nth pass, <strong>the nth largest element(smallest element) will be at nth last position(1st position)</strong> in the array, where ‘n’ is the size of the array.</p>
<p><strong>After doing all the passes, we can easily see the array will be sorted.</strong><br>
Thus, the sorted array will look like this:</p>
<p><img src="https://tutorials-image.s3-us-west-2.amazonaws.com/final+sorted+array+using+bubble+sort.png" alt=""></p>
<h2 id="pseudo-code">Pseudo Code</h2>
<pre><code>
/**
* The main function that implements bubble sort.
* @Parameters: array, total elements
*/
bubbleSort( Arr[], total_elements){
   
   for(i = 0; i<total_elements - 1;i++){
	   // flag to check if array is already sorted
      swapped = false;	
		
      for(j = 0; j<total_elements - i - 2; j++){ 
         // compare the adjacent elements  
         if (Arr[j] > Arr[j+1]){
            // swap them
            swap(Arr[j], Arr[j+1]);	 
            swapped = true;	// any swap done, will signify array isnt sorted.
         }
      }
      
      /** if no number was swapped that 
      * means array is sorted now, 
      * break the loop.
      * */
      
      if(swapped == false){
         break;
      }
      
   }
   
}
</code></pre>
<h2 id="complexity-analysis">Complexity Analysis</h2>
<p><strong><strong>Time Complexity:</strong></strong></p>
<ul>
<li><strong>Best case scenario:</strong> The best case scenario occurs when the array is already sorted. In this case, no swapping will happen in the first iteration (The <code>swapped</code> variable will be false). So, when this happens, we break from the loop after the very first iteration. Hence, time complexity in the best case scenario is  <code>O(n)</code> because it has to traverse through all the elements once.</li>
<li><strong>Worst case and Average case scenario:</strong> In Bubble Sort, <code>n-1</code> comparisons are done in the 1st pass, <code>n-2</code> in 2nd pass, <code>n-3</code> in 3rd pass and so on. So, the total number of comparisons will be:<pre><code>Sum = (n-1) + (n-2) + (n-3) + ..... + 3 + 2 + 1 
Sum = n(n-1)/2
</code></pre>
Hence, the time complexity is of the order <strong>n<sup>2</sup></strong> or <strong>O(n<sup>2</sup>)</strong>.</li>
</ul>
<p><strong><strong>Space Complexity:</strong></strong><br>
The space complexity for the algorithm  is <strong>O(1)</strong>, because only a single additional memory space is required i.e. for temporary variable used for swapping.</p>
<h2 id="faqs">FAQs</h2>
<ul>
<li>
<p><strong>What is the best case time complexity of bubble sort?</strong><br>
The time complexity in the best case scenario is  <code>O(n)</code> because it has to traverse through all the elements once to recognize that the array is already sorted.</p>
</li>
<li>
<p><strong>What is the advantage of bubble sort over other sorting techniques?</strong></p>
<ul>
<li>The built-in  ability to detect whether the list is sorted efficiently is the only advantage of bubble sort over other sorting techniques.</li>
<li>When the list is already sorted (which is the best-case scenario), the complexity of bubble sort is only <code>O(n)</code>.</li>
<li>It is faster than other in case of sorted array and consumes less time to describe whether the input array is <strong>sorted</strong> or not.</li>
</ul>
</li>
<li>
<p><strong>Why bubble sort is called “bubble” sort?</strong><br>
The “bubble” sort is called so because the list elements with greater value than their surrounding elements “bubble” towards the end of the list. For example, after first pass, the largest element is bubbled towards the right most position. After second pass, the second largest element is bubbled towards the second last position in the list and so on.</p>
</li>
<li>
<p><strong>Is bubble sort a stable algorithm?</strong></p>
<ul>
<li>Bubble sort is a stable algorithm.</li>
<li>A sorting algorithm is said to be <strong>stable</strong> if two objects with <strong>equal keys</strong> appear in the same order in <strong>sorted</strong> output as they appear in the input array to be <strong>sorted</strong>.</li>
</ul>
</li>
<li>
<p><strong>Is bubble sort an inplace algorithm?</strong></p>
<ul>
<li>Bubble sort is an inplace algorithm.</li>
<li>An algorithm is said to be inplace if it does not need an extra space and produces an output in the same memory that contains the data by transforming the input ‘in-place’. However, a small constant extra space used for variables is allowed.</li>
</ul>
</li>
<li>
<p><strong>Is Bubble sort slow?</strong></p>
<ul>
<li>Bubble sort is slower than the other <strong>O(n<sup>2</sup>)</strong> sorting algorithms.</li>
<li>It is about four times as slow as insertion sort and twice as slow as selection sort.</li>
<li>It has a good best-case behavior, but is impractically slow on almost all real world data sets and is not considered for implementation in real applications.</li>
</ul>
</li>
<li>
<p><strong>Can bubble sort be implemented recursively?</strong></p>
<ul>
<li><strong>Yes.</strong></li>
<li>Recursive Bubble Sort has no  additional performance/implementation advantages, but can be used to understand recursion and sorting concepts better.</li>
<li>Base Case: If array size is 1, return.</li>
<li>Do One Pass of normal Bubble Sort. This pass bubbles largest element of current subarray to correct position.</li>
<li>Recur for all elements except last of current subarray.</li>
</ul>
</li>
</ul>
<pre><code>    
recursiveBubbleSort(arr[], n){
	// Base case
	if (n == 1)
	return;

	// One pass of bubble sort. After
	// this pass, the largest element
	// is moved (or bubbled) to end.
	for(i=0; i<n-1; i++){
		if(arr[i] > arr[i+1])
		{
		 swap(arr[i], arr[i+1]);
		}
	}

	// recursion for remaining elements in array
	recursiveBubbleSort(arr, n-1);
    }
</code></pre>

