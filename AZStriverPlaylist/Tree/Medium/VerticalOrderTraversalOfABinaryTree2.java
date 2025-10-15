package AZStriverPlaylist.Tree.Medium;

import java.util.*;

import AZStriverPlaylist.Tree.BinaryTreeNode;

public class VerticalOrderTraversalOfABinaryTree2 {

    public List<List<Integer>> verticalTraversal2(BinaryTreeNode root) {
        SortedMap<Integer,List<Integer>> map = new TreeMap<>();
        verticalTraversalUtil2(root,0,map);

        Collection<List<Integer>> result = map.values();
        result.forEach(list -> list.sort(Collections.reverseOrder()));
        return new ArrayList<>(result);
    }

    public void verticalTraversalUtil2(BinaryTreeNode root, int column, SortedMap<Integer,List<Integer>> map) {
        if(Objects.isNull(root)) return;

        map.putIfAbsent(column, new ArrayList<>());
        map.get(column).add(root.data);
        verticalTraversalUtil2(root.left,column-1,map);
        verticalTraversalUtil2(root.right, column+1, map);
    }
}
