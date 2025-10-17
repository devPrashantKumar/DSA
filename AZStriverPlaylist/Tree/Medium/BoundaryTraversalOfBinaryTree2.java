package AZStriverPlaylist.Tree.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import AZStriverPlaylist.Tree.BinaryTreeNode;

public class BoundaryTraversalOfBinaryTree2 {
     /*
      * Time Complexity : O(h+n+h+h) -> O(n)
      * Space Complexity : O(h), h is height of tree
      */
    public static List<Integer> boundary(BinaryTreeNode root) {
        List<Integer> boundary = new ArrayList<>();
        Stack<Integer> stk = new Stack<>();
        if (root == null)
            return boundary;
        BinaryTreeNode node = root;
        while (true) {
            if (node.left == null && node.right == null)
                break;
            boundary.add(node.data);
            if (node.left != null)
                node = node.left;
            else if (node.right != null)
                node = node.right;
        }
        inorder(root, boundary);
        node = root.right;
        while (node!=null) {
            if (node.left == null && node.right == null)
                break;
            stk.push(node.data);
            if (node.right != null)
                node = node.right;
            else if (node.left != null)
                node = node.left;
        }
        while (!stk.empty())
            boundary.add(stk.pop());
        return boundary;
    }

    public static void inorder(BinaryTreeNode root, List<Integer> boundary) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            boundary.add(root.data);
        inorder(root.left, boundary);
        inorder(root.right, boundary);
    }

    public static void main(String[] args) {
        BinaryTreeNode root1 = new BinaryTreeNode(
                1,
                new BinaryTreeNode(
                        2,
                        null,
                        new BinaryTreeNode(5)),
                new BinaryTreeNode(
                        3,
                        null,
                        new BinaryTreeNode(4)));
        System.out.println(boundary(root1));
        System.out.println("-------------------------------------------------");

        BinaryTreeNode root2 = new BinaryTreeNode(
                1,
                new BinaryTreeNode(
                        2,
                        new BinaryTreeNode(4),
                        new BinaryTreeNode(
                            5,
                            new BinaryTreeNode(8),
                            new BinaryTreeNode(9))),
                new BinaryTreeNode(
                        3,
                        new BinaryTreeNode(6),
                        new BinaryTreeNode(7)));
        System.out.println(boundary(root2));
        System.out.println("-------------------------------------------------");

         BinaryTreeNode root3 = new BinaryTreeNode(
                1,
                new BinaryTreeNode(
                    2,
                    new BinaryTreeNode(
                        4,
                        new BinaryTreeNode(6),
                        new BinaryTreeNode(5)),
                    new BinaryTreeNode(
                        9,
                        new BinaryTreeNode(
                            3,
                            new BinaryTreeNode(7),
                            new BinaryTreeNode(8)),
                        null)),
                null);
        System.out.println(boundary(root3));
        System.out.println("-------------------------------------------------");
    }
}
