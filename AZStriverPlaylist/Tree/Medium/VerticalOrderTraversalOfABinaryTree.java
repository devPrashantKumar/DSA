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
    public List<List<Integer>> verticalTraversal(BinaryTreeNode root) {
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

    public void verticalTraversalUtil(BinaryTreeNode root, int row, int column, List<NodeDetails> list) {
        if(Objects.isNull(root)) return;
        list.add(new NodeDetails(root.data, row, column));
        verticalTraversalUtil(root.left,row+1,column-1,list);
        verticalTraversalUtil(root.right, row+1,column+1, list);
    }
}
