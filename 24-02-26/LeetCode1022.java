public class LeetCode1022 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        System.out.println(sumRootToLeaf(root));
    }
    public static int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }
    private static int dfs(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        sum = sum * 2 + node.val;
        if (node.left == null && node.right == null) {
            return sum;
        }
        return dfs(node.left, sum) + dfs(node.right, sum);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}