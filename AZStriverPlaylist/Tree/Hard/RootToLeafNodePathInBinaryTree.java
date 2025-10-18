package AZStriverPlaylist.Tree.Hard;

import java.util.ArrayList;
import java.util.List;

import AZStriverPlaylist.Tree.BinaryTreeNode;

public class RootToLeafNodePathInBinaryTree {
    /*
     * TIme Complexity  O(n)
     * Space Complexity : O(log n) (Recursion)
     * list Space : O(N) total Copies created for each valid path
     */
    public static List<List<Integer>> allRootToLeaf(BinaryTreeNode root) {
        List<List<Integer>> paths = new ArrayList<>();
        allRootToLeafUtil(root, new ArrayList<>(), paths);
        return paths;
    }

    public static void allRootToLeafUtil(BinaryTreeNode root, List<Integer> path, List<List<Integer>> paths) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {
            paths.add(path);
            return;
        }
        allRootToLeafUtil(root.left, new ArrayList<>(path), paths);
        allRootToLeafUtil(root.right, new ArrayList<>(path), paths);
    }

    /*
     * TIme Complexity  O(n)
     * Space Complexity : O(log n) (Recursion)
     * list Space : O(N) total Copies created for each valid path
     */
    public static List<List<Integer>> allRootToLeafBacktracking(BinaryTreeNode root) {
        List<List<Integer>> paths = new ArrayList<>();
        allRootToLeafBacktrackingUtil(root, new ArrayList<>(), paths);
        return paths;
    }

    public static void allRootToLeafBacktrackingUtil(BinaryTreeNode root, List<Integer> path, List<List<Integer>> paths) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {
            paths.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }
        allRootToLeafBacktrackingUtil(root.left, path, paths);
        allRootToLeafBacktrackingUtil(root.right, path, paths);
        path.remove(path.size()-1);
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
        System.out.println(allRootToLeaf(root1));
        System.out.println(allRootToLeafBacktracking(root1));
        System.out.println("-------------------------------------------------");

        BinaryTreeNode root2 = new BinaryTreeNode(
                1,
                new BinaryTreeNode(
                        2,
                        new BinaryTreeNode(4),
                        new BinaryTreeNode(5)),
                new BinaryTreeNode(3)
            );
        System.out.println(allRootToLeaf(root2));
        System.out.println(allRootToLeafBacktracking(root2));
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
        System.out.println(allRootToLeaf(root3));
        System.out.println(allRootToLeafBacktracking(root3));
        System.out.println("-------------------------------------------------");

        BinaryTreeNode root4 = null;
        System.out.println(allRootToLeaf(root4));
        System.out.println(allRootToLeafBacktracking(root4));
        System.out.println("-------------------------------------------------");
    }
}
