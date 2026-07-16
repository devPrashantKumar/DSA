# Eventual Safe Nodes (LeetCode 802)

# Intuition

A **terminal node** is always a **safe node** because it has no outgoing
edges.

Now imagine we remove all terminal nodes from the graph. Once they are
removed, some other nodes may no longer have any outgoing edges. Those
nodes also become **terminal**, and therefore **safe**.

We can repeat this process until no more nodes become terminal.

This is exactly what the algorithm does: - Start from all terminal
nodes. - Remove them logically. - Whenever removing a safe node causes
another node to have **outdegree = 0**, that node also becomes safe.

Since we need to efficiently find **which nodes point to the current
safe node**, we reverse the graph.

------------------------------------------------------------------------

# Why Reverse the Graph?

Original graph:

``` text
0 → 1 → 2
```

-   `2` is a terminal node.
-   `2` is safe.
-   After removing `2`, node `1` becomes terminal and safe.
-   After removing `1`, node `0` becomes terminal and safe.

Reversed graph:

``` text
0 ← 1 ← 2
```

Now when `2` becomes safe, we can directly visit its predecessor (`1`)
and decrease its outdegree.

------------------------------------------------------------------------

# Algorithm

1.  Compute the **outdegree** of every node.
2.  Reverse every edge.
3.  Push every node with `outdegree = 0` into a queue.
4.  Perform BFS:
    -   Remove one safe node.
    -   Decrease the outdegree of all its predecessors.
    -   If any predecessor's outdegree becomes `0`, add it to the queue.
5.  The processed nodes are the eventual safe nodes.

------------------------------------------------------------------------

# Important Note

Although the variable is often named `indegree`, it is actually storing
the **original outdegree** of each node.

-   **Terminal node** ⇒ `outdegree = 0`
-   When a node's outdegree becomes `0`, it also becomes safe.

------------------------------------------------------------------------

# Time Complexity

-   Building reverse graph: **O(V + E)**
-   BFS (Kahn's Algorithm): **O(V + E)**
-   Sorting answer: **O(V log V)**

Overall:

``` text
O(V + E + V log V)
```