package AZStriverPlaylist.Tree.Medium;

import java.util.*;

import AZStriverPlaylist.Tree.BinaryTreeNode;

public class VerticalOrderTraversalOfABinaryTree2 {

    static class NodeWithRow {
        int data;
        int row;

        public NodeWithRow(int data, int row) {
            this.row = row;
            this.data = data;
        }
    }

    public static List<List<Integer>> verticalTraversal2(BinaryTreeNode root) {
        SortedMap<Integer, List<NodeWithRow>> map = new TreeMap<>();
        verticalTraversalUtil2(root, 0, 0, map);

        Collection<List<NodeWithRow>> result = map.values();
        result.forEach(list -> list.sort((a, b) -> {
            if (a.row != b.row)
                return a.row - b.row;
            return a.data-b.data;
        }));
        return new ArrayList<>(result.stream().map(list -> list.stream().map(a -> a.data).toList()).toList());
    }

    public static void verticalTraversalUtil2(BinaryTreeNode root, int row, int column,
            SortedMap<Integer, List<NodeWithRow>> map) {
        if (Objects.isNull(root))
            return;

        map.putIfAbsent(column, new ArrayList<>());
        map.get(column).add(new NodeWithRow(root.data, row));
        verticalTraversalUtil2(root.left, row + 1, column - 1, map);
        verticalTraversalUtil2(root.right, row + 1, column + 1, map);
    }

    public static void main(String[] args) {
        BinaryTreeNode root1 = new BinaryTreeNode(
                3,
                new BinaryTreeNode(9),
                new BinaryTreeNode(
                        20,
                        new BinaryTreeNode(15),
                        new BinaryTreeNode(7)));
        System.out.println(verticalTraversal2(root1));

        System.out.println("-------------------------------------------------");

        BinaryTreeNode root2 = new BinaryTreeNode(
                1,
                new BinaryTreeNode(
                        2,
                        new BinaryTreeNode(4),
                        new BinaryTreeNode(5)),
                new BinaryTreeNode(
                        3,
                        new BinaryTreeNode(6),
                        new BinaryTreeNode(7)));
        System.out.println(verticalTraversal2(root2));

        System.out.println("-------------------------------------------------");

        BinaryTreeNode root3 = new BinaryTreeNode(
                1,
                new BinaryTreeNode(
                        2,
                        new BinaryTreeNode(4),
                        new BinaryTreeNode(6)),
                new BinaryTreeNode(
                        3,
                        new BinaryTreeNode(5),
                        new BinaryTreeNode(7)));
        System.out.println(verticalTraversal2(root3));

        System.out.println("-------------------------------------------------");
    }
}
