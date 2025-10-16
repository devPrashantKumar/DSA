package AZStriverPlaylist.Tree.Medium;

import java.util.*;

import AZStriverPlaylist.Tree.BinaryTreeNode;

public class BottomViewOfBinaryTree {

    static class NodeDetails {
        BinaryTreeNode node;
        int col;

        public NodeDetails(BinaryTreeNode node, int col) {
            this.col = col;
            this.node = node;
        }
    }

    /*
     * Time Complexity : O(n log k), where k = number of unique columns (diameter of binary tree)
     * Space Complexity : O(n)
     */
    public static List<Integer> bottomView(BinaryTreeNode root) {
        Queue<NodeDetails> queue = new LinkedList<>();
        TreeMap<Integer,Integer> tmap = new TreeMap<>();
        if (Objects.isNull(root))
            return List.of();
        queue.offer(new NodeDetails(root, 0));
        while (!queue.isEmpty()) {
            NodeDetails queueNode = queue.poll();
            tmap.put(queueNode.col,queueNode.node.data);
            
            if (Objects.nonNull(queueNode.node.left))
                queue.offer(new NodeDetails(queueNode.node.left, queueNode.col - 1));
            if (Objects.nonNull(queueNode.node.right))
                queue.offer(new NodeDetails(queueNode.node.right, queueNode.col + 1));

        }
        return new ArrayList<>(tmap.values());
    }

    public static void main(String[] args) {
        BinaryTreeNode root1 = new BinaryTreeNode(
                3,
                new BinaryTreeNode(9),
                new BinaryTreeNode(
                        20,
                        new BinaryTreeNode(15),
                        new BinaryTreeNode(7)));
        System.out.println(bottomView(root1));

        System.out.println("-------------------------------------------------");

        BinaryTreeNode root2 = new BinaryTreeNode(
            1,
            new BinaryTreeNode(
                2,
                new BinaryTreeNode(4),
                new BinaryTreeNode(5)
            ),
            new BinaryTreeNode(
                3,
                new BinaryTreeNode(6),
                new BinaryTreeNode(7)
            )
        );
        System.out.println(bottomView(root2));

        System.out.println("-------------------------------------------------");

        BinaryTreeNode root3 = new BinaryTreeNode(
            1,
            new BinaryTreeNode(
                2,
                new BinaryTreeNode(4),
                new BinaryTreeNode(6)
            ),
            new BinaryTreeNode(
                3,
                new BinaryTreeNode(5),
                new BinaryTreeNode(7)
            )
        );
        System.out.println(bottomView(root3));

        System.out.println("-------------------------------------------------");

        BinaryTreeNode root4 = null;
        System.out.println(bottomView(root4));

        System.out.println("-------------------------------------------------");
    }

}
