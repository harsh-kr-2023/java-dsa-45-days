public class CeilinBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);
        int target = 1;
        Integer ceilValue = findCeil(root, target);
        System.out.println(ceilValue);
    }
    public static Integer findCeil(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        Integer ceil = null;
        TreeNode current = root;
        while (current != null) {
            if (current.val == target) {
                return current.val;
            } else if (current.val < target) {
                current = current.right;
            } else {
                ceil = current.val;
                current = current.left;
            }
        }
        return ceil;
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
