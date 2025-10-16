package AZStriverPlaylist.Tree.Medium;

import java.util.*;

import AZStriverPlaylist.Tree.BinaryTreeNode;

public class SymmetricTree {
    /*
     * Time Complexity : O(2*n)
     * Space Complexity :O(2*n)
     */
    public static boolean isSymmetric(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        if(Objects.isNull(root)) return true;
        queue.offer(root);
        while(!queue.isEmpty()){
            List<BinaryTreeNode> nodes = new ArrayList<>();
            int labelNodes = queue.size();
            for(int i=0;i<labelNodes;i++){
                BinaryTreeNode node = queue.poll();
                nodes.add(node);
                if(node!=null){
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            int size = nodes.size();
            for(int i=0;i<size/2;i++){
                if(Objects.isNull(nodes.get(i)) && Objects.isNull(nodes.get(size-i-1))) continue;
                if(Objects.isNull(nodes.get(i)) || Objects.isNull(nodes.get(size-i-1))) return false;
                if(nodes.get(i).data!=nodes.get(size-i-1).data) return false;
            }
        }
        return true;
    }

    /*
     * Time Complexity : O(n)
     * Space Complexity :O(n/2)
     */
    public static boolean isSymmetricMoreOptimised(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue1 = new LinkedList<>();
        Queue<BinaryTreeNode> queue2 = new LinkedList<>();
        if(Objects.isNull(root)) return true;
        queue1.offer(root.left);
        queue2.offer(root.right);
        while(!queue1.isEmpty() && !queue2.isEmpty()){
            BinaryTreeNode node1 = queue1.poll();
            BinaryTreeNode node2 = queue2.poll();
            if(node1==null && node2==null) continue;
            if(node1==null || node2==null) return false;
            if(node1.data!=node2.data) return false;
            if(node1!=null){
                queue1.offer(node1.left);
                queue1.offer(node1.right);
                queue2.offer(node2.right);
                queue2.offer(node2.left);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BinaryTreeNode root1 = new BinaryTreeNode(
                1,
                new BinaryTreeNode(
                    2,
                    new BinaryTreeNode(3),
                    new BinaryTreeNode(4)
                ),
                new BinaryTreeNode(
                    2,
                    new BinaryTreeNode(4),
                    new BinaryTreeNode(3)
                )
            );
        System.out.println(isSymmetric(root1));
        System.out.println(isSymmetricMoreOptimised(root1));
        System.out.println("-------------------------------------------------");

        BinaryTreeNode root2 = new BinaryTreeNode(
                1,
                new BinaryTreeNode(
                    2,
                    null,
                    new BinaryTreeNode(3)
                ),
                new BinaryTreeNode(
                    2,
                    null,
                    new BinaryTreeNode(3)
                )
            );
        System.out.println(isSymmetric(root2));
        System.out.println(isSymmetricMoreOptimised(root2));
        System.out.println("-------------------------------------------------");
        System.out.println("-------------------------------------------------");
    }
}
