public class LeetCode124 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        System.out.println(maxPathSum(root));
    }
    public static int maxPathSum(TreeNode root) {
        // Go to eachnode and calculate the max path sum including that node
        int[] maxSum = new int[]{Integer.MIN_VALUE};
        calculateMaxSum(root, maxSum);
        return maxSum[0];
    }
    private static int calculateMaxSum(TreeNode node, int[] maxSum) {
        if (node == null) {
            return 0;
        }
        int leftMax = Math.max(0, calculateMaxSum(node.left, maxSum));
        int rightMax = Math.max(0, calculateMaxSum(node.right, maxSum));
        maxSum[0] = Math.max(maxSum[0], leftMax + rightMax + node.val);
        return Math.max(leftMax, rightMax) + node.val;
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
