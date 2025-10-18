package AZStriverPlaylist.Tree.Hard;

import java.util.ArrayList;
import java.util.List;

import AZStriverPlaylist.Tree.BinaryTreeNode;

public class RootToNodePathInBinaryTree {
    /*
     * TIme Complexity  O(n)
     * Space Complexity : O(log n) (Recursion)
     */
    public static List<Integer> rootToNodeBacktracking(BinaryTreeNode root, int data) {
        List<Integer> path = new ArrayList<>();
        if(root==null) return path;
        rootToNodeBacktrackingUtil(root, path, data);
        return path;
    }

    public static boolean rootToNodeBacktrackingUtil(BinaryTreeNode root, List<Integer> path, int data) {
        if (root == null) {
            return false;
        }
        path.add(root.data);
        if (root.data == data) {
            return true;
        }
        if( rootToNodeBacktrackingUtil(root.left, path, data) || rootToNodeBacktrackingUtil(root.right, path, data)) return true;
        path.remove(path.size()-1);
        return false;
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
        System.out.println(rootToNodeBacktracking(root1,5));
        System.out.println("-------------------------------------------------");

        BinaryTreeNode root2 = new BinaryTreeNode(
                1,
                new BinaryTreeNode(
                        2,
                        new BinaryTreeNode(4),
                        new BinaryTreeNode(5)),
                new BinaryTreeNode(3)
            );
        System.out.println(rootToNodeBacktracking(root2,4));
        System.out.println("-------------------------------------------------");

        BinaryTreeNode root3 = new BinaryTreeNode(
                1,
                new BinaryTreeNode(
                    2,
                    new BinaryTreeNode(
                        4,
                    null,
                        new BinaryTreeNode(7)), 
                    null),
                new BinaryTreeNode(
                    3,
                    new BinaryTreeNode(5),
                    new BinaryTreeNode(6))
            );
        System.out.println(rootToNodeBacktracking(root3,8));
        System.out.println("-------------------------------------------------");

        BinaryTreeNode root4 = null;
        System.out.println(rootToNodeBacktracking(root4,5));
        System.out.println("-------------------------------------------------");
    }
}
