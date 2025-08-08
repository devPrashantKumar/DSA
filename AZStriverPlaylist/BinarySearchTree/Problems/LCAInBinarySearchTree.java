package AZStriverPlaylist.BinarySearchTree.Problems;

public class LCAInBinarySearchTree {
    public static <T> BinarySearchTreeNode<Integer> lca(BinarySearchTreeNode<Integer> root,
            BinarySearchTreeNode<Integer> p, BinarySearchTreeNode<Integer> q) {
        if (root == null || p == null || q == null)
            return root;
        while (root != null) {
            if (root.data < p.data && root.data < q.data)
                root = root.right;
            else if (root.data > p.data && root.data > q.data)
                root = root.left;
            else {
                return root;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] arr1 = { 2, 4, 1,5, 9, 3, 7 };
        BinarySearchTreeNode<Integer> root = BinarySearchTreeUtility.convertArrayToBst(arr1);
        BinarySearchTreeUtility.printBST(root);
        System.out.println("----------------------------------------------------------");
        System.out.println("LCA in  BST is : "+LCAInBinarySearchTree.lca(root, root.left, root.right).data);
        System.out.println("LCA in  BST is : "+LCAInBinarySearchTree.lca(root, root.right.right, root.right).data);
        System.out.println("LCA in  BST is : "+LCAInBinarySearchTree.lca(root, root.right.left, root.right.right.right).data);
        System.out.println("----------------------------------------------------------");
    }
}
