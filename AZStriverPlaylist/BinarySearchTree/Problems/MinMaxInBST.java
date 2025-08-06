package AZStriverPlaylist.BinarySearchTree.Problems;

public class MinMaxInBST {
    public static <T> BinarySearchTreeNode<T> minInBST(BinarySearchTreeNode<T> root) {
        if (root == null) {
            System.out.println("BST is Empty");
            return root;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static <T> BinarySearchTreeNode<T> maxInBST(BinarySearchTreeNode<T> root) {
        if (root == null) {
            System.out.println("BST is Empty");
            return root;
        }
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] arr1 = { 1, 2, 3, 4, 5, 6, 7 };
        BinarySearchTreeNode<Integer> root = BinarySearchTreeUtility.convertArrayToBst(arr1);
        BinarySearchTreeUtility.printBST(root);
        System.out.println("----------------------------------------------------------");
        System.out.println("Min in BST : "+MinMaxInBST.minInBST(root).data);
        System.out.println("Max in BST : "+MinMaxInBST.maxInBST(root).data);
    }
}
