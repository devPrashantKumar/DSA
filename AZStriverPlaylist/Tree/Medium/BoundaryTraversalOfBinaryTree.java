package AZStriverPlaylist.Tree.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import AZStriverPlaylist.Tree.BinaryTreeNode;

public class BoundaryTraversalOfBinaryTree {
    public static List<Integer> boundary(BinaryTreeNode root) {
        List<Integer> boundary = new ArrayList<>();
        Stack<Integer> stk = new Stack<>();
        if(root==null) return boundary;
        BinaryTreeNode node = root;
        while(node != null) {
            if (node.left != null || node.right != null)
                boundary.add(node.data);
            node = (node.left != null) ? node.left : node.right;
        }
        System.out.println(boundary);
        inorder(root,boundary);
        System.out.println(boundary);
        node = root.right;;
        while(node!=null){
            if(node.left!=null || node.right!=null) stk.push(node.data);
            node = (node.right!=null) ? node.right : node.left;
            
        }
        while(!stk.isEmpty()) boundary.add(stk.pop());
        return boundary;
    }

    public static void inorder(BinaryTreeNode root, List<Integer> boundary){
        if(root==null) return;
        if(root.left==null && root.right==null) boundary.add(root.data);
        inorder(root.left, boundary);
        inorder(root.right, boundary);
    }

    public static void main(String[] args) {
        BinaryTreeNode root1 = new BinaryTreeNode(
                1,
                new BinaryTreeNode(
                    2,
                    null,
                    new BinaryTreeNode(5)
                ),
                new BinaryTreeNode(
                    3,
                    null,
                    new BinaryTreeNode(4)
                )
            );
        System.out.println(boundary(root1));
        System.out.println("-------------------------------------------------");
    }
}
