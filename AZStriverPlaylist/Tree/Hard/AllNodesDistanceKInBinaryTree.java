package AZStriverPlaylist.Tree.Hard;

import java.util.ArrayList;
import java.util.List;

import AZStriverPlaylist.Tree.BinaryTreeNode;

public class AllNodesDistanceKInBinaryTree {
    public List<Integer> distanceK(BinaryTreeNode root, BinaryTreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        distanceKUtil(root, target, k, false, result);
        return result;
    }

    public int distanceKUtil(BinaryTreeNode root, BinaryTreeNode target, int k, boolean found, List<Integer> result) {
        if(k<0 || root==null) return k;
        if(k==0 && (found || root==target)) {
            result.add(root.data);
            return -1; 
        }
        if(found || root==target){
            distanceKUtil(root.left, target, k-1,true, result);
            distanceKUtil(root.right, target, k-1,true, result);
        }else{
            distanceKUtil(root.left, target, k, false, result);
            distanceKUtil(root.right, target, k,false, result);
        }
        return k-1;
    }
}
