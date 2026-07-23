package AZStriverPlaylist.Tree.BinaryTreeUsingArray.BinaryTreeArrayExtra;

public class BinaryTreeNodeUsingArray {
    int[] binaryTreeArray;
    int capacity;

    public BinaryTreeNodeUsingArray(int capacity){
        this.capacity = capacity;
        this.binaryTreeArray = new int[capacity];
    }

    public void addRoot(int data){
        binaryTreeArray[0]=data;
    }

    public void addLeftChild(int root, int data){
        binaryTreeArray[(2*root)+1]=data;
    }

    public void addRightChild(int root, int data){
        binaryTreeArray[(2*root)+2]=data;
    }

    public void printBinaryTree(int root, int level){
        String indentation = " ".repeat(level);
        System.out.println(indentation+binaryTreeArray[root]);
        if(2*root+1<capacity && binaryTreeArray[2*root+1]!=0) printBinaryTree(2*root+1, level+1);
        if(2*root+2<capacity && binaryTreeArray[2*root+2]!=0) printBinaryTree(2*root+2, level+1);
    }
    
    public static void main(String[] args) {
        BinaryTreeNodeUsingArray binaryTreeNodeUsingArray = new BinaryTreeNodeUsingArray(10);
        binaryTreeNodeUsingArray.addRoot(10);
        binaryTreeNodeUsingArray.addLeftChild(0, 11);
        binaryTreeNodeUsingArray.addRightChild(0, 12);
        binaryTreeNodeUsingArray.addLeftChild(1, 13);
        binaryTreeNodeUsingArray.addRightChild(1, 14);
        binaryTreeNodeUsingArray.addLeftChild(3, 15);
        binaryTreeNodeUsingArray.printBinaryTree(0, 0);       
    }
}
