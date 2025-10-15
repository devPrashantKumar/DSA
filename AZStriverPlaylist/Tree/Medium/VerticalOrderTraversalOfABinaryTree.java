package AZStriverPlaylist.Tree.Medium;

import java.util.*;
import java.util.stream.*;

import AZStriverPlaylist.Tree.BinaryTreeNode;

public class VerticalOrderTraversalOfABinaryTree {

    static class NodeDetails{
        int data;
        int row;
        int col;

        public NodeDetails(int data,int row, int col){
            this.col= col;
            this.row=row;
            this.data=data;
        }
    }

    /*
     * Time Complexity : O(n log n)
     * Space Complexity : O(n)
     */
    public static List<List<Integer>> verticalTraversal(BinaryTreeNode root) {
        List<NodeDetails> nodesList = new ArrayList<>();
        verticalTraversalUtil(root,0,0,nodesList);
        nodesList.sort((a,b)->{
            if (a.col != b.col) return a.col - b.col;
            if (a.row != b.row) return a.row - b.row;
            return a.data - b.data;
        });
        Map<Integer, List<Integer>> grouped = nodesList.stream().collect(Collectors.groupingBy(a->a.col,TreeMap::new,Collectors.mapping(n -> n.data, Collectors.toList())));
        return new ArrayList<>(grouped.values());
    }

    public static void verticalTraversalUtil(BinaryTreeNode root, int row, int column, List<NodeDetails> list) {
        if(Objects.isNull(root)) return;
        list.add(new NodeDetails(root.data, row, column));
        verticalTraversalUtil(root.left,row+1,column-1,list);
        verticalTraversalUtil(root.right, row+1,column+1, list);
    }

    public static void main(String[] args) {
        BinaryTreeNode root1 = new BinaryTreeNode(
                3,
                new BinaryTreeNode(9),
                new BinaryTreeNode(
                        20,
                        new BinaryTreeNode(15),
                        new BinaryTreeNode(7)));
        System.out.println(verticalTraversal(root1));

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
        System.out.println(verticalTraversal(root2));

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
        System.out.println(verticalTraversal(root3));

        System.out.println("-------------------------------------------------");
    }
}
