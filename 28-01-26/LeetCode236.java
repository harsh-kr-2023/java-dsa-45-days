import java.util.*;

public class LeetCode236 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        TreeNode p = root.left; // Node with value 5
        TreeNode q = root.left.right.right; // Node with value 4
        TreeNode lca = lowestCommonAncestor(root, p, q);
        System.out.println("Lowest Common Ancestor: " + lca.val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        System.out.println("left: " + (left != null ? left.val : "null"));
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        System.out.println("right: " + (right != null ? right.val : "null"));
        if (left != null && right != null) {
            return root;
        } else {
            return left != null ? left : right;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
