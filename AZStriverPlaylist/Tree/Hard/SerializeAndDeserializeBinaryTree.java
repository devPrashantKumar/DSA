package AZStriverPlaylist.Tree.Hard;

import java.util.*;

import AZStriverPlaylist.Tree.BinaryTreeNode;

public class SerializeAndDeserializeBinaryTree {
    /*
     * Time Complexity : O(n)
     * Space Complexity : O(n)
     */
    public static String serialize(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        StringBuilder str = new StringBuilder();
        if (root == null)
            return str.toString();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            if(node==null) str.append("n#");
            else str.append(node.data + "#");

            if (node != null) {
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return str.toString();
    }

    /*
     * Time Complexity : O(n)
     * Space Complexity : O(n)
     */
    public static BinaryTreeNode deserialize(String SerialisedData) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        String[] parts = SerialisedData.split("#");
        String[] list = Arrays.stream(parts)
                          .filter(s -> !s.isEmpty())
                          .toArray(String[]::new);
        //System.out.println(Arrays.toString(list));
        BinaryTreeNode root = null;
        if(list.length==0) return root;
        int i=0;
        root = new BinaryTreeNode(Integer.parseInt(list[i++]));
        queue.offer(root);
        while(!queue.isEmpty()){
            BinaryTreeNode node = queue.poll();
            if(!list[i].equals("n")){
                node.left = new BinaryTreeNode(Integer.parseInt(list[i]));
                queue.offer(node.left);
            }
            i++;
            if(!list[i].equals("n")){
                node.right = new BinaryTreeNode(Integer.parseInt(list[i]));
                queue.offer(node.right);
            } 
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        BinaryTreeNode root1 = new BinaryTreeNode(
                1,
                new BinaryTreeNode(
                        4,
                        new BinaryTreeNode(5),
                        null),
                new BinaryTreeNode(3));
        System.out.println(serialize(root1));
        System.out.println(deserialize(serialize(root1)));
        System.out.println(serialize(deserialize(serialize(root1))));
        System.out.println("-------------------------------------------------");

        BinaryTreeNode root2 = new BinaryTreeNode(
                10,
                new BinaryTreeNode(
                        4,
                        new BinaryTreeNode(1),
                        new BinaryTreeNode(3)),
                new BinaryTreeNode(
                        6,
                        new BinaryTreeNode(2),
                        new BinaryTreeNode(4)));
        System.out.println(serialize(root2));
        System.out.println(deserialize(serialize(root2)));
        System.out.println(serialize(deserialize(serialize(root2))));

        System.out.println("-------------------------------------------------");

    }
}
