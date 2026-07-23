package AZStriverPlaylist.Tree.BinaryTree;

public class BinaryTreeNodeClass {
    int data;
    BinaryTreeNodeClass left;
    BinaryTreeNodeClass right;

    public BinaryTreeNodeClass(int data){
        this.data = data;
    }

    public void addLeftChild(BinaryTreeNodeClass child){
        this.left = child;
    }

    public void addRightChild(BinaryTreeNodeClass child){
        this.right = child;
    }

    public void printBinaryTree(int level){
        String indentation = " ".repeat(level);
        System.out.println(indentation+data);
        if(left!=null)left.printBinaryTree(level+1);
        if(right!=null)right.printBinaryTree(level+1);
    }

    public static void main(String[] args) {
        BinaryTreeNodeClass node1 = new BinaryTreeNodeClass(10);
        BinaryTreeNodeClass node2 = new BinaryTreeNodeClass(11);
        BinaryTreeNodeClass node3 = new BinaryTreeNodeClass(12);
        BinaryTreeNodeClass node4 = new BinaryTreeNodeClass(13);
        BinaryTreeNodeClass node5 = new BinaryTreeNodeClass(14);
        BinaryTreeNodeClass node6 = new BinaryTreeNodeClass(15);
    
        BinaryTreeNodeClass root = node1;
        node1.addLeftChild(node2);
        node1.addRightChild(node3);
        node2.addLeftChild(node4);
        node3.addLeftChild(node5);
        node3.addRightChild(node6);

        root.printBinaryTree(0);
    }
}
