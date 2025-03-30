package DataStructures.BinarySearchTree;

public class BinarySearchTreeClassTest {
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


		System.out.println("---------------------------------------------");
		System.out.println("---------------------------------------------");

		BinarySearchTreeClass.BinarySearchTreeNode deletedNode = bst.deleteBinarySearchTreeNode(5);
		System.out.println("node deleted : "+deletedNode.data);
	}
}
