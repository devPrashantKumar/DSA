package AZStriverPlaylist.Tree.BinaryTreeUsingArray.BinaryTreeArrayExtra;

public class BinaryTreeArrayClassII {
    int[] binaryTreeArray;
    int capacity;

    public BinaryTreeArrayClassII(int capacity){
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
        BinaryTreeArrayClassII binaryTreeArrayClassII = new BinaryTreeArrayClassII(10);
        binaryTreeArrayClassII.addRoot(10);
        binaryTreeArrayClassII.addLeftChild(0, 11);
        binaryTreeArrayClassII.addRightChild(0, 12);
        binaryTreeArrayClassII.addLeftChild(1, 13);
        binaryTreeArrayClassII.addRightChild(1, 14);
        binaryTreeArrayClassII.addLeftChild(3, 15);
        binaryTreeArrayClassII.printBinaryTree(0, 0);       
    }
}
