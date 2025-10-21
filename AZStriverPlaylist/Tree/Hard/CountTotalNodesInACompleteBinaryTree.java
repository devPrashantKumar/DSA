package AZStriverPlaylist.Tree.Hard;

import AZStriverPlaylist.Tree.BinaryTreeNode;

public class CountTotalNodesInACompleteBinaryTree {

    /*
     * Time Complexity : O(n)
     * Space Complexity : O(h), h->height of tree
     */
    public static int countNodes(BinaryTreeNode root) {
        if(root==null) return 0;
        return 1+countNodes(root.left)+countNodes(root.right);
    }


    /*
     * Time Complexity : O(n), complexity will be less than O(N)
     * Space Complexity : O(h), h->height of tree
     */
    public static int countNodesForCompleteTree(BinaryTreeNode root) {
        if(root==null) return 0;

        int leftHeight = findLeftHeight(root);
        int rightHeight = findRightHeight(root);

        if(leftHeight==rightHeight){
            return ((1<<(leftHeight))-1);
        }
        return 1+countNodes(root.left)+countNodes(root.right);
    }

    public static int findLeftHeight(BinaryTreeNode root) {
        if(root==null) return 0;
        return 1+findLeftHeight(root.left);
    }

    public static int findRightHeight(BinaryTreeNode root) {
        if(root==null) return 0;
        return 1+findRightHeight(root.right);
    }


}
