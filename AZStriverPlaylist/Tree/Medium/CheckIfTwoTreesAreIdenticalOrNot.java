package AZStriverPlaylist.Tree.Medium;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

import AZStriverPlaylist.Tree.BinaryTreeNode;

public class CheckIfTwoTreesAreIdenticalOrNot {
    /*
     * Time COmplexity : O(n)
     * Space Complexity : O(h) h->height of tree
     */
    public static boolean isSameTree(BinaryTreeNode p, BinaryTreeNode q) {
        if (Objects.isNull(p) && Objects.isNull(q))
            return true;
        if (Objects.isNull(p) != Objects.isNull(q))
            return false;
        if (p.data != q.data)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /*
     * Time COmplexity : O(n)
     * Space Complexity : O(n)
     */
    public static boolean isSameTreeUsingQueue(BinaryTreeNode p, BinaryTreeNode q) {
        Queue<BinaryTreeNode> queue1 = new LinkedList<>();
        Queue<BinaryTreeNode> queue2 = new LinkedList<>();
        if (p == null || q == null)
            return p == q;
        queue1.offer(p);
        queue2.offer(q);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            BinaryTreeNode node1 = queue1.poll();
            BinaryTreeNode node2 = queue2.poll();
            if (Objects.isNull(node1) && Objects.isNull(node2))
                continue;
            if (Objects.isNull(node1) != Objects.isNull(node2))
                return false;
            if (node1.data != node2.data)
                return false;

            queue1.offer(node1.left);
            queue1.offer(node1.right);
            queue2.offer(node2.left);
            queue2.offer(node2.right);

        }
        return true;
    }

    public static void main(String[] args) {
        BinaryTreeNode root11 = new BinaryTreeNode(1, new BinaryTreeNode(2), new BinaryTreeNode(3));
        BinaryTreeNode root12 = new BinaryTreeNode(1, new BinaryTreeNode(2), new BinaryTreeNode(3));
        System.out.println("Are Trees Identical " + isSameTree(root11, root12));
        System.out.println("Are Trees Identical " + isSameTreeUsingQueue(root11, root12));

        System.out.println("----------------------------------------------------------------------------");

        BinaryTreeNode root21 = new BinaryTreeNode(1, new BinaryTreeNode(2), null);
        BinaryTreeNode root22 = new BinaryTreeNode(1, null, new BinaryTreeNode(2));
        System.out.println("Are Trees Identical " + isSameTree(root21, root22));
        System.out.println("Are Trees Identical " + isSameTreeUsingQueue(root21, root22));

        System.out.println("----------------------------------------------------------------------------");

        BinaryTreeNode root31 = new BinaryTreeNode(1, new BinaryTreeNode(2), new BinaryTreeNode(1));
        BinaryTreeNode root32 = new BinaryTreeNode(1, new BinaryTreeNode(1), new BinaryTreeNode(2));
        System.out.println("Are Trees Identical " + isSameTree(root31, root32));
        System.out.println("Are Trees Identical " + isSameTreeUsingQueue(root31, root32));

    }
}
