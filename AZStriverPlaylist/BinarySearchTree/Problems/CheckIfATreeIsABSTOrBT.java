package AZStriverPlaylist.BinarySearchTree.Problems;

import java.util.ArrayList;
import java.util.List;

public class CheckIfATreeIsABSTOrBT {
    public static boolean isValidBST(BinarySearchTreeNode<Integer> root) {
        return isValidBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBSTUtil(BinarySearchTreeNode<Integer> root, long min, long max) {
        if (root == null)
            return true;
        if (root.data <= min || root.data >= max)
            return false;
        return isValidBSTUtil(root.left, min, root.data) &&
               isValidBSTUtil(root.right, root.data, max);
    }

    // start min, max with null, to overcome error if Integer.MAX_VALUE or Integer.MIN_VALUE available in tree
    public static boolean isValidBST2(BinarySearchTreeNode<Integer> root) {
        return isValidBSTUtil2(root, null, null);
    }

    public static boolean isValidBSTUtil2(BinarySearchTreeNode<Integer> node, Integer min, Integer max) {
        if (node == null)
            return true;
        if ((min != null && node.data <= min) || (max != null && node.data >= max))
            return false;
        return isValidBSTUtil2(node.left, min, node.data) &&
               isValidBSTUtil2(node.right, node.data, max);
    }

    public static boolean isValidBST3(BinarySearchTreeNode<Integer> root) {
        List<Integer> inOrder = new ArrayList<>();
        inOrderTraversal(root, inOrder);
        for(int i=1;i<inOrder.size();i++){
            if(inOrder.get(i)<=inOrder.get(i-1)) return false;
        }
        return true;
    }

    public static void inOrderTraversal(BinarySearchTreeNode<Integer> root, List<Integer> inorder) {
        if (root == null)
            return;
        inOrderTraversal(root.left, inorder);
        inorder.add(root.data);
        inOrderTraversal(root.right, inorder);
    }


    public static void main(String[] args) {
        Integer[] arr1 = { 1, 2, 3, 5, 9, 7 };
        BinarySearchTreeNode<Integer> root = BinarySearchTreeUtility.convertArrayToBst(arr1);
        BinarySearchTreeUtility.printBST(root);
        System.out.println("----------------------------------------------------------");
        System.out.println("is BST : "+CheckIfATreeIsABSTOrBT.isValidBST(root));
        System.out.println("is BST : "+CheckIfATreeIsABSTOrBT.isValidBST2(root));
        System.out.println("is BST : "+CheckIfATreeIsABSTOrBT.isValidBST3(root));
        System.out.println("----------------------------------------------------------");

        BinarySearchTreeNode<Integer> root2 = BinarySearchTreeUtility.convertArrayToBst(arr1);
        root2.right.right.data = 10;
        BinarySearchTreeUtility.printBST(root2);
        System.out.println("----------------------------------------------------------");
        System.out.println("is BST : "+CheckIfATreeIsABSTOrBT.isValidBST(root2));
        System.out.println("is BST : "+CheckIfATreeIsABSTOrBT.isValidBST2(root2));
        System.out.println("is BST : "+CheckIfATreeIsABSTOrBT.isValidBST3(root2));
    }
}
