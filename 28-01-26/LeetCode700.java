import javax.swing.tree.TreeNode;

public class LeetCode700 {
    public static void main(String[] args) {
        TreeNode root = 8;
        root.left = 5;
        root.right = 12;
        root.left.left = 4;
        root.left.right = 7;
        root.right.left = 10;
        root.right.right = 14;
        int val = 10;
        TreeNode result = searchBST(root, val);
        System.out.println(result);
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
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
