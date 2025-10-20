package AZStriverPlaylist.Tree.Hard;

import java.util.*;
import AZStriverPlaylist.Tree.BinaryTreeNode;

public class MaximumWidthOfABinaryTree {
    static class NodeWithPosition {
        BinaryTreeNode node;
        int position;

        NodeWithPosition(BinaryTreeNode node, int position) {
            this.node = node;
            this.position = position;
        }
    }

    /*
     * Time COmplexity : O(2^n)
     * Space COmplexity : O(2^n)
     */
    public static int widthOfBinaryTree(BinaryTreeNode root) {
        int maxWidth = 0;
        if (root == null)
            return maxWidth;
        Deque<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            while (!queue.isEmpty() && queue.peek() == null) {
                queue.remove();
            }
            while (!queue.isEmpty() && queue.peekLast() == null) {
                queue.removeLast();
            }
            int size = queue.size();
            maxWidth = Math.max(maxWidth, size);
            for (int i = 0; i < size; i++) {
                BinaryTreeNode node = queue.poll();
                if (node != null) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                } else {
                    queue.offer(null);
                    queue.offer(null);
                }
            }
        }
        return maxWidth;
    }

    /*
     * Time COmplexity : O(n)
     * Space COmplexity : O(n)
     */
    public static int widthOfBinaryTreeOptimised(BinaryTreeNode root) {
        int maxWidth = 0;
        if (root == null)
            return maxWidth;
        Queue<NodeWithPosition> queue = new LinkedList<>();
        queue.offer(new NodeWithPosition(root, 0));
        int firstPostion = 0;
        int lastPosition = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NodeWithPosition node = queue.poll();
                if (i == 0)
                    firstPostion = node.position;
                if (i == size - 1)
                    lastPosition = node.position;
                if (node.node.left != null)
                    queue.offer(new NodeWithPosition(node.node.left, 2 * node.position + 1));
                if (node.node.right != null)
                    queue.offer(new NodeWithPosition(node.node.right, 2 * node.position + 2));
            }
            maxWidth = Math.max(maxWidth, lastPosition - firstPostion + 1);
        }
        return maxWidth;
    }

    /*
     * Time COmplexity : O(n)
     * Space COmplexity : O(n)
     */
    public static int widthOfBinaryTreeDatatypeOverflowOptimised(BinaryTreeNode root) {
        int maxWidth = 0;
        if (root == null)
            return maxWidth;
        Queue<NodeWithPosition> queue = new LinkedList<>();
        queue.offer(new NodeWithPosition(root, 0));
        int firstPostion = 0;
        int lastPosition = 0;
        int minPosition = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NodeWithPosition node = queue.poll();
                if (i == 0) {
                    firstPostion = node.position;
                    minPosition = firstPostion;
                }
                if (i == size - 1)
                    lastPosition = node.position;
                if (node.node.left != null)
                    queue.offer(new NodeWithPosition(node.node.left, (2 * node.position + 1) - minPosition));
                if (node.node.right != null)
                    queue.offer(new NodeWithPosition(node.node.right, (2 * node.position + 2) - minPosition));
            }
            maxWidth = Math.max(maxWidth, lastPosition - firstPostion + 1);
        }
        return maxWidth;
    }

    public static void main(String[] args) {
        BinaryTreeNode root1 = new BinaryTreeNode(
                1,
                new BinaryTreeNode(
                        3,
                        new BinaryTreeNode(5),
                        new BinaryTreeNode(3)),
                new BinaryTreeNode(
                        2,
                        null,
                        new BinaryTreeNode(9)));
        System.out.println(widthOfBinaryTree(root1));
        System.out.println(widthOfBinaryTreeOptimised(root1));
        System.out.println(widthOfBinaryTreeDatatypeOverflowOptimised(root1));

        System.out.println("-------------------------------------------------");

        BinaryTreeNode root2 = new BinaryTreeNode(
                1,
                new BinaryTreeNode(
                        3,
                        new BinaryTreeNode(
                                5,
                                new BinaryTreeNode(6),
                                null),
                        null),
                new BinaryTreeNode(2,
                        null,
                        new BinaryTreeNode(
                                9,
                                new BinaryTreeNode(7),
                                null)));
        System.out.println(widthOfBinaryTree(root2));
        System.out.println(widthOfBinaryTreeOptimised(root2));
        System.out.println(widthOfBinaryTreeDatatypeOverflowOptimised(root2));

        System.out.println("-------------------------------------------------");

        BinaryTreeNode root3 = new BinaryTreeNode(
                1,
                new BinaryTreeNode(
                        3,
                        new BinaryTreeNode(5),
                        null),
                new BinaryTreeNode(2));
        System.out.println(widthOfBinaryTree(root3));
        System.out.println(widthOfBinaryTreeOptimised(root3));
        System.out.println(widthOfBinaryTreeDatatypeOverflowOptimised(root3));

        System.out.println("-------------------------------------------------");

        BinaryTreeNode root4 = null;
        System.out.println(widthOfBinaryTree(root4));
        System.out.println(widthOfBinaryTreeOptimised(root4));
        System.out.println(widthOfBinaryTreeDatatypeOverflowOptimised(root4));

        System.out.println("-------------------------------------------------");
    }

}
