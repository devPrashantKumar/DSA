package AZStriverPlaylist.BinarySearchTree.Problems;

public class FindKthSmallestAndLargestInBST {
    public static Integer kthSmallest(BinarySearchTreeNode<Integer> root, int k){
        return kthSmallestUtil(root, new int[]{k});
    }

    public static Integer kthSmallestUtil(BinarySearchTreeNode<Integer> root, int[] k){
        if(root==null) return -1;
        int left = kthSmallestUtil(root.left, k);
        if(k[0]==0) return left;
        k[0]--;
        if(k[0]==0) return root.data;
        return kthSmallestUtil(root.right, k);
    }

    public static Integer kthLargest(BinarySearchTreeNode<Integer> root, int k){
        return kthLargestUtil(root, new int[]{k});
    }

    public static Integer kthLargestUtil(BinarySearchTreeNode<Integer> root, int[] k){
        if(root==null) return -1;
        int right = kthLargestUtil(root.right, k);
        if(k[0]==0) return right;
        k[0]--;
        if(k[0]==0) return root.data;
        return kthLargestUtil(root.left, k);
    }

    public static void main(String[] args) {
        Integer[] arr1 = { 1, 2, 3, 5, 9, 7 };
        BinarySearchTreeNode<Integer> root = BinarySearchTreeUtility.convertArrayToBst(arr1);
        BinarySearchTreeUtility.printBST(root);
        System.out.println("----------------------------------------------------------");
        System.out.println("kth Smallest in BST : "+FindKthSmallestAndLargestInBST.kthSmallest(root,4));
        System.out.println("kth Largest in BST : "+FindKthSmallestAndLargestInBST.kthLargest(root,4));
        System.out.println("----------------------------------------------------------");
        System.out.println("kth Smallest in BST : "+FindKthSmallestAndLargestInBST.kthSmallest(root,8));
        System.out.println("kth Largest in BST : "+FindKthSmallestAndLargestInBST.kthLargest(root,8));
        System.out.println("----------------------------------------------------------");
        System.out.println("kth Smallest in BST : "+FindKthSmallestAndLargestInBST.kthSmallest(root,3));
        System.out.println("kth Largest in BST : "+FindKthSmallestAndLargestInBST.kthLargest(root,2));
    }
}
