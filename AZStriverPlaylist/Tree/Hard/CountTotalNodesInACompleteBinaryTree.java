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
