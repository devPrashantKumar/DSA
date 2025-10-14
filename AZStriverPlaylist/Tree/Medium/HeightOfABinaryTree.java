package AZStriverPlaylist.Tree.Medium;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

import AZStriverPlaylist.Tree.BinaryTreeNode;

public class HeightOfABinaryTree {
    /*
     * Time Complexity : O(n)
     * Space Complexity : O(n) ->space occupied by recursiove stack in worst case
     */
    public static int maxDepth(BinaryTreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /*
     * Time Complexity : O(n)
     * Space Complexity : O(n) ->space occupied by queue in all cases
     */
    public static int maxDepthIterative(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        if (Objects.isNull(root)) return 0;
        int height = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            height++;
            int labelNodes = queue.size();
            for (int i = 0; i < labelNodes; i++) {
                BinaryTreeNode node = queue.poll();
                if (Objects.nonNull(node.left))
                    queue.offer(node.left);
                if (Objects.nonNull(node.right))
                    queue.offer(node.right);
            }
        }
        return height;
    }

    public static void main(String[] args) {
        BinaryTreeNode root1 = new BinaryTreeNode(
                3,
                new BinaryTreeNode(9),
                new BinaryTreeNode(
                        20,
                        new BinaryTreeNode(5),
                        new BinaryTreeNode(7)));
        System.out.println(maxDepth(root1));
        System.out.println(maxDepthIterative(root1));
    }
}
