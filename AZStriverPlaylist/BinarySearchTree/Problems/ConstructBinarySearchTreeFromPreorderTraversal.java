package AZStriverPlaylist.BinarySearchTree.Problems;

public class ConstructBinarySearchTreeFromPreorderTraversal {
    public BinarySearchTreeNode<Integer> bstFromPreorder(int[] preorder) {
        return bstFromPreorderUtil(preorder,0,preorder.length-1);
    }

    public BinarySearchTreeNode<Integer> bstFromPreorderUtil(int[] preorder, int start, int end) {
        if(end>start) return null;
        BinarySearchTreeNode<Integer> node = new BinarySearchTreeNode<Integer>(preorder[start]);
        int i=start+1;
        for(;i<=end;i++){
            if(preorder[i]>preorder[start]) break;
        }
        node.left = bstFromPreorderUtil(preorder,start+1,i-1);
        node.right = bstFromPreorderUtil(preorder,i,end);
        return node;
    }
}
