package AZStriverPlaylist.Tree.BinaryTreeUsingArray.BinaryTreeNodeUsingArrayChildren;

public class BinaryTreeNodeUsingArrayChildren {
    int data;
    BinaryTreeNodeUsingArrayChildren[] children;

    public BinaryTreeNodeUsingArrayChildren(int data){
        this.data = data;
        this.children = new BinaryTreeNodeUsingArrayChildren[2];
    }

    public void addLeftChild(BinaryTreeNodeUsingArrayChildren child){
        this.children[0] = child;
    }

    public void addRightChild(BinaryTreeNodeUsingArrayChildren child){
        this.children[1] = child;
    }

    public void printBinaryTree(int level){
        String indentation = " ".repeat(level);
        System.out.println(indentation+data); 
        if(children[0]!=null) children[0].printBinaryTree(level+1);
        if(children[1]!=null) children[1].printBinaryTree(level+1);
    }

    public static void main(String[] args) {
        BinaryTreeNodeUsingArrayChildren node1 = new BinaryTreeNodeUsingArrayChildren(10);
        BinaryTreeNodeUsingArrayChildren node2 = new BinaryTreeNodeUsingArrayChildren(11);
        BinaryTreeNodeUsingArrayChildren node3 = new BinaryTreeNodeUsingArrayChildren(12);
        BinaryTreeNodeUsingArrayChildren node4 = new BinaryTreeNodeUsingArrayChildren(13);
        BinaryTreeNodeUsingArrayChildren node5 = new BinaryTreeNodeUsingArrayChildren(14);
        BinaryTreeNodeUsingArrayChildren node6 = new BinaryTreeNodeUsingArrayChildren(15);
     
        BinaryTreeNodeUsingArrayChildren root = node1;
        node1.addLeftChild(node2);
        node1.addRightChild(node3);
        node2.addLeftChild(node4);
        node3.addLeftChild(node5);
        node3.addRightChild(node6);

        root.printBinaryTree(0);
    }
}
