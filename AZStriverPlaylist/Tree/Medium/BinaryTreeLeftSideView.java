package AZStriverPlaylist.Tree.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

import AZStriverPlaylist.Tree.BinaryTreeNode;

public class BinaryTreeLeftSideView {
    /*
     * Time Complexity : O(n)
     * Space Complexity : O(n)
     */
    public static List<Integer> leftSideView(BinaryTreeNode root) {
        List<Integer> leftView = new ArrayList<>();
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        if (Objects.isNull(root))
            return leftView;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int labelNodes = queue.size();
            for (int i = 1; i <= labelNodes; i++) {
                BinaryTreeNode node = queue.poll();
                if (i == 1)
                    leftView.add(node.data);
                if (Objects.nonNull(node.left))
                    queue.offer(node.left);
                if (Objects.nonNull(node.right))
                    queue.offer(node.right);
            }
        }
        return leftView;
    }

    /*
     * Time Complexity : O(n)
     * Space Complexity : O(h), where h is height of tree
     */
    public static List<Integer> leftSideViewRecursive(BinaryTreeNode root) {
        List<Integer> leftView = new ArrayList<>();
        leftSideViewRecursiveUtil(root,0,leftView);
        return leftView;
    }

    public static void leftSideViewRecursiveUtil(BinaryTreeNode root, int label, List<Integer> leftView) {
        if (Objects.isNull(root)) return;
        if(label==leftView.size()) leftView.add(root.data);
        leftSideViewRecursiveUtil(root.left,label+1,leftView);
        leftSideViewRecursiveUtil(root.right,label+1,leftView);
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
        System.out.println(leftSideView(root1));
        System.out.println(leftSideViewRecursive(root1));
        System.out.println("-------------------------------------------------");

        BinaryTreeNode root2 = new BinaryTreeNode(
                1,
                new BinaryTreeNode(
                        2,
                        new BinaryTreeNode(
                            4,
                            new BinaryTreeNode(5),
                            null),
                    null),
                new BinaryTreeNode(3)
            );
        System.out.println(leftSideView(root2));
        System.out.println(leftSideViewRecursive(root2));
        System.out.println("-------------------------------------------------");

        BinaryTreeNode root3 = new BinaryTreeNode(
                1,
                null,
                new BinaryTreeNode(3)
            );
        System.out.println(leftSideView(root3));
        System.out.println(leftSideViewRecursive(root3));
        System.out.println("-------------------------------------------------");

        BinaryTreeNode root4 = null;
        System.out.println(leftSideView(root4));
        System.out.println(leftSideViewRecursive(root4));
        System.out.println("-------------------------------------------------");
    }
}