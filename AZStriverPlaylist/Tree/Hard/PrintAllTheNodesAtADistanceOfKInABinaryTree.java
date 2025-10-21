package AZStriverPlaylist.Tree.Hard;

import java.util.*;

import AZStriverPlaylist.Tree.BinaryTreeNode;

public class PrintAllTheNodesAtADistanceOfKInABinaryTree {
    public static List<Integer> distanceK(BinaryTreeNode root, BinaryTreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        Map<BinaryTreeNode,BinaryTreeNode> parentMap = new HashMap<>();
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        if(root==null) return result;
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            if(node.left!=null){
                parentMap.put(node.left, node);
                queue.offer(node.left);
            }
            if(node.right!=null){
                parentMap.put(node.right, node);
                queue.offer(node.right);
            }
        }
        Set<BinaryTreeNode> visited = new HashSet<>();
        queue.offer(target);
        visited.add(target);
        while (k-->0) {
            int size = queue.size();
            for(int i=0;i<size;i++){
                BinaryTreeNode node = queue.poll();
                if(node.left!=null && !visited.contains(node.left)) {
                    visited.add(node.left);
                    queue.offer(node.left);
                }
                if(node.right!=null && !visited.contains(node.right)) {
                    visited.add(node.right);
                    queue.offer(node.right);
                }
                if(parentMap.containsKey(node) && !visited.contains(parentMap.get(node))){
                    queue.offer(parentMap.get(node));
                    visited.add(parentMap.get(node));
                } 
            }
        }

        while (!queue.isEmpty()) {
            result.add(queue.poll().data);
        }

        return result;
    }
}
