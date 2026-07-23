package AZStriverPlaylist.Tree.GenericTree;

import java.util.ArrayList;

public class TreeNodeClass {
    int data;
    ArrayList<TreeNodeClass> children;

    public TreeNodeClass(int data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    public void addChild(TreeNodeClass child) {
        this.children.add(child);
    }

    public void printTree(int level){
        String indentation = " ".repeat(level);
        System.out.println(indentation+data);
        for(TreeNodeClass node : children){
            node.printTree(level+1);
        }
    }

    public static void main(String[] args) {
        TreeNodeClass node1 = new TreeNodeClass(10);
        TreeNodeClass node2 = new TreeNodeClass(11);
        TreeNodeClass node3 = new TreeNodeClass(12);
        TreeNodeClass node4 = new TreeNodeClass(13);
        TreeNodeClass node5 = new TreeNodeClass(14);
        TreeNodeClass node6 = new TreeNodeClass(15);

        TreeNodeClass root = node1;
        
        node1.addChild(node2);
        node1.addChild(node3);
        node2.addChild(node4);
        node3.addChild(node5);
        node5.addChild(node6);
        root.printTree(0);
    }
}