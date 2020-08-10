# Depth First Search

## Introduction
-  Depth First Search (commonly called as **DFS**) was first studied in the 19th century by French mathematician Charles Pierre Trémaux as a strategy for solving mazes.
-  It is one of the most commonly preferred algorithms used for traversing or search in tree or graph data structures by using the idea of backtracking.
    -  DFS is also known as Depth First Traversal in case we are using the algorithm in tree data structures. 
    -  **Note:** A tree is a special kind of graph with no cycles.
-  The algorithm starts at a node of a graph and goes as far as possible in a given path, then backtracks until it finds an unexplored path, and then explores the rest of it. The process is repeatedly followed until all the nodes in the graph are explored. 

## Applications
Most of the concepts in computer science can be visualized and represented in terms of graph data structure. DFS is one such  useful algorithm for analysing these problems easily.
- Solving maze-like puzzles with only one solution: DFS can be used to find all solutions to a maze problem by only considering nodes on the current path in the visited set.
- Topological Sorting: 
    - This is mainly used for scheduling jobs from the given dependencies among jobs. DFS is highly preferred approach while finding solutions to the following type of problems using Topological Sort: 
        - instruction/job scheduling 
        - ordering of formula cell evaluation when recomputing formula values in spreadsheets
        - determining the order of compilation tasks to perform in makefiles
        - data serialization
        - resolving symbol dependencies in linkers
- Mapping Routes and Network Analysis
- Path Finding: DFS is used for finding path between two given nodes - source and destination - in a graph.
- Cycle detection in graphs

## Algorithm
* The DFS algorithm is the search algorithm which begins the searching from the root node and goes down till the leaf of a branch at a time looking for a particular key. If the key is not found, the searching retraces its steps back to the point from where the other branch was left unexplored and the same procedure is repeated for that branch. 
* DFS follows the following 3 steps:
    1. Visit a node "S".
    2. Mark "S" as visited.
    3. Recursively visit every unvisited node attached to "S".
* Since DFS is of **recursive** nature, this can be implemented using **stacks**. (Refer the FAQ section to understand why we use stacks)
* **Implementation**:
    1. Push the source node to the stack.
    2. Maintain a data structure to mark if a node is visited or not, say, <br/>
        ```
        boolean[] visited = new boolean[total_nodes_in_graph]

        //Default value will be false for all the elements 
        ```
    3. Mark source node S as visited: `visited[S] = True`
    4. While stack is not empty repeat steps 5 - 8 below
    5. Pop node, say, A from the stack
    6. If `visited[A]` is True go to step 5, else go to step 7.
    7. Mark `visited[A] = True`.
    8. Check if A is the node that we need. If yes, break dfs. Else, push all the adjacent nodes of A which are not visited into the stack.
- In this way, we will traverse a path until it is exhausted. Meaning, either there are no adjacent nodes or all the adjacent nodes are already visited.

**Note:** 
- The "adjacent nodes" mean the "neighbors" of the selected node.
- If the nodes are not marked as visited, then we might visit the same node more than once and we will possibly end up in an infinite loop.

## Example 

Consider the following graph structure where S is the Source node to begin DFS with:

![Initial Graph](https://i.pinimg.com/564x/d1/e8/3e/d1e83e9f2c86850ec835100be7761b7e.jpg)

**The goal here is to find whether the node E is present in the graph.** Just by seeing the graph, we can say that node E is not present. Lets see how DFS works to identify this.

***Step 1:*** We push S to the STACK

***Step 2:*** Mark S as Visited.

![S Visited and on Stack](https://i.pinimg.com/564x/a2/38/10/a23810ccddad97ea039bd9ada586bd33.jpg)

***Step 3:*** While the stack is not empty, repeat the below steps:

- Pop the top element i.e., node S out of STACK ==>
`STACK = [ ]`
- Is the popped element equal to the node element we were looking for? If yes, return true. Here `S != E`. Hence, continue with the below steps.
- Push all the adjacent nodes of S which are not visited yet into STACK.
- We push nodes C, B, and A into STACK.
`STACK = [C, B, A]`

![C,B,A in stack](https://i.pinimg.com/564x/04/d8/74/04d8746800e5fff76a035effb9750cd0.jpg)

- Pop the top element i.e., node A out of STACK. 
    - Is the popped element equal to the node element we were looking for? If yes, return true. `Here A != E`. Hence, we proceed with the below steps.
- Mark A as visited. Stack now becomes `STACK = [C, B]`
![A popped and visited](https://i.pinimg.com/564x/25/5a/0b/255a0b42327f236d8951eaa3153f84d2.jpg)
- Push all the adjacent nodes of A which are not visited yet into STACK.
    - We push node D into STACK and stack now has`STACK = [C, B, D]`
![D pushed](https://i.pinimg.com/564x/6b/5c/03/6b5c0397377b90a8c7f804662562b325.jpg)


- Pop the top element i.e., node D out of STACK. Mark D as visited. After popping D, stack is now: `STACK = [C, B]`
    - Is the popped element equal to the node element we were looking for? If yes, return true. `Here A != E`. Hence, we proceed with the below steps.
![D popped](https://i.pinimg.com/564x/19/e0/52/19e05248965b3f60b3a70940822c2a02.jpg)

- Push all the adjacent nodes of D which are not visited yet into STACK.
    - We push nodes C and B into STACK. `STACK = [C, B, C, B]`
![D neighbours pushed](https://i.pinimg.com/originals/27/79/19/2779190f470e505b1e68555736274b93.png)



- Pop the top element i.e., node B out of STACK.
    - Is the popped element equal to the node element we were looking for? If yes, return true. `Here B != E`. Hence proceed with the below steps. 
- Mark B as visited. `STACK = [C, B, C]`

![B popped](https://i.pinimg.com/564x/38/6c/6c/386c6c568357a07797a4eba789a322f2.jpg)


- Push all the adjacent nodes of B which are not visited yet into STACK.

    - There are no adjacent nodes of B which are not visited. So stack will still be `STACK = [C, B, C]`

- Pop the top element i.e., node C out of STACK. 
    - Is the popped element equal to the node element we were looking for? If yes, return true. `Here C != E`. Hence proceed with the below steps.
- Mark C as visited. Stack becomes `STACK = [C, B]`
![C popped](https://i.pinimg.com/564x/77/07/9f/77079fac8771095f1e5b73fe9542323e.jpg)

- Push all the adjacent nodes of C which are not visited yet into STACK.
    - There are no adjacent nodes of C which are not visited. Hence stack will remain: `STACK = [C, B]`

- Now, we pop B from STACK and see that it was visited earlier. After popping B, stack is `STACK = [C]`

![B popped](https://i.pinimg.com/564x/b9/8a/bc/b98abc710c21a0200f2fc6a3e09feb7d.jpg)

- We continue with the next iteration and pop C from STACK and see that it was visited earlier. Stack now become s empty: `STACK = [ ]`

![C Popped](https://i.pinimg.com/564x/d9/1d/ec/d91dec272ab12678e75367650346a9f3.jpg)
- STACK is now empty and hence we stop dfs as all the nodes have been visited and we havent found any nodes matching to node E. Hence we return false.

This is how a depth-first search works, by traversing the nodes depth-wise. We stop DFS and return `true` when we find the required node (key). We return `false` when we have not found the key despite of exploring all the nodes.

## Pseudo Code

### Recursive DFS
```
/**
* Pseudo code for recursive DFS
* @Parameters: adjacent list G, source node, 
* visited array, key (node to be searched)
*/

DFS(adjacent[][], source, visited[], key) {
   if(source == key) return true //We found the key
   visited[source] = True
   
   FOR node in adjacent[source]:
       IF visited[node] == False:
          DFS(adjacent, node, visited)
       END IF
   END FOR
   return false    // If it reaches here, then all nodes have been explored 
                  //and we still havent found the key.
}
```
### Iterative DFS
```
/**
* Pseudo code for iterative DFS
* @Parameters: Graph G, source node s, key
*/

DFS(G, s, key):
      stack = new Stack()
      stack.push( s )            //Push s to stack 
      mark s as visited
      while ( stack is not empty):
            //Pop node from stack and start to visit its children
            v  =  stack.pop()
            
            if(v == key) return true //We found the key
            
            //Push all the unvisited neighbours of v to stack 
            for all neighbours w of v in Graph G:
                //unvisited neighbors
                if w is not visited :   
                     stack.push( w )         
                     mark w as visited
      return false     // If it reaches here, then all nodes have been explored 
                      //and we still havent found the key.
```
## Complexity Analysis
****Time Complexity:****
- The time complexity of DFS if the entire **tree** is traversed is **O(V)** where V is the number of nodes. 
- If the graph is represented as **adjacency list**:
    - Here, each node maintains a list of all its adjacent edges. Let's assume that there are V number of nodes and E number of edges in the graph.
    - For each node, we discover all its neighbors by traversing its adjacency list just once in linear time. 
    - For a directed graph, the sum of the sizes of the adjacency lists of all the nodes is E. So, the time complexity in this case is **O(V) + O(E) = O(V + E)**.
    - For an undirected graph, each edge appears twice. Once in the adjacency list of either end of the edge. The time complexity for this case will be **O(V) + O (2E) ~ O(V + E)**.
- If the graph is represented as an **adjacency matrix** (a V x V array):
    -  For each node, we will have to traverse an entire row of length V in the matrix to discover all its outgoing edges. 
    - Note that each row in an adjacency matrix corresponds to a node in the graph, and that row stores information about edges emerging from the node. Hence, the time complexity of DFS in this case is **O(V * V) = O(V<sup>2</sup>)**.
- The time complexity of DFS actually depends on the data structure being used to represent the graph.
 
 
****Space Complexity:****
- Since we are maintaining a stack to keep track of the last visited node, in worst case, the stack could take upto the size of the nodes(or vertices) in the graph. Hence, the space complexity is **O(V)**.


## FAQs
 - **Why can we not implement DFS using Queues? Why do we prefer stacks instead of other data structures?**
     - In DFS, we always want to find the last node we visited to go in the other unvisited branches of that node in the most efficient way possible.
     - If we are using queue (**First in First out**) data structure:
         - To retrieve the last node visited, first, we will have to take all the elements out of the queue. 
         - We will also need to store these elements except the last one so that we can push them back in the queue. 
         - The last element taken out of the queue will be the last visited node. 
         - We now have to push all the elements taken out back to queue.
     - The way queue works will give us the last visited node in **O(n)** operations as that will be the last element inserted in the queue. 
     - Stacks on the other hand, work in **"Last In First Out"** fashion. It will give the last node visited in **O(1)** operations as that node will be the top element of the stack and we only have to pop it. Hence, we go for stacks.
 
 - **What are the classifications of edges in DFS of a graph?**
     - We have **4 kinds** of edges in DFS of a graph. 
     - Consider a directed graph as shown in the diagram below, DFS of the below graph is `1 2 4 3 5 6`. If DFS is applied on this graph, a tree is obtained which is represented and connected by means of using green edges. The types of edges are as follows:
![DFS Edges](https://i.pinimg.com/564x/a3/45/1d/a3451d36bd21095c3e79f78009cd5964.jpg)
         - **Tree Edge**: The edge which is present in the tree obtained **after applying** DFS on the graph. All the Green edges are tree edges.
         - **Forward Edge**: `Edge (u, v)` such that v is **descendant** but not part of the DFS tree. Edge from node 1 to node 6 is a forward edge.
         - **Back edge**: 
             - `Edge (u, v)` such that `v` is **ancestor** of edge u but not part of DFS tree. Edge from node 4 to node 1 is a back edge. 
             - Presence of back edge indicates a cycle in the directed graph.
         - **Cross Edge**: It is a edge which **connects two nodes** such that they do not have any ancestor and a descendant relationship between them. Edge from node 3 to node 2 is a cross edge.
 - **Can DFS be used for finding shortest possible path?**
     - **No**.
 
 - **Why can we not use DFS for finding shortest possible path?**
     - In the implementation of DFS, there is no deterministic rule on what order the next children/neighbor to be explored is considered. 
     - DFS does not guarantee that if node 1 is visited before another node 2 starting from a source vertex. It can not identify what node is closer to the source node.
     - DFS just visits the 'deeper' nodes in any order. It can even be farther from source nodes. In the worst case, it might go as far as possible from the source node and then returns to unvisited adjacent nodes of visited nodes.
     - Due to this, DFS is not a reliable choice to find the shortest path between the nodes.
 - **Is DFS a complete algorithm?**
     - A search algorithm is said to be complete if at least one solution exists then the algorithm is guaranteed to find a solution in a finite amount of time.
     -  DFS is complete if the search tree is finite, meaning for a given finite search tree, DFS will come up with a solution if it exists.
 - **Is DFS a optimal algorithm?**
     -  A search algorithm is optimal if it finds a solution, it finds that in the best possible manner.
     -  DFS is **not** optimal, meaning the number of steps in reaching the solution, or the cost spent in reaching it is high.
 -  **When is it best to use DFS?**
     -  The usage of DFS heavily depends on the structure of the search tree/graph and the number and location of solutions needed.
         -  If it is known that the solution is not far from the root of the tree, a breadth first search (BFS) might be better.
         -  If the tree is very deep and solutions are rare, depth first search (DFS) might take an extremely long time, but BFS could be faster.
         -  If the tree is very wide, a BFS might need too much memory, so it might be completely impractical. We go for DFS in such cases.
         -  If solutions are frequent but located deep in the tree we opt for DFS.
