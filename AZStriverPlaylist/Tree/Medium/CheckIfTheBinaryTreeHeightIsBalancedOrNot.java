package AZStriverPlaylist.Tree.Medium;

import java.util.Objects;

import AZStriverPlaylist.Tree.BinaryTreeNode;

public class CheckIfTheBinaryTreeHeightIsBalancedOrNot {
    static class BalanceStatus {
        boolean balanced;
        int height;

        BalanceStatus(boolean balanced, int height) {
            this.balanced = balanced;
            this.height = height;
        }
    }

    /*
     * TIme Complexity : O(n)
     * Space Complexity : O(h)
     * Balanced tree: h = log(n) → space = O(log n)
     * Skewed tree: h = n → space = O(n)
     */
    public static boolean isBalanced(BinaryTreeNode root) {
        return isBalancedUtil(root).balanced;
    }

    public static BalanceStatus isBalancedUtil(BinaryTreeNode root) {
        if (Objects.isNull(root))
            return new BalanceStatus(true, 0);
        BalanceStatus leftHeight = isBalancedUtil(root.left);
        if (!leftHeight.balanced)
            return new BalanceStatus(false, 0);
        BalanceStatus rightHeight = isBalancedUtil(root.right);
        if (!rightHeight.balanced)
            return new BalanceStatus(false, 0);
        if (Math.abs(leftHeight.height - rightHeight.height) > 1)
            return new BalanceStatus(false, 0);
        return new BalanceStatus(true, Math.max(leftHeight.height, rightHeight.height) + 1);
    }


    /*
     * TIme Complexity : O(n)
     * Space Complexity : O(h)
     * Balanced tree: h = log(n) → space = O(log n)
     * Skewed tree: h = n → space = O(n)
     */
    public static boolean isBalancedApproch2(BinaryTreeNode root) {
        return isBalancedApproch2Util(root) != -1;
    }

    public static int isBalancedApproch2Util(BinaryTreeNode root) {
        if (Objects.isNull(root))
            return 0;
        int leftHeight = isBalancedApproch2Util(root.left);
        if (leftHeight == -1)
            return -1;
        int rightHeight = isBalancedApproch2Util(root.right);
        if (rightHeight == -1)
            return -1;
        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        BinaryTreeNode root1 = new BinaryTreeNode(
                3,
                new BinaryTreeNode(9),
                new BinaryTreeNode(
                        20,
                        new BinaryTreeNode(15),
                        new BinaryTreeNode(7)));
        System.out.println(isBalanced(root1));
        System.out.println(isBalanced(root1));

        System.out.println("-------------------------------------------------");

        BinaryTreeNode root2 = new BinaryTreeNode(
                1,
                new BinaryTreeNode(
                        2,
                        new BinaryTreeNode(
                                3,
                                new BinaryTreeNode(4),
                                new BinaryTreeNode(4)),
                        new BinaryTreeNode(3)),
                new BinaryTreeNode(2));
        System.out.println(isBalanced(root2));
        System.out.println(isBalanced(root2));

        System.out.println("-------------------------------------------------");

        BinaryTreeNode root3 = null;
        System.out.println(isBalanced(root3));
        System.out.println(isBalanced(root3));

        System.out.println("-------------------------------------------------");
    }
}
