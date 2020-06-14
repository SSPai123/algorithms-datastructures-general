---


---

<h1 id="dijkstras-algorithm">Dijkstra’s algorithm</h1>
<h2 id="introduction">Introduction</h2>
<p>The algorithm was developed by a Dutch computer scientist Edsger W. Dijkstra in 1956. It is used to find the <strong>shortest path</strong> between a node/vertex (source node) to any (or every) other nodes/vertices (destination nodes) in a graph. A graph is basically an interconnection of nodes connected by edges.</p>
<p>This algorithm is sometimes referred to as <strong>Single Source Shortest Path Algorithm</strong> due to its nature of implementation.</p>
<h2 id="applications">Applications</h2>
<p>Before diving into any algorithm, its very much necessary for us to understand what are the real world applications of it.</p>
<p>Majority of the problems that we encounter in real life scenarios deals with finding solutions to shortest path based problems.</p>
<p>To explain in simple words, you want to travel from city A to city B. Both cities are connected by multiple routes. What route do we generally prefer? There is no doubt that we would opt for the route which can make us reach our destination with minimum possible cost and time! Isn’t this relatable?</p>
<p>Following are the main applications of Dijkstra’s Algorithm:</p>
<ol>
<li>It is most widely used in finding shortest possible distance and show directions between 2 geographical locations such as in Google Maps.</li>
<li>This is also widely used in routing of data in networking and telecommunication domains for minimizing the delay occurred for transmission.</li>
<li>Wherever you encounter the need for shortest path solutions be it in robotics, transportation, embedded systems, factory or production plants to detect faults, etc this algorithm is used.</li>
</ol>
<h2 id="explanation">Explanation</h2>
<p>In order to find the shortest path, Dijkstra’s algorithm mainly allocates a “cost” value taken to reach the destination vertex from the source vertex. The “cost” can be mapped to disance, money or time taken to reach from source to a destination.</p>
<p><img src="https://i.pinimg.com/564x/e4/ca/08/e4ca08cf6373a35539a0136a739a46f0.jpg" alt="Sample Graph"></p>
<p>Below are the steps to be followed for solving using Dijkstra’s algorithm:</p>
<ol>
<li>Convert any problem to its graph equivalent representation.</li>
<li>Maintain a list of unvisited vertices. Assign a vertex as “source” and also allocate a maximum possible cost (infinity) to every other vertex. The cost of the source to itself will be zero as it actually takes nothing to go to itself.</li>
<li>In every step of the algorithm, it tries to minimize the cost for each vertex.</li>
<li>For every unvisited neighbor (V2, V3) of the current vertex (V1) calculate the new cost from V1.</li>
<li>The new cost of V2 is calculated as :</li>
</ol>
<pre><code>Minimum( existing cost of V2 , (sum of cost of V1 + the cost of edge from V1 to V2) )
</code></pre>
<ol start="7">
<li>When all the neighbors of the current node are visited and cost has been calculated, marks the current node V1 as visited and remove it from the unvisited list.</li>
<li>Select next vertex with smallest cost from the unvisited list and repeat from step 4.</li>
<li>The algorithm finally ends when there are no unvisited nodes left.</li>
</ol>
<h2 id="step-wise-explanation-with-example">Step wise explanation with example</h2>
<h3 id="problem-statement">Problem Statement</h3>
<p>Consider the map below. The cities have been selected and marked from alphabets A to F and every edge has a cost associated with it.<br>
We need to travel from <strong>Bengaluru</strong> to all other places and we have to identify what are the shortest paths with minimal cost from Bengaluru to other destinations.<br>
<img src="https://i.pinimg.com/564x/07/9d/4d/079d4dfd9c56a33506034cab569487b7.jpg" alt="Map"></p>
<h3 id="solution">Solution</h3>
<h4 id="convert-problem-to-its-graph-equivalent.">1. Convert problem to its graph equivalent.</h4>
<p>Upon conversion, we get the below representation. Note that the graph is weighted and undirected. All the cities have been replaced by the alphabets associated with it and the edges have the cost value (to go from one node to other) displayed on it.<br>
<img src="https://i.pinimg.com/564x/76/c0/62/76c062674c030484e573f5551dfec3f9.jpg" alt="Graph"></p>
<h4 id="assign-cost-to-vertices.">2. Assign cost to vertices.</h4>
<p>Assign cost of 0 to source vertex and <span class="katex--inline"><span class="katex"><span class="katex-mathml"><math><semantics><mrow><mi mathvariant="normal">∞</mi></mrow></span></span> (Infinity) to all other vertices as shown in the image below.<br>
Maintain a list of unvisited vertices. Add all the vertices to the <code>unvisted</code> list.<br>
<img src="https://i.pinimg.com/564x/e6/ed/a2/e6eda290895cce2ad2c7974b814d1b3c.jpg" alt="CostAssign"></p>
<h4 id="calculate-minimum-cost-for-neighbors-of-selected-source.">3. Calculate minimum cost for neighbors of selected source.</h4>
<p>For each neighbor A, C and D of source vertex selected (B), calculate the cost associated to reach them from B using the formula. Once this is done, mark the source vertex as visited (The vertex has been changed to blue to indicate visited).</p>
<pre><code>Minimum(current cost of neighbor vertex, cost(B)+edge_value(neighbor,B))
</code></pre>
<ol>
<li>For neighbor A: cost = Minimum(<span class="katex--inline"><span class="katex"><span class="katex-mathml"><math><semantics><mrow><mi mathvariant="normal">∞</mi></mrow></span></span> , 0+3) = 3</li>
<li>For neighbor C: cost = Minimum(<span class="katex--inline"><span class="katex"><span class="katex-mathml"><math><semantics><mrow><mi mathvariant="normal">∞</mi></mrow></span></span> , 0+1) = 1</li>
<li>For neighbor D: cost = Minimum(<span class="katex--inline"><span class="katex"><span class="katex-mathml"><math><semantics><mrow><mi mathvariant="normal">∞</mi></mrow></span></span> , 0+6) = 6<br>
<img src="https://i.pinimg.com/564x/00/70/8d/00708d62c3278c216147f65d53ca8887.jpg" alt="cost of neighbors"></li>
</ol>
<h4 id="select-next-vertex-with-smallest-cost-from-the-unvisited-list.">4. Select next vertex with smallest cost from the unvisited list.</h4>
<p>Choose the unvisited vertex with minimum cost (here, it would be C) and consider all its unvisited neighbors (A,E and D) and calculate the minimum cost for them.</p>
<p>Once this is done, mark C as visited.</p>
<pre><code>Minimum(current cost of neighbor vertex, cost(C)+edge_value(neighbor,C))
</code></pre>
<ol>
<li>For neighbor A: cost = Minimum(3 , 1+2) = 3</li>
<li>For neighbor E: cost = Minimum(<span class="katex--inline"><span class="katex"><span class="katex-mathml"><math><semantics><mrow><mi mathvariant="normal">∞</mi></mrow></span></span></span>, 1+4) = 5</li>
<li>For neighbor D: cost = Minimum(6 , 1+4) = 5</li>
</ol>
<p>Observe that the cost value of node D is updated by the new minimum cost calculated.<br>
<img src="https://i.pinimg.com/564x/e9/99/c5/e999c57b17c20f4cbe23e6444d33794f.jpg" alt="Cost to neighbors of C"></p>
<h4 id="repeat-step-4-for-all-the-remaining-unvisited-nodes.">5. Repeat step 4 for all the remaining unvisited nodes.</h4>
<p>Repeat step 4 until there are no unvisited nodes left. At the end of the execution, we will know the shortest paths from the source vertex B to all the other vertices. The final state of the graph would be like below.<br>
<img src="https://i.pinimg.com/564x/1a/12/da/1a12da729fb20bccd46d44b523ac3455.jpg" alt="Final State"></p>
<h2 id="pseudo-code">Pseudo Code</h2>
<pre><code>Dijkstra_Algorithm(source, G):
    """
    parameters: source node--&gt; source, graph--&gt; G
    return: List of cost from source to all other nodes--&gt; cost
    """
    unvisited_list = []			// List of unvisited verticesvertices
    cost = []
    cost[source] = 0              // Distance (cost) from source to source will be 0
    for each vertex v in G:       // Assign cost as INFINITY to all vertices
       if v ≠ source
             cost[v] = INFINITY
             add v to unvisited_list    // All nodes pushed to unvisited_list initially

    while unvisited_list is not empty:        	     // Main loop
       v = vertex in unvisited_list with min cost[v]      // v is the source node for first iteration
       remove v from unvisited_list		            // Marking node as visited 

       for each neighbor u of v:			// Assign shorter path cost to neigbour u
          cost_value = Min( cost[u], cost[v] + edge_cost(v, u)]
          cost[u] = cost_value            		// Update cost of vertex u 

    return cost
</code></pre>
<h2 id="complexity-analysis">Complexity Analysis</h2>
<p>Consider there are V number of vertices in a graph. Then by definition, there would be |V-1| number of edges.</p>
<ol>
<li>The main outer loop runs for |V| times</li>
<li>The inner loop meant where actual cost calculation happens, runs for |V-1| times for a complete graph as each vertex has |V-1| edges.</li>
<li>Also, for each iteration of the inner loop we do an extractMin and a decreaseKey operation for the vertex.</li>
</ol>
<p>Hence the total running time will have an upper bound of O(|V| * |V-1|) which is equivalent to O(|V|<sup>2</sup>)</p>
<h4 id="note">Note</h4>
<ol>
<li>We can further reduce the time complexity of this algorithm by using Binary Heap as data structure for Priority Queue implementation instead of list.</li>
<li>The priority queue implementation is for efficiently finding the node with minimum cost and then updating the cost value associated with the node.</li>
<li>With this, the time complexity will be <code>O((E+V)*LogV) = O(ELogV)</code> where E is the number of edges and V is the number of vertices in a graph</li>
</ol>
<h2 id="additional-information">Additional Information</h2>
<ol>
<li>The example demo was done for undirected graph. However, Dijkstra’s Algorithm can also be used for directed graphs as well.</li>
<li>The pseudo code finds the shortest path from source to all other nodes in the graph. If we want it to be from a source to a specific destination, we can break the loop when the target is reached and minimum value is calculated.</li>
<li>The shortest path might not pass through all the vertices. Also, there can be more than one shortest path between two nodes.</li>
<li>Dijkstra’s Algorithm doesnt work for graphs with negative edges. Algorithms like Bellman-Ford Algorithm will be used for such cases.</li>
</ol>

