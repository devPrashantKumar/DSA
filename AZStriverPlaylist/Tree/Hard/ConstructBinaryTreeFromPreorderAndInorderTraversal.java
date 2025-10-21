package AZStriverPlaylist.Tree.Hard;

import AZStriverPlaylist.Tree.BinaryTreeNode;
import AZStriverPlaylist.Tree.BinaryTreeTraversal;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    /*
     * Time Complexity : O(n^2)
     *      - O(n) computation
     *      - O(n) index find
     * Space Complexity : O(h), h is height of tree 
     */
    public static BinaryTreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeUtil(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    public static BinaryTreeNode buildTreeUtil(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if(inStart>inEnd) return null;
        BinaryTreeNode node = new BinaryTreeNode(preorder[preStart]);
        int index = findPreInInorder(preorder[preStart],inorder,inStart,inEnd);
        int leftSide = index-inStart;
        node.left = buildTreeUtil(preorder, preStart+1, preStart+leftSide, inorder, inStart, index-1);
        node.right = buildTreeUtil(preorder,  preStart+leftSide+1, preEnd, inorder, index+1, inEnd);
        return node;
    }

    public static int findPreInInorder(int pre, int[] inorder, int inStart, int inEnd){
        for(int i=inStart;i<=inEnd;i++){
            if(inorder[i]==pre) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] inorder1 = {9,3,15,20,7};
        int[] preorder1 = {3,9,20,15,7};
        BinaryTreeNode root1 = buildTree(preorder1,inorder1);
        BinaryTreeTraversal.iterativeInorderTraversal(root1);
        BinaryTreeTraversal.iterativePreOrderTraversal(root1);
    }
}
