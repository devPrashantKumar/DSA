package AZStriverPlaylist.Tree.Hard;

import AZStriverPlaylist.Tree.BinaryTreeNode;

public class CheckForChildrenSumProperty {
    /*
     * Time Complexity : O(n)
     * Space Complexity : O(h), h is height of tree
     */
    public static boolean checkChildrenSum(BinaryTreeNode root) { 
       if(root==null) return true;
       if(root.left==null && root.right==null) return true;
       int left = (root.left!=null) ? root.left.data : 0;
       int right = (root.right!=null) ? root.right.data : 0;
       if(root.data!=left+right) return false;
       return (checkChildrenSum(root.left) && checkChildrenSum(root.right));
    }

    public static void main(String[] args) {
        BinaryTreeNode root1 = new BinaryTreeNode(
                1,
                new BinaryTreeNode(
                        4,
                        new BinaryTreeNode(5),
                        null),
                new BinaryTreeNode(3));
        System.out.println(checkChildrenSum(root1));

        System.out.println("-------------------------------------------------");

        BinaryTreeNode root2 = new BinaryTreeNode(
                10,
                new BinaryTreeNode(
                    4,
                    new BinaryTreeNode(1),
                    new BinaryTreeNode(3)
                ),
                new BinaryTreeNode(
                    6,
                    new BinaryTreeNode(2),
                    new BinaryTreeNode(4)
                )
            );
        System.out.println(checkChildrenSum(root2));

        System.out.println("-------------------------------------------------");
        
    }

}
