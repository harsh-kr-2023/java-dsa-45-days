public class LeetCode1008 {
    public static void main(String[] args) {
        int[] preorder = { 8, 5, 1, 7, 10, 12 };
        TreeNode root = bstFromPreorder(preorder);
        System.out.println(root);
    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        int i = 0;
        return build(preorder, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static TreeNode build(int[] preorder, long min, long max) {
        if (i == preorder.length)
            return null;

        int val = preorder[i];
        if (val <= min || val >= max)
            return null;

        i++;
        TreeNode root = new TreeNode(val);

        root.left = build(preorder, min, val);
        root.right = build(preorder, val, max);

        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
