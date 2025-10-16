package AZStriverPlaylist.Tree.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

import AZStriverPlaylist.Tree.BinaryTreeNode;

public class BinaryTreeRightSideView {
    /*
     * Time Complexity : O(n)
     * Space Complexity : O(n)
     */
    public static List<Integer> rightSideView(BinaryTreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        if (Objects.isNull(root))
            return rightView;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int labelNodes = queue.size();
            for (int i = 1; i <= labelNodes; i++) {
                BinaryTreeNode node = queue.poll();
                if (i == labelNodes)
                    rightView.add(node.data);
                if (Objects.nonNull(node.left))
                    queue.offer(node.left);
                if (Objects.nonNull(node.right))
                    queue.offer(node.right);
            }
        }
        return rightView;
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
        System.out.println(rightSideView(root1));

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
        System.out.println(rightSideView(root2));

        System.out.println("-------------------------------------------------");

        BinaryTreeNode root3 = new BinaryTreeNode(
                1,
                null,
                new BinaryTreeNode(3)
            );
        System.out.println(rightSideView(root3));

        System.out.println("-------------------------------------------------");

        BinaryTreeNode root4 = null;
        System.out.println(rightSideView(root4));

        System.out.println("-------------------------------------------------");
    }
}