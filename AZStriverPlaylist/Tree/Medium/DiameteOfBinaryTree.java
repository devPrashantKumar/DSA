package AZStriverPlaylist.Tree.Medium;

import java.util.Objects;

import AZStriverPlaylist.Tree.BinaryTreeNode;

public class DiameteOfBinaryTree {
    public static int diameterOfBinaryTree(BinaryTreeNode root) {
        if(Objects.isNull(root)) return 0;
        int[] maxDiameter=new int[]{0};
        diameterOfBinaryTreeUtil(root,maxDiameter);  
        return maxDiameter[0];         
    }

    public static int diameterOfBinaryTreeUtil(BinaryTreeNode root, int[] maxDiameter) {
        if(Objects.isNull(root)) return 0;
        int leftHeight = diameterOfBinaryTreeUtil(root.left,maxDiameter);
        int rightHeight = diameterOfBinaryTreeUtil(root.right, maxDiameter);
        maxDiameter[0] = (Math.max(maxDiameter[0],leftHeight+rightHeight));
        return Math.max(leftHeight, rightHeight)+1;        
    }
}
