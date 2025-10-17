package AZStriverPlaylist.Tree.Medium;

import AZStriverPlaylist.Tree.BinaryTreeNode;

public class BinaryTreeMaximumPathSum {

    /*
     * Time Complexity : O(n)
     * Space Complexity : O(h) h-> height of tree
     */
    public static int maxPathSum(BinaryTreeNode root) {
        int[] maxPath = {0};
        maxPathSumUtil(root, maxPath);
        return maxPath[0];
    }
    
    public static int maxPathSumUtil(BinaryTreeNode root, int[] maxPath) {
        if (root==null) return 0;
        int leftPath = maxPathSumUtil(root.left, maxPath);
        if (leftPath<0) leftPath=0;
        int rightPath = maxPathSumUtil(root.right, maxPath);
        if (rightPath<0) rightPath=0;
        maxPath[0] = Math.max(maxPath[0],leftPath+rightPath+root.data);
        return Math.max(leftPath, rightPath)+root.data; 

    }
    public static void main(String[] args) {
        BinaryTreeNode root1 = new BinaryTreeNode(
                1,
                new BinaryTreeNode(2),
                new BinaryTreeNode(3)
            );
        System.out.println(maxPathSum(root1));
        System.out.println("-------------------------------------------------");

        BinaryTreeNode root2 = new BinaryTreeNode(
                -10,
                new BinaryTreeNode(9),
                new BinaryTreeNode(
                    20, 
                    new BinaryTreeNode(15), 
                    new BinaryTreeNode(7)
                )
            );
        System.out.println(maxPathSum(root2));
        System.out.println("-------------------------------------------------");
    }
}