package AZStriverPlaylist.Tree.Medium;

import java.util.Objects;

import AZStriverPlaylist.Tree.BinaryTreeNode;

public class CheckIfTwoTreesAreIdenticalOrNot {
    /*
     * Time COmplexity : O(n)
     * Space Complexity : O(h) h->height of tree
     */
    public static boolean isSameTree(BinaryTreeNode p, BinaryTreeNode q) {
        if(Objects.isNull(p) && Objects.isNull(q)) return true;
        if(Objects.isNull(p)!=Objects.isNull(q)) return false;
        if(p.data!=q.data) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);         
    }

    public static void main(String[] args) {
        BinaryTreeNode root11 = new BinaryTreeNode(1,new BinaryTreeNode(2),new BinaryTreeNode(3));
        BinaryTreeNode root12 = new BinaryTreeNode(1,new BinaryTreeNode(2),new BinaryTreeNode(3));
        System.out.println("Are Trees Identical "+isSameTree(root11, root12));
        System.out.println("----------------------------------------------------------------------------");

        BinaryTreeNode root21 = new BinaryTreeNode(1,new BinaryTreeNode(2),null);
        BinaryTreeNode root22 = new BinaryTreeNode(1,null,new BinaryTreeNode(2));
        System.out.println("Are Trees Identical "+isSameTree(root21, root22));
        System.out.println("----------------------------------------------------------------------------");

        BinaryTreeNode root31 = new BinaryTreeNode(1,new BinaryTreeNode(2),new BinaryTreeNode(1));
        BinaryTreeNode root32 = new BinaryTreeNode(1,new BinaryTreeNode(1),new BinaryTreeNode(2));
        System.out.println("Are Trees Identical "+isSameTree(root31, root32));
    }
}
