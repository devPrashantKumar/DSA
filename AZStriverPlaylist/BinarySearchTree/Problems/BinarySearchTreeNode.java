package AZStriverPlaylist.BinarySearchTree.Problems;

public class BinarySearchTreeNode<T> {
    T data;
    BinarySearchTreeNode<T> left;
    BinarySearchTreeNode<T> right;

    public BinarySearchTreeNode(T data) {
        this.data = data;
    }

    public BinarySearchTreeNode(T data, BinarySearchTreeNode<T> left, BinarySearchTreeNode<T> right) {
        this.data = data;
        this.left = left;
        this.right=right;
    }
}
