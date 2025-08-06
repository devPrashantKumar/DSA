package AZStriverPlaylist.BinarySearchTree.Problems;

public class BinarySearchTreeUtility {
    public static BinarySearchTreeNode<Integer> convertArrayToBst(Integer[] arr) {
        BinarySearchTreeNode<Integer> root = null;
        BinarySearchTreeNode<Integer> current = null;

        for (int i = 0; i < arr.length; i++) {
            current = root;
            BinarySearchTreeNode<Integer> newNode = new BinarySearchTreeNode<Integer>(arr[i]);
            if (i == 0) {
                root = newNode;
            } else {
                while (true) {
                    if (current.data > arr[i]) {
                        if (current.left != null) {
                            current = current.left;
                        } else {
                            current.left = newNode;
                            break;
                        }

                    } else {
                        if (current.right != null) {
                            current = current.right;
                        } else {
                            current.right = newNode;
                            break;
                        }
                    }
                }
            }

        }
        return root;
    }

    public static <T> void printBST(BinarySearchTreeNode<T> root) {
        if (root == null) {
            System.out.println("BST is Empty");
            return;
        }
        printBSTUtil(root); 
        System.out.println();
    }

    public static <T> void printBSTUtil(BinarySearchTreeNode<T> root) {
        if (root == null) {
            return;
        }
        printBSTUtil(root.left); 
        System.out.print(root.data+" ");
        printBSTUtil(root.right);  
    }
}
