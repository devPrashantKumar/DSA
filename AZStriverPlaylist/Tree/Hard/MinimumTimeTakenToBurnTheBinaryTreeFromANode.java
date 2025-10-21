package AZStriverPlaylist.Tree.Hard;

import java.util.*;

import AZStriverPlaylist.Tree.BinaryTreeNode;

public class MinimumTimeTakenToBurnTheBinaryTreeFromANode {
    public static Map<BinaryTreeNode, BinaryTreeNode> extractParMap(BinaryTreeNode root) {
        Map<BinaryTreeNode, BinaryTreeNode> parentMap = new HashMap<>();
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            if (node.left != null) {
                parentMap.put(node.left, node);
                queue.offer(node.left);
            }
            if (node.right != null) {
                parentMap.put(node.right, node);
                queue.offer(node.right);
            }
        }
        return parentMap;
    }

    public static  BinaryTreeNode findTargetNode(BinaryTreeNode root, int num) {
        if(root==null || root.data==num) return root;
        BinaryTreeNode left = findTargetNode(root.left, num);
        return (left!=null) ? left : findTargetNode(root.right, num);
    }

    public static int timeToBurnTree(BinaryTreeNode root, int start) {
        if (root == null) return 0;
        Map<BinaryTreeNode, BinaryTreeNode> parentMap = extractParMap(root);
        BinaryTreeNode target = findTargetNode(root, start);
        if(target==null) return -1;

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        Set<BinaryTreeNode> processed = new HashSet<>();
        int burnTime=-1;
        queue.offer(target);
        while (!queue.isEmpty()) {
            burnTime++;
            int size = queue.size();
            while(size-->0){
                BinaryTreeNode node = queue.poll();
                processed.add(node);
                if(node.left!=null && !processed.contains(node.left)) queue.offer(node.left);
                if(node.right!=null && !processed.contains(node.right)) queue.offer(node.right);
                if(parentMap.containsKey(node) && !processed.contains(parentMap.get(node))) queue.offer(parentMap.get(node));
            }
        }
        return burnTime;
    }

    public static void main(String[] args) {
        BinaryTreeNode root1 = new BinaryTreeNode(
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
                        new BinaryTreeNode(6)));
        System.out.println(timeToBurnTree(root1, 1));

        System.out.println("-------------------------------------------------");

        BinaryTreeNode root2 = new BinaryTreeNode(
                1,
                new BinaryTreeNode(
                        2,
                        null,
                        new BinaryTreeNode(5)),
                new BinaryTreeNode(
                        3,
                        null,
                        new BinaryTreeNode(4)));
        System.out.println(timeToBurnTree(root2, 4));

        System.out.println("-------------------------------------------------");

        BinaryTreeNode root3 = new BinaryTreeNode(
                1,
                new BinaryTreeNode(
                        2,
                        new BinaryTreeNode(6),
                        new BinaryTreeNode(5)),
                new BinaryTreeNode(
                        3,
                        new BinaryTreeNode(8),
                        new BinaryTreeNode(4)));
        System.out.println(timeToBurnTree(root3, 4));

        System.out.println("-------------------------------------------------");
    }
}
