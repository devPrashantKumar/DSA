package AZStriverPlaylist.Tree;

import java.util.Stack;

public class BinaryTreeTraversal {

    public static void iterativePreOrderTraversal(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode node = root;
        while (node != null) {
            System.out.print(node.data + " ");
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null) {
                node = node.left;
            } else {
                node = stack.isEmpty() ? null : stack.pop();
            }
        }
        System.out.println();
    }

    public static void iterativeInorderTraversal(BinaryTreeNode root) {
        BinaryTreeNode node = root;
        Stack<BinaryTreeNode> stack = new Stack<>();
        boolean visited = false;
        while (node != null) {
            if (visited != true && node.left != null) {
                stack.push(node);
                node = node.left;
            } else {
                System.out.print(node.data + " ");
                if (node.right != null) {
                    node = node.right;
                    visited = false;
                } else {
                    node = stack.isEmpty() ? null : stack.pop();
                    visited = true;
                }
            }
        }
        System.out.println();
    }

    /*
     * solution: https://www.youtube.com/watch?v=xEPe6aWlRd0
     */
    public static void iterativePostOrderTraversal(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode node = root;
        BinaryTreeNode lastProcessed = null;
        boolean visited = false;
        while (node != null || !stack.isEmpty()) {
            if (node!=null && visited == false) {
                stack.push(node);
                node = node.left;
            } else {
                BinaryTreeNode top = stack.peek();
                if (top.right != null && top.right != lastProcessed) {
                    node = top.right;
                    visited = false;
                } else {
                    stack.pop();
                    lastProcessed = top;
                    System.out.print(top.data + " ");
                    visited = true;
                }
            }
        }
        System.out.println();
    }

    /*
     * PostOrder Traversal can we represented as a reverse of modified preOrderTraversal
     * left->right->root = reverse(root->right->left)
     */
    public static void iterativePostOrderTraversalUsing2Stack(BinaryTreeNode root){
        BinaryTreeNode node = root;
        Stack<BinaryTreeNode> stack = new Stack<>();
        Stack<BinaryTreeNode> resultStack = new Stack<>();
        while(node!=null){
            resultStack.push(node);
            if(node.left!=null){
                stack.push(node.left);
            }
            if(node.right!=null){
                node = node.right;
            }
            else{
                node = stack.isEmpty() ? null : stack.pop();
            }
        }

        while(!resultStack.isEmpty()){
            System.out.print(resultStack.pop().data+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BinaryTreeNode root1 = new BinaryTreeNode(1);
        root1.right = new BinaryTreeNode(2);
        root1.right.left = new BinaryTreeNode(3);

        iterativeInorderTraversal(root1);
        iterativePreOrderTraversal(root1);
        iterativePostOrderTraversal(root1);
        iterativePostOrderTraversalUsing2Stack(root1);
        System.out.println("------------------------------------------------------");

        BinaryTreeNode root2 = new BinaryTreeNode(1);
        root2.left = new BinaryTreeNode(2);
        root2.left.left = new BinaryTreeNode(4);
        root2.left.right = new BinaryTreeNode(5);
        root2.left.right.left = new BinaryTreeNode(6);
        root2.left.right.right = new BinaryTreeNode(7);
        root2.right = new BinaryTreeNode(3);
        root2.right.right = new BinaryTreeNode(8);
        root2.right.right.left = new BinaryTreeNode(9);

        iterativeInorderTraversal(root2);
        iterativePreOrderTraversal(root2);
        iterativePostOrderTraversal(root2);
        iterativePostOrderTraversalUsing2Stack(root2);
        System.out.println("------------------------------------------------------");

        BinaryTreeNode root3 = null;
        iterativeInorderTraversal(root3);
        iterativePreOrderTraversal(root3);
        iterativePostOrderTraversal(root3);
        iterativePostOrderTraversalUsing2Stack(root3);
        System.out.println("------------------------------------------------------");

        BinaryTreeNode root4 = new BinaryTreeNode(1);
        iterativeInorderTraversal(root4);
        iterativePreOrderTraversal(root4);
        iterativePostOrderTraversal(root4);
        iterativePostOrderTraversalUsing2Stack(root4);
        System.out.println("------------------------------------------------------");
    }
}
