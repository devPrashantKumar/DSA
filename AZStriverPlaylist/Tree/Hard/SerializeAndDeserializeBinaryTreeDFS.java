package AZStriverPlaylist.Tree.Hard;

import AZStriverPlaylist.Tree.BinaryTreeNode;

public class SerializeAndDeserializeBinaryTreeDFS {
    /*
     * Time Complexity : O(n)
     * Space Complexity : O(n)
     */
    public static String serialize(BinaryTreeNode root) {
        StringBuilder str = new StringBuilder();
        dfs(root,str);
        return str.toString();
    }

    public static void dfs(BinaryTreeNode root, StringBuilder str){
        if(root==null){
            str.append("#,"); 
            return;
        }
        str.append(root.data).append(",");
        dfs(root.left,str);
        dfs(root.right,str);
    }

    /*
     * Time Complexity : O(n)
     * Space Complexity : O(n)
     */
    public static BinaryTreeNode deserialize(String serialisedData) {
        String[] nodes = serialisedData.split(",");
        int[] index = {0};
        return deserializeUtil(nodes, index);
    }

    public static BinaryTreeNode deserializeUtil(String[] nodes, int[] index) {
        if(nodes[index[0]].equals("#")) {
            index[0]++;
            return null;
        }
        BinaryTreeNode node = new BinaryTreeNode(Integer.valueOf(nodes[index[0]++]));
        node.left = deserializeUtil(nodes, index);
        node.right = deserializeUtil(nodes, index);
        return node;
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
