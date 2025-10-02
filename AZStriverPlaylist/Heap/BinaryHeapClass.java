package AZStriverPlaylist.Heap;

// video url : https://youtu.be/NFiYQGyL8rg?si=VMDO6B9va94Cox7N

/*
 * buildHeap and Heapify both are unstable
 */
public class BinaryHeapClass {
    private int[] arr;
    private int sizeOfTree;

    public BinaryHeapClass(int size, int[] input) {
        if (input.length > size) {
            throw new IllegalArgumentException("Input size exceeds the heap capacity.");
        }
        this.arr = new int[size];
        for(int i=0;i<input.length;i++){
            arr[i]=input[i];
        }
        this.sizeOfTree = input.length;
        if(this.sizeOfTree>1){
            int lastParent  = (this.sizeOfTree/2)-1;
            for(int i=lastParent;i>=0;i--){
                heapify(i);
            }
        }
    }

    public boolean isEmpty() {
        return sizeOfTree == 0;
    }

    public int parent(int index){
        return (index-1)/2;
    }

    public int leftChild(int index){
        return (2*index)+1;
    }

    public int rightChild(int index){
        return (2*index)+2;
    }

    public int sizeOfBH() {
        return sizeOfTree;
    }

    public Integer peek() {
        if (isEmpty())
            return null;
        return arr[0];
    }

    public void insertElementInHeap(int data) {
        if(sizeOfTree==arr.length){
            throw new RuntimeException("Heap overflow: Cannot insert more elements.");
        }
        arr[sizeOfTree++] = data;
        int index = sizeOfTree-1;
        while(index!=0 && arr[parent(index)]>arr[index]){
            int temp = arr[parent(index)];
            arr[parent(index)] = arr[index];
            arr[index] = temp;
            index = parent(index);
        }
    }

    public void heapify(int index) {
        int leftChild = leftChild(index);
        int rightChild = rightChild(index);
        int minIndex = index;

        if (leftChild < sizeOfTree && arr[leftChild] < arr[minIndex]) {
            minIndex = leftChild;
        }

        if (rightChild < sizeOfTree && arr[rightChild] < arr[minIndex]) {
            minIndex = rightChild;
        }

        if (minIndex != index) {
            int temp = arr[minIndex];
            arr[minIndex] = arr[index];
            arr[index] = temp;
            heapify(minIndex);
        }
    }

    public Integer removeMinElement() {
        if(isEmpty()) return null;
        int element  = arr[0];
        arr[0]=arr[--sizeOfTree];
        if(sizeOfTree!=0){
            heapify(0);
        }
        return element;
    }

    public void printLevelOrderTraversal() {
        for (int i = 0; i < sizeOfTree; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void printPreOrderTraversal(int index) {
        if (index >= sizeOfTree)
            return;
        System.out.print(arr[index] + " ");
        printPreOrderTraversal((2 * index)+1);
        printPreOrderTraversal((2 * index) + 2);
    }

    public void printPostOrderTraversal(int index) {
        if (index >= sizeOfTree)
            return;
        printPostOrderTraversal((2 * index)+1);
        printPostOrderTraversal((2 * index) + 2);
        System.out.print(arr[index] + " ");
    }

    public void printInOrderTraversal(int index) {
        if (index >= sizeOfTree)
            return;
        printInOrderTraversal((2 * index)+1);
        System.out.print(arr[index] + " ");
        printInOrderTraversal((2 * index) + 2);
    }

    public void deleteBH(){
        this.arr = null;
        this.sizeOfTree=0;
    }

    public static void main(String[] args) {
        BinaryHeapClass bh = new BinaryHeapClass(10, new int[]{25,14});
        bh.insertElementInHeap(25);
        bh.insertElementInHeap(14);
        bh.insertElementInHeap(3);
        bh.insertElementInHeap(18);
        bh.insertElementInHeap(10);
        bh.printLevelOrderTraversal();

        System.out.println(bh.removeMinElement());
        bh.printLevelOrderTraversal();

        System.out.println(bh.removeMinElement());
        bh.printLevelOrderTraversal();

        System.out.println(bh.removeMinElement());
        bh.printLevelOrderTraversal();

        System.out.println(bh.removeMinElement());
        bh.printLevelOrderTraversal();
        
        System.out.println(bh.removeMinElement());

    }
}
