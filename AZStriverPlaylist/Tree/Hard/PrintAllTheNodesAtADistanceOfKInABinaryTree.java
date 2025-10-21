package AZStriverPlaylist.Tree.Hard;

import java.util.*;

import AZStriverPlaylist.Tree.BinaryTreeNode;

public class PrintAllTheNodesAtADistanceOfKInABinaryTree {

    /**
     * Time Complexity: O(N)
     * Space Complexity: O(N), -> For queue, parentMap, and visited set.
     */
    public static List<Integer> distanceK(BinaryTreeNode root, BinaryTreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        Map<BinaryTreeNode, BinaryTreeNode> parentMap = new HashMap<>();
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        if (root == null)
            return result;
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

        Set<BinaryTreeNode> visited = new HashSet<>();
        queue.offer(target);
        // this visited approach will fail in case of graph
        while (k-- > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                BinaryTreeNode node = queue.poll();
                visited.add(node);
                if (node.left != null && !visited.contains(node.left))
                    queue.offer(node.left);
                if (node.right != null && !visited.contains(node.right))
                    queue.offer(node.right);
                if (parentMap.containsKey(node) && !visited.contains(parentMap.get(node)))
                    queue.offer(parentMap.get(node));
            }
        }

        /*
         * this approch also work for visited and more error proof
         * commented-out version is actually the correct one — it ensures nodes are
         * marked visited at enqueue time, not after dequeue.
         * it will prevent:
         *      revisiting the same node via parent references
         *      potentially infinite loop or duplicated nodes in queue (especially when k >1)
         */
        // visited.add(target);
        // while (k-- > 0) {
        //     int size = queue.size();
        //     for (int i = 0; i < size; i++) {
        //         BinaryTreeNode node = queue.poll();
        //         if (node.left != null && !visited.contains(node.left)) {
        //             visited.add(node.left);
        //             queue.offer(node.left);
        //         }
        //         if (node.right != null && !visited.contains(node.right)) {
        //             visited.add(node.right);
        //             queue.offer(node.right);
        //         }
        //         if (parentMap.containsKey(node) && !visited.contains(parentMap.get(node))) {
        //             queue.offer(parentMap.get(node));
        //             visited.add(parentMap.get(node));
        //         }
        //     }
        // }

        while (!queue.isEmpty()) {
            result.add(queue.poll().data);
        }

        return result;
    }

    public static void main(String[] args) {
        BinaryTreeNode root1 = new BinaryTreeNode(
                3,
                new BinaryTreeNode(
                        5,
                        new BinaryTreeNode(6),
                        new BinaryTreeNode(
                                2,
                                new BinaryTreeNode(7),
                                new BinaryTreeNode(4))),
                new BinaryTreeNode(
                        1,
                        new BinaryTreeNode(0),
                        new BinaryTreeNode(8)));
        System.out.println(distanceK(root1, root1.left, 2));

        System.out.println("-------------------------------------------------");
    }
}
