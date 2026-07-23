package AZStriverPlaylist.Tree.GenericTree;

import java.util.ArrayList;

public class TreeClass {
    class TreeNode {
        int data;
        ArrayList<TreeNode> children;

        public TreeNode(int data){
            this.data = data;
            this.children = new ArrayList<>();
        }

        public TreeNode getChild(int index){
            return this.children.get(index);
        }

        public void addChild(int data){
            this.children.add(new TreeNode(data));
        }
    }

    TreeNode root;
    
    public TreeClass(){
        root = null;
    }

    public void createRoot(int data){
        this.root = new TreeNode(data);
    }

    public TreeNode getRoot(){
        return this.root;
    }

    public void printTree(){
        printTreeUtil(this.root, 0);
    }
    
    public void printTreeUtil(TreeNode root, int level){
        String indentation = " ".repeat(level);
        System.out.println(indentation+root.data);
        for(TreeNode node : root.children){
            printTreeUtil(node,level+1);
        }
    }

    public static void main(String[] args) {
        TreeClass tree = new TreeClass();

        // Create the root
        tree.createRoot(1);

        // Add children to the root
        TreeClass.TreeNode root = tree.getRoot();
        root.addChild(2);
        root.addChild(3);

        // Add children to one of the root's children
        TreeClass.TreeNode child1 = root.getChild(0); // Node with data 2
        child1.addChild(4);
        child1.addChild(5);

        // Add children to another root's child
        TreeClass.TreeNode child2 = root.getChild(1); // Node with data 3
        child2.addChild(6);

        // Print the tree
        tree.printTree();
    }
}