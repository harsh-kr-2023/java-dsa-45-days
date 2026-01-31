import javax.swing.tree.TreeNode;

public class LeetCode99 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        recoverTree(root);
        System.out.println(root.val);
    }
    public static void recoverTree(TreeNode root) {
        // Brute force approach: Inorder traversal to get the values, sort them, and then reassign them to the tree nodes.
        List<Integer> values = new ArrayList<>();
        inorderTraversal(root, values);
        Collections.sort(values);
        assignValues(root, values, new int[]{0});
        return;
    }
    private static void inorderTraversal(TreeNode node, List<Integer> values) {
        if (node == null) return;
        inorderTraversal(node.left, values);
        values.add(node.val);
        inorderTraversal(node.right, values);
    }
    private static void assignValues(TreeNode node, List<Integer> values, int[] index) {
        if (node == null) return;
        assignValues(node.left, values, index);
        node.val = values.get(index[0]);
        index[0]++;
        assignValues(node.right, values, index);
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
