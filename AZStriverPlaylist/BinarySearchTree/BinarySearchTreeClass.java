package AZStriverPlaylist.BinarySearchTree;

import java.util.Stack;

public class BinarySearchTreeClass {
	class BinarySearchTreeNode {
		int data;
		BinarySearchTreeNode left;
		BinarySearchTreeNode right;

		public BinarySearchTreeNode(int data) {
			this.data = data;
		}
	}

	private BinarySearchTreeNode root;

	public BinarySearchTreeClass() {
		this.root = null;
	}

	public void insertBinarySearchTreeNode(int data) {
		this.root = insertBinarySearchTreeNodeUtil(this.root, data);
	}

	public BinarySearchTreeNode insertBinarySearchTreeNodeUtil(BinarySearchTreeNode node, int data) {
		if (node == null) {
			return new BinarySearchTreeNode(data);
		}
		if (data < node.data) {
			node.left = insertBinarySearchTreeNodeUtil(node.left, data);
		} else {
			node.right = insertBinarySearchTreeNodeUtil(node.right, data);
		}
		return node;
	}

	public void insertBinarySearchTreeNode2(int data) {
		if (root == null) {
			root = new BinarySearchTreeNode(data);
			return;
		}
		BinarySearchTreeNode parent = null;
		BinarySearchTreeNode current = root;
		while (current != null) {
			parent = current;
			if (data < current.data) {
				current = current.left;
			} else {
				current = current.right;
			}
		}

		if (data < parent.data) {
			parent.left = new BinarySearchTreeNode(data);
		} else {
			parent.right = new BinarySearchTreeNode(data);
		}
	}

	public void printInorderTraversal() {
		printInorderTraversalUtil(this.root);
	}

	private void printInorderTraversalUtil(BinarySearchTreeNode node) {
		if (node == null) {
			return;
		}
		printInorderTraversalUtil(node.left);
		System.out.print(node.data + " ");
		printInorderTraversalUtil(node.right);
	}

	public void printInorderTraversalIterative() {
		BinarySearchTreeNode current = this.root;
		Stack<BinarySearchTreeNode> stack = new Stack<>();
		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.push(current);
				current = current.left;
			}
			current = stack.pop();
			System.out.print(current.data + " ");
			current = current.right;
		}
		System.out.println();

	}

	public void printpreOrderTraversal() {
		printpreOrderTraversalUtil(this.root);
	}

	private void printpreOrderTraversalUtil(BinarySearchTreeNode node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		printpreOrderTraversalUtil(node.left);
		printpreOrderTraversalUtil(node.right);
	}

	public void printpreOrderTraversalIterative() {
		BinarySearchTreeNode current = this.root;
		Stack<BinarySearchTreeNode> stack = new Stack<>();
		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				System.out.print(current.data + " ");
				stack.push(current);
				current = current.left;
			}
			current = stack.pop();
			current = current.right;
		}
		System.out.println();
	}

	public void printpostOrderTraversal() {
		printpostOrderTraversalUtil(this.root);
	}

	private void printpostOrderTraversalUtil(BinarySearchTreeNode node) {
		if (node == null) {
			return;
		}
		printpostOrderTraversalUtil(node.left);
		printpostOrderTraversalUtil(node.right);
		System.out.print(node.data + " ");
	}

	public BinarySearchTreeNode searchBSTNode(int data) {
		BinarySearchTreeNode current = root;
		while (current != null) {
			if (current.data == data)
				return current;
			else if (data <= current.data)
				current = current.left;
			else
				current = current.right;
		}
		return null;
	}

	public BinarySearchTreeNode searchBSTNodeUsingRecursion(int data) {
		return searchBSTNodeUsingRecursionUtil(this.root, data);
	}

	private BinarySearchTreeNode searchBSTNodeUsingRecursionUtil(BinarySearchTreeNode root, int data) {
		if (root == null)
			return null;
		if (root.data == data)
			return root;
		else if (data <= root.data)
			return searchBSTNodeUsingRecursionUtil(root.left, data);
		else
			return searchBSTNodeUsingRecursionUtil(root.right, data);
	}

	public BinarySearchTreeNode deleteBinarySearchTreeNodeApproach2(int data) {
		return deleteBinarySearchTreeNodeUtil(this.root, data);
	}

	private BinarySearchTreeNode deleteBinarySearchTreeNodeUtil(BinarySearchTreeNode node, int data) {
		if (node == null)
			return null;
		BinarySearchTreeNode parent = null;
		BinarySearchTreeNode current = node;
		while (current != null) {
			if (data < current.data) {
				parent = current;
				current = current.left;
			} else if (data > current.data) {
				parent = current;
				current = current.right;
			} else {
				if (current.left == null && current.right == null) {
					if (parent == null)
						this.root = null;
					else if (parent.left == current)
						parent.left = null;
					else if (parent.right == current)
						parent.right = null;
					return current;
				} else if (current.left == null) {
					if (parent == null)
						this.root = current.right;
					else if (parent.left == current)
						parent.left = current.right;
					else if (parent.right == current)
						parent.right = current.right;
					return current;
				} else if (current.right == null) {
					if (parent == null)
						this.root = current.left;
					if (parent.left == current)
						parent.left = current.left;
					else if (parent.right == current)
						parent.right = current.left;
					return current;
				} else {
					BinarySearchTreeNode successorParent = current;
					BinarySearchTreeNode successor = current.right;
					while (successor.left != null) {
						successorParent = successor;
						successor = successor.left;
					}
					current.data = successor.data;
					parent = successorParent;
					current = successor;
					data = current.data;
				}

			}
		}
		return null;
	}

	public BinarySearchTreeNode deleteBinarySearchTreeNode(int data) {
		BinarySearchTreeNode parent = null;
		BinarySearchTreeNode current = this.root;
		while (current != null && current.data != data) {
			parent = current;
			if (data < current.data) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		if (current == null)
			return this.root;

		// Case 1: Node has two children
		if (current.left != null && current.right != null) {
			BinarySearchTreeNode successorParent = current;
			BinarySearchTreeNode successor = current.right;
			while (successor.left != null) {
				successorParent = successor;
				successor = successor.left;
			}
			current.data = successor.data;
			current = successor;
			parent = successorParent;
		}

		// Case 2 & 3: Node has at most one child
		BinarySearchTreeNode child = (current.left != null) ? current.left : current.right;

		if (parent == null) {
			this.root = child;
		}
		else if (parent.left == current) {
			parent.left = child;
		}
		else {
			parent.right = child;
		}

		return this.root;
	}

	private BinarySearchTreeNode inorderSuccessorNode(BinarySearchTreeNode node) {
		BinarySearchTreeNode next = node.right;
		while (next != null && next.left != null) {
			next = next.left;
		}
		return next;
	}

	public void deleteBinarySearchTreeNodeUsingRecursion(int data) {
		deleteBinarySearchTreeNodeUsingRecursionUtil(this.root, data);
	}

	private BinarySearchTreeNode deleteBinarySearchTreeNodeUsingRecursionUtil(BinarySearchTreeNode node, int data) {
		if (node == null)
			return null;

		if (data < node.data) {
			node.left = deleteBinarySearchTreeNodeUsingRecursionUtil(node.left, data);
		} else if (data > node.data) {
			node.right = deleteBinarySearchTreeNodeUsingRecursionUtil(node.right, data);
		} else {
			// Node to be deleted found
			if (node.left == null && node.right == null) {
				return null; // Leaf node
			} else if (node.left == null) {
				return node.right; // Single right child
			} else if (node.right == null) {
				return node.left; // Single left child
			} else {
				// Node with two children
				BinarySearchTreeNode nextMaximum = inorderSuccessorNode(node);
				int tempData = nextMaximum.data;
				node.right = deleteBinarySearchTreeNodeUsingRecursionUtil(node.right, tempData);
				node.data = tempData;

			}
		}
		return node;
	}

	public static void main(String[] args) {
		BinarySearchTreeClass bst = new BinarySearchTreeClass();
		bst.insertBinarySearchTreeNode(10);
		bst.insertBinarySearchTreeNode(11);
		bst.insertBinarySearchTreeNode(12);
		bst.insertBinarySearchTreeNode(14);
		bst.insertBinarySearchTreeNode(5);
		bst.insertBinarySearchTreeNode(0);
		bst.insertBinarySearchTreeNode(7);

		BinarySearchTreeClass bst1 = new BinarySearchTreeClass();
		bst1.insertBinarySearchTreeNode2(10);
		bst1.insertBinarySearchTreeNode2(11);
		bst1.insertBinarySearchTreeNode2(12);
		bst1.insertBinarySearchTreeNode2(14);
		bst1.insertBinarySearchTreeNode2(5);
		bst1.insertBinarySearchTreeNode2(0);
		bst1.insertBinarySearchTreeNode2(7);

		bst.printInorderTraversal();
		System.out.println();
		bst1.printInorderTraversal();
		System.out.println();
		System.out.println("---------------------------------------------");
		bst.printInorderTraversalIterative();
		System.out.println();
		bst1.printInorderTraversalIterative();
		System.out.println();
		System.out.println("---------------------------------------------");
		bst.printpreOrderTraversal();
		System.out.println();
		bst1.printpreOrderTraversal();
		System.out.println();
		System.out.println("---------------------------------------------");
		bst.printpreOrderTraversalIterative();
		System.out.println();
		bst1.printpreOrderTraversalIterative();
		System.out.println();
		System.out.println("---------------------------------------------");
		bst.printpostOrderTraversal();
		System.out.println();
		bst1.printpostOrderTraversal();
		System.out.println();
		System.out.println("---------------------------------------------");

		System.out.println("node found : " + ((bst.searchBSTNode(5) == null) ? false : true));
		System.out.println("node found : " + ((bst.searchBSTNode(35) == null) ? false : true));
		System.out.println("---------------------------------------------");
		System.out.println("node found : " + ((bst.searchBSTNodeUsingRecursion(5) == null) ? false : true));
		System.out.println("node found : " + ((bst.searchBSTNodeUsingRecursion(35) == null) ? false : true));
		System.out.println("---------------------------------------------");

		bst.deleteBinarySearchTreeNodeUsingRecursion(5);
		System.out.println("node deleted : ");
		bst.printInorderTraversalIterative();
		bst.deleteBinarySearchTreeNodeUsingRecursion(0);
		System.out.println("node deleted : ");
		bst.printInorderTraversalIterative();
		bst.deleteBinarySearchTreeNodeUsingRecursion(14);
		System.out.println("node deleted : ");
		bst.printInorderTraversalIterative();
		bst.deleteBinarySearchTreeNodeUsingRecursion(11);
		System.out.println("node deleted : ");
		bst.printInorderTraversalIterative();
		System.out.println("---------------------------------------------");
		bst.deleteBinarySearchTreeNodeApproach2(10);
		System.out.println("node deleted : ");
		bst.printInorderTraversalIterative();
		bst.deleteBinarySearchTreeNodeApproach2(7);
		System.out.println("node deleted : ");
		bst.printInorderTraversalIterative();
		bst.deleteBinarySearchTreeNodeApproach2(12);
		System.out.println("node deleted : ");
		bst.printInorderTraversalIterative();
		bst.deleteBinarySearchTreeNodeApproach2(11);
		System.out.println("node deleted : ");
		bst.printInorderTraversalIterative();
		System.out.println("---------------------------------------------");

		BinarySearchTreeClass bst2 = new BinarySearchTreeClass();
		bst2.insertBinarySearchTreeNode2(10);
		bst2.insertBinarySearchTreeNode2(11);
		bst2.insertBinarySearchTreeNode2(12);
		bst2.insertBinarySearchTreeNode2(14);
		bst2.insertBinarySearchTreeNode2(5);
		bst2.insertBinarySearchTreeNode2(0);
		bst2.insertBinarySearchTreeNode2(7);

		bst2.printInorderTraversal();
		System.out.println();
		System.out.println("---------------------------------------------");
		bst2.deleteBinarySearchTreeNode(10);
		System.out.println("node deleted : ");
		bst2.printInorderTraversalIterative();
		bst2.deleteBinarySearchTreeNode(7);
		System.out.println("node deleted : ");
		bst2.printInorderTraversalIterative();
		bst2.deleteBinarySearchTreeNode(12);
		System.out.println("node deleted : ");
		bst2.printInorderTraversalIterative();
		bst2.deleteBinarySearchTreeNode(11);
		System.out.println("node deleted : ");
		bst2.printInorderTraversalIterative();
		bst2.deleteBinarySearchTreeNode(0);
		System.out.println("node deleted : ");
		bst2.printInorderTraversalIterative();
		bst2.deleteBinarySearchTreeNode(14);
		System.out.println("node deleted : ");
		bst2.printInorderTraversalIterative();
		bst2.deleteBinarySearchTreeNode(5);
		System.out.println("node deleted : ");
		bst2.printInorderTraversalIterative();
		bst2.deleteBinarySearchTreeNode(11);
		System.out.println("node deleted : ");
		bst2.printInorderTraversalIterative();
		System.out.println("---------------------------------------------");

	}
}
