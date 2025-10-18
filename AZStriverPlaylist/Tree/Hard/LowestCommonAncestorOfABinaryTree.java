package AZStriverPlaylist.Tree.Hard;

import java.util.ArrayList;
import java.util.List;

import AZStriverPlaylist.Tree.BinaryTreeNode;

public class LowestCommonAncestorOfABinaryTree {
    /*
     * Time Complexity : O(n + log n)
     * Space COmplexity : O(log n)
     */
    public static BinaryTreeNode lowestCommonAncestor(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {
        List<List<BinaryTreeNode>> paths = new ArrayList<>();
        rootToNodeBacktrackingUtil(root, new ArrayList<>(), p, q, paths);
        int i = 0;
        List<BinaryTreeNode> path1 = paths.get(0);
        List<BinaryTreeNode> path2 = paths.get(1);
        while (i < path1.size() && i < path2.size()) {
            if (path1.get(i) != path2.get(i))
                break;
            i++;
        }
        return (--i >= 0) ? path1.get(i) : null;
    }

    public static void rootToNodeBacktrackingUtil(BinaryTreeNode root, List<BinaryTreeNode> path, BinaryTreeNode p,
            BinaryTreeNode q, List<List<BinaryTreeNode>> paths) {
        if (root == null)
            return;
        path.add(root);
        if (root == p || root == q) {
            paths.add(new ArrayList<>(path));
        }
        rootToNodeBacktrackingUtil(root.left, path, p, q, paths);
        rootToNodeBacktrackingUtil(root.right, path, p, q, paths);
        path.remove(path.size() - 1);
    }

    /*
     * Time Complexity : O(n)
     * Space COmplexity : O(log n)
     */
    public static BinaryTreeNode lowestCommonAncestorUsingRecusion(BinaryTreeNode root, BinaryTreeNode p,
            BinaryTreeNode q) {
        if (root == null || root == p || root == q)
            return root;

        BinaryTreeNode left = lowestCommonAncestorUsingRecusion(root.left, p, q);
        BinaryTreeNode right = lowestCommonAncestorUsingRecusion(root.right, p, q);

        if (left == null)
            root = right;
        else if (right == null)
            root = left;
        return root;
    }

    public static void main(String[] args) {
        BinaryTreeNode root1l = new BinaryTreeNode(
                5,
                new BinaryTreeNode(6),
                new BinaryTreeNode(
                        2,
                        new BinaryTreeNode(7),
                        new BinaryTreeNode(4)));
        BinaryTreeNode root1r = new BinaryTreeNode(
                1,
                new BinaryTreeNode(0),
                new BinaryTreeNode(8));
        BinaryTreeNode root1 = new BinaryTreeNode(3, root1l, root1r);

        System.out.println(lowestCommonAncestor(root1, root1l, root1r).data);
        System.out.println(lowestCommonAncestorUsingRecusion(root1, root1l, root1r).data);

        System.out.println("-------------------------------------------------");

        BinaryTreeNode root2lrr = new BinaryTreeNode(4);
        BinaryTreeNode root2l = new BinaryTreeNode(
                5,
                new BinaryTreeNode(6),
                new BinaryTreeNode(
                        2,
                        new BinaryTreeNode(7),
                        root2lrr));
        BinaryTreeNode root2r = new BinaryTreeNode(
                1,
                new BinaryTreeNode(0),
                new BinaryTreeNode(8));
        BinaryTreeNode root2 = new BinaryTreeNode(3, root2l, root2r);

        System.out.println(lowestCommonAncestor(root2, root2l, root2lrr).data);
        System.out.println(lowestCommonAncestorUsingRecusion(root2, root2l, root2lrr).data);

        System.out.println("-------------------------------------------------");

        BinaryTreeNode root3l = new BinaryTreeNode(2);
        BinaryTreeNode root3 = new BinaryTreeNode(1, root3l, null);

        System.out.println(lowestCommonAncestor(root3, root3, root3l).data);
        System.out.println(lowestCommonAncestorUsingRecusion(root3, root3, root3l).data);

        System.out.println("-------------------------------------------------");
    }
}
