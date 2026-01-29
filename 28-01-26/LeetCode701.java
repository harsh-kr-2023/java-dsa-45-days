public class LeetCode701 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        int val = 5;
        TreeNode newRoot = insertIntoBST(root, val);
    }
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode current = root;
        while (true) {
            if (current.val < val) {
                if (current.right == null) {
                    current.right = new TreeNode(val);
                    break;
                } else {
                    current = current.right;
                }
            } else {
                if (current.left == null) {
                    current.left = new TreeNode(val);
                    break;
                } else {
                    current = current.left;
                }
            }
        }
        return root;
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
