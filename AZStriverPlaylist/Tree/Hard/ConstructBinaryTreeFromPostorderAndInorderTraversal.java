package AZStriverPlaylist.Tree.Hard;

import java.util.*;
import AZStriverPlaylist.Tree.BinaryTreeNode;
import AZStriverPlaylist.Tree.BinaryTreeTraversal;

public class ConstructBinaryTreeFromPostorderAndInorderTraversal {
    public static Map<Integer, Integer> extractInorderIndex(int[] inorder) {
        Map<Integer, Integer> inOrderIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderIndex.put(inorder[i], i);
        }
        return inOrderIndex;
    }

    /*
     * Time Complexity : O(n)
     * - O(n) computation
     * - O(1) index find
     * Space Complexity : O(h)+O(n), h is height of tree, n nodes in inorder
     */

    public static BinaryTreeNode buildTree(int[] postorder, int[] inorder) {
        Map<Integer, Integer> inOrderIndex = extractInorderIndex(inorder);
        return buildTreeUtil(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, inOrderIndex);
    }

    public static BinaryTreeNode buildTreeUtil(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inOrderIndex) {
        if (inStart > inEnd ) return null;

        BinaryTreeNode node = new BinaryTreeNode(postorder[postEnd]);
        int index = inOrderIndex.get(postorder[postEnd]);

        int leftSide = index - inStart;
        int rightSide = inEnd-index;
         
        // any one will work, it just a different way to calculate indexs

        // node.left = buildTreeUtil(postorder, postStart, postEnd-rightSide-1, inorder, inStart, index - 1,inOrderIndex);
        // node.right = buildTreeUtil(postorder, postEnd - rightSide, postEnd - 1, inorder, index + 1, inEnd, inOrderIndex);

        // node.left = buildTreeUtil(postorder, postStart, postStart+leftSide-1, inorder, inStart, index - 1,inOrderIndex);
        // node.right = buildTreeUtil(postorder, postStart + leftSide, postEnd - 1, inorder, index + 1, inEnd, inOrderIndex);

        node.left = buildTreeUtil(postorder, postStart, postStart+leftSide-1 , inorder, inStart, index - 1,inOrderIndex);
        node.right = buildTreeUtil(postorder, postEnd - rightSide, postEnd - 1, inorder, index + 1, inEnd, inOrderIndex);
        return node;
    }

    public static void main(String[] args) {
        int[] inorder1 = { 9, 3, 15, 20, 7 };
        int[] postorder1 = { 9, 15, 7, 20, 3 };
        BinaryTreeNode root1 = buildTree(postorder1, inorder1);
        BinaryTreeTraversal.iterativeInorderTraversal(root1);
        BinaryTreeTraversal.iterativePreOrderTraversal(root1);
        BinaryTreeTraversal.iterativePostOrderTraversal(root1);

    }
}
