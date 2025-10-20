package AZStriverPlaylist.Tree.Hard;

import AZStriverPlaylist.Tree.BinaryTreeNode;

public class SatisfyChildrenSumProperty {

    public static void increment(BinaryTreeNode root, int remainder){
        if(root.left!=null){
            root.left.data+=remainder;
            increment(root.left,remainder);
        }else if(root.right!=null){
            root.right.data+=remainder;
            increment(root.right,remainder);
        }
    }
    /*
     * Time Complexity : O(n^2)
     * Space Complexity : O(h), h is height of tree
     */
    public static void satisfyChildrenSumUsingDFS(BinaryTreeNode root) { 
       if(root==null || (root.left==null && root.right==null)) return;
       satisfyChildrenSumUsingDFS(root.left);
       satisfyChildrenSumUsingDFS(root.right);

       int remainder=0;
       int left = (root.left!=null) ? root.left.data : 0;
       int right = (root.right!=null) ? root.right.data : 0;
       remainder = root.data-(left+right);
       if(remainder<=0){
        root.data = left+right;
       }
       else{
        increment(root,remainder);
       }
    }

    /*
     * Time Complexity : O(n)
     * Space Complexity : O(h), h is height of tree
     */
    public static void satisfyChildrenSumOptimised(BinaryTreeNode root) { 
       if(root==null) return;
       int remainder=0;
       if(root.left==null && root.right==null) return;
       int left = (root.left!=null) ? root.left.data : 0;
       int right = (root.right!=null) ? root.right.data : 0;
       if(root.data<left+right){
        root.data = left+right;
       }
       if(root.data>=left+right) remainder = root.data-(left+right);
       if(root.left!=null) root.left.data += remainder;
       else root.right.data += remainder;

       satisfyChildrenSumOptimised(root.left);
       satisfyChildrenSumOptimised(root.right);
       
       left = (root.left!=null) ? root.left.data : 0;
       right = (root.right!=null) ? root.right.data : 0;
       root.data = left+right;
    }

    public static void main(String[] args) {
        BinaryTreeNode root1 = new BinaryTreeNode(
                1,
                new BinaryTreeNode(
                        4,
                        new BinaryTreeNode(5),
                        null),
                new BinaryTreeNode(3));
        System.out.println(CheckForChildrenSumProperty.checkChildrenSum(root1));
        satisfyChildrenSumOptimised(root1);
        //satisfyChildrenSumUsingDFS(root1);
        System.out.println(CheckForChildrenSumProperty.checkChildrenSum(root1));

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
        System.out.println(CheckForChildrenSumProperty.checkChildrenSum(root2));
        satisfyChildrenSumOptimised(root2);
        //satisfyChildrenSumUsingDFS(root2);
        System.out.println(CheckForChildrenSumProperty.checkChildrenSum(root2));
        System.out.println("-------------------------------------------------");
        
    }

}
