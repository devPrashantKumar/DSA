package AZStriverPlaylist.Tree.Hard;

import AZStriverPlaylist.Tree.BinaryTreeNode;

public class CountTotalNodesInACompleteBinaryTree {

    /*
     * Time Complexity : O(n)
     * Space Complexity : O(h), h->height of tree
     */
    public static int countNodes(BinaryTreeNode root) {
        if (root == null)
            return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    /**
     * Only works in case of complete or perfect binary tree.
     * Optimized for complete trees.
     *
     * Time Complexity: O((log n)^2) in average case
     * - O(log n) to compute left and right heights
     * - O(log n) recursion depth in worst case
     * Space Complexity: O(h), where h is the height of the tree (due to recursion
     * stack)
     */
    public static int countNodesForCompleteTree(BinaryTreeNode root) {
        if (root == null)
            return 0;

        int leftHeight = findLeftHeight(root.left);
        int rightHeight = findRightHeight(root.right);

        if (leftHeight == rightHeight) {
            return ((1 << (leftHeight + 1)) - 1);
        }
        return 1 + countNodesForCompleteTree(root.left) + countNodesForCompleteTree(root.right);
    }

    public static int findLeftHeight(BinaryTreeNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.left;
        }
        return count;
    }

    public static int findRightHeight(BinaryTreeNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.right;
        }
        return count;
    }

    public static void main(String[] args) {
        BinaryTreeNode root1 = new BinaryTreeNode(
                1,
                new BinaryTreeNode(
                        2,
                        new BinaryTreeNode(4),
                        new BinaryTreeNode(5)),
                new BinaryTreeNode(
                        3,
                        new BinaryTreeNode(6),
                        null));
        System.out.println(countNodes(root1));
        System.out.println(countNodesForCompleteTree(root1));

        System.out.println("-------------------------------------------------");

        BinaryTreeNode root2 = null;
        System.out.println(countNodes(root2));
        System.out.println(countNodesForCompleteTree(root2));

        System.out.println("-------------------------------------------------");

        BinaryTreeNode root3 = new BinaryTreeNode(1);
        System.out.println(countNodes(root3));
        System.out.println(countNodesForCompleteTree(root3));

        System.out.println("-------------------------------------------------");

    }

}
