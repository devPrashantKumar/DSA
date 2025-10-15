package AZStriverPlaylist.Tree.Medium;

import java.util.*;

import AZStriverPlaylist.Tree.BinaryTreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {

    /*
     * TIme Complexity : O(n)
     * Space Complexity : O(2*n)
     */
    public static List<List<Integer>> zigzagLevelOrder(BinaryTreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (Objects.isNull(root))
            return result;
        int count = 0;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int labelChild = queue.size();
            List<Integer> label = new ArrayList<>();

            for (int i = 0; i < labelChild; i++) {
                BinaryTreeNode node = queue.poll();
                if (Objects.nonNull(node.left))
                    queue.add(node.left);
                if (Objects.nonNull(node.right))
                    queue.add(node.right);
                if (count % 2 == 0)
                    label.add(node.data);
                else
                    stack.push(node.data);
            }
            while (!stack.isEmpty()) {
                label.add(stack.pop());
            }
            result.add(label);
            count++;
        }
        return result;

    }

    /*
     * TIme Complexity : O(n)
     * Space Complexity : O(n)
     */
    public static List<List<Integer>> zigzagLevelOrderApproch2(BinaryTreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (Objects.isNull(root))
            return result;
        int count = 0;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int labelChild = queue.size();
            List<Integer> label = new ArrayList<>();

            for (int i = 0; i < labelChild; i++) {
                BinaryTreeNode node = queue.poll();
                if (Objects.nonNull(node.left))
                    queue.add(node.left);
                if (Objects.nonNull(node.right))
                    queue.add(node.right);
                label.add(node.data);
            }
            if (count % 2 != 0) {
                Collections.reverse(label);
            }
            result.add(label);
            count++;
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTreeNode root1 = new BinaryTreeNode(
                3,
                new BinaryTreeNode(9),
                new BinaryTreeNode(
                        20,
                        new BinaryTreeNode(15),
                        new BinaryTreeNode(7)));
        System.out.println(zigzagLevelOrder(root1));
        System.out.println(zigzagLevelOrderApproch2(root1));

        System.out.println("-------------------------------------------------");

        BinaryTreeNode root2 = new BinaryTreeNode(1);
        System.out.println(zigzagLevelOrder(root2));
        System.out.println(zigzagLevelOrderApproch2(root2));

        System.out.println("-------------------------------------------------");

        BinaryTreeNode root3 = null;
        System.out.println(zigzagLevelOrder(root3));
        System.out.println(zigzagLevelOrderApproch2(root3));

        System.out.println("-------------------------------------------------");
    }
}
