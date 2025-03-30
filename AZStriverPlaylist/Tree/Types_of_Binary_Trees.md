
# Types of Binary Trees

Binary trees are a foundational data structure in computer science, and there are several types based on specific properties and constraints. Below are the main types of binary trees:

---

## 1. Full Binary Tree
A binary tree where every node has either 0 or 2 children.

Example:
```
    1
  /   \
 2     3
/ \
4   5
```

---

## 2. Complete Binary Tree
A binary tree where all levels except possibly the last are completely filled, and all nodes in the last level are as far left as possible.

Example:
```
    1
  /   \
 2     3
/ \
4   5
```

---

## 3. Perfect Binary Tree
A binary tree where all internal nodes have 2 children, and all leaf nodes are at the same level.

Example:
```
    1
  /   \
 2     3
/ \   / \
4   5 6   7
```

---

## 4. Balanced Binary Tree
A binary tree where the height of the left and right subtrees of every node differs by at most 1.

Example:
```
    1
  /   \
 2     3
/ \
4   5
```

---

## 5. Skewed Binary Tree
A binary tree where all nodes have only one child, making the tree linear in shape.

**Left-Skewed Tree**:
```
    1
   /
  2
 /
3
```

**Right-Skewed Tree**:
```
    1
     \
      2
       \
        3
```

---

## 6. Degenerate (or Pathological) Tree
A binary tree where each parent node has only one child, similar to a linked list.

---

## 7. Binary Search Tree (BST)
A binary tree where for each node:
- All nodes in the left subtree have values less than the node.
- All nodes in the right subtree have values greater than the node.

Example:
```
    4
  /   \
 2     6
/ \   / \
1   3 5   7
```

---

## 8. AVL Tree
A self-balancing binary search tree where the difference in height between the left and right subtrees of any node is at most 1.

---

## 9. Red-Black Tree
A self-balancing binary search tree with nodes colored either red or black to maintain balance during insertions and deletions.

---

## 10. Threaded Binary Tree
A binary tree where null pointers are replaced by pointers to the in-order predecessor or successor to optimize traversal.

---

Each type serves specific use cases and provides different trade-offs in terms of time complexity for operations like search, insert, and delete.
