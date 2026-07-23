package AZStriverPlaylist.Tree.BinaryTreeUsingArray.BinaryTreeArrayExtra;

public class BinaryTreeArrayClass {
    int[] arr;
    int lastUsedIndex;

    BinaryTreeArrayClass(int size){
        this.arr = new int[size+1];
        lastUsedIndex=0;
    }

    public boolean isFull(){
        return lastUsedIndex==arr.length-1;
    }

    public void insertNode(int data){
        if(!isFull()){
            arr[++lastUsedIndex]= Integer.valueOf(data);
        }else{
            System.out.println("space is full");
        }
    }

    public void inOrderTraversal(int nodeIndex){
        if(nodeIndex>lastUsedIndex){
            return;
        }
        inOrderTraversal(2*nodeIndex);
        System.out.print(arr[nodeIndex]+" ");
        inOrderTraversal(2*nodeIndex+1);
    }

    public void preOrderTraversal(int nodeIndex){
        if(nodeIndex>lastUsedIndex){
            return;
        }
        System.out.print(arr[nodeIndex]+" ");
        preOrderTraversal(2*nodeIndex);
        preOrderTraversal(2*nodeIndex+1);
    }

    public void postOrderTraversal(int nodeIndex){
        if(nodeIndex>lastUsedIndex){
            return;
        }
        postOrderTraversal(2*nodeIndex);
        postOrderTraversal(2*nodeIndex+1);
        System.out.print(arr[nodeIndex]+" ");
    }

    public void levelOrderTraversal(){
        for(int i=1;i<=lastUsedIndex;i++)
        System.out.print(arr[i]+" ");
    }

    public boolean searchNode(int data){
        for(int i=1;i<=lastUsedIndex;i++){
            if(arr[i]==data) return true;
        }
        return false;
    }

    public void deleteNode(int data){
        for(int i=1;i<=lastUsedIndex;i++){
            if(arr[i]==data){
                arr[i]=arr[lastUsedIndex--];
            }
        }
    }


    public static void main(String[] args) {
        BinaryTreeArrayClass binaryTreeArrayClass = new BinaryTreeArrayClass(10);
        binaryTreeArrayClass.insertNode(10);
        binaryTreeArrayClass.insertNode(11);
        binaryTreeArrayClass.insertNode(12);
        binaryTreeArrayClass.insertNode(13);
        binaryTreeArrayClass.insertNode(14);
        binaryTreeArrayClass.insertNode(15);
        binaryTreeArrayClass.insertNode(16);
        binaryTreeArrayClass.insertNode(17);
        binaryTreeArrayClass.insertNode(18);
        binaryTreeArrayClass.insertNode(19);
        binaryTreeArrayClass.preOrderTraversal(1);
        System.out.println();
        binaryTreeArrayClass.inOrderTraversal(1);
        System.out.println();
        binaryTreeArrayClass.postOrderTraversal(1);
        System.out.println();
        binaryTreeArrayClass.levelOrderTraversal();
        System.out.println();
        binaryTreeArrayClass.insertNode(20);
        System.out.println("20 is available : " + binaryTreeArrayClass.searchNode(20));
        System.out.println("15 is available : " + binaryTreeArrayClass.searchNode(15));

        binaryTreeArrayClass.deleteNode(15);
        binaryTreeArrayClass.levelOrderTraversal();
        System.out.println();
        binaryTreeArrayClass.deleteNode(18);
        binaryTreeArrayClass.levelOrderTraversal();
        System.out.println();

    }
}
