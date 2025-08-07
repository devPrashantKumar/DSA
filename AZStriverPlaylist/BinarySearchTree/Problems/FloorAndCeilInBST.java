package AZStriverPlaylist.BinarySearchTree.Problems;

public class FloorAndCeilInBST {
    public static Integer floorInBST(BinarySearchTreeNode<Integer> root, int key) {
         int floor= -1;
        while(root!=null){
            if(root.data<=key){
                floor = root.data;
                root = root.right;
            }else{
                root = root.left;
            }
        }
        return floor;
    }

    public static Integer ceilInBST(BinarySearchTreeNode<Integer> root, int key) {
        int ceil= -1;
        while(root!=null){
            if(root.data>=key){
                ceil = root.data;
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return ceil;       
    }

    public static void main(String[] args) {
        Integer[] arr1 = { 1, 2, 3, 5, 9, 7 };
        BinarySearchTreeNode<Integer> root = BinarySearchTreeUtility.convertArrayToBst(arr1);
        BinarySearchTreeUtility.printBST(root);
        System.out.println("----------------------------------------------------------");
        System.out.println("Floor in BST : "+FloorAndCeilInBST.floorInBST(root,4));
        System.out.println("Ceil in BST : "+FloorAndCeilInBST.ceilInBST(root,4));
        System.out.println("----------------------------------------------------------");
        System.out.println("Floor in BST : "+FloorAndCeilInBST.floorInBST(root,8));
        System.out.println("Ceil in BST : "+FloorAndCeilInBST.ceilInBST(root,8));
        System.out.println("----------------------------------------------------------");
        System.out.println("Floor in BST : "+FloorAndCeilInBST.floorInBST(root,3));
        System.out.println("Ceil in BST : "+FloorAndCeilInBST.ceilInBST(root,2));
    }
}
