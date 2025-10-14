package AZStriverPlaylist.Tree.Medium;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import AZStriverPlaylist.Tree.BinaryTreeNode;

public class DiameteOfBinaryTree {
    public static int diameterOfBinaryTree(BinaryTreeNode root) {
        if (Objects.isNull(root))
            return 0;
        int[] maxDiameter = new int[] { 0 };
        diameterOfBinaryTreeUtil(root, maxDiameter);
        return maxDiameter[0];
    }

    public static int diameterOfBinaryTreeUtil(BinaryTreeNode root, int[] maxDiameter) {
        if (Objects.isNull(root))
            return 0;
        int leftHeight = diameterOfBinaryTreeUtil(root.left, maxDiameter);
        int rightHeight = diameterOfBinaryTreeUtil(root.right, maxDiameter);
        maxDiameter[0] = (Math.max(maxDiameter[0], leftHeight + rightHeight));
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int diameterOfBinaryTreeApproach2(BinaryTreeNode root) {
        if (Objects.isNull(root))
            return 0;
        AtomicInteger maxDiameter = new AtomicInteger(0);
        diameterOfBinaryTreeUtilApproach2(root, maxDiameter);
        return maxDiameter.get();
    }

    public static int diameterOfBinaryTreeUtilApproach2(BinaryTreeNode root, AtomicInteger maxDiameter) {
        if (Objects.isNull(root))
            return 0;
        int leftHeight = diameterOfBinaryTreeUtilApproach2(root.left, maxDiameter);
        int rightHeight = diameterOfBinaryTreeUtilApproach2(root.right, maxDiameter);
        maxDiameter.getAndSet(Math.max(maxDiameter.get(), leftHeight + rightHeight));
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        BinaryTreeNode root1 = new BinaryTreeNode(
                1,
                new BinaryTreeNode(
                        2,
                        new BinaryTreeNode(4),
                        new BinaryTreeNode(5)),
                new BinaryTreeNode(3));

        System.out.println("diameter of binary tree : " + diameterOfBinaryTree(root1));
        System.out.println("diameter of binary tree : " + diameterOfBinaryTreeApproach2(root1));
        System.out.println("-----------------------------------------------------------------------------");

        BinaryTreeNode root2 = new BinaryTreeNode(1,new BinaryTreeNode(2),null);

        System.out.println("diameter of binary tree : " + diameterOfBinaryTree(root2));
        System.out.println("diameter of binary tree : " + diameterOfBinaryTreeApproach2(root2));
        System.out.println("-----------------------------------------------------------------------------");

    }
}
