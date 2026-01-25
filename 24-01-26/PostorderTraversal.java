import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        printTree(root);
        System.out.println(postorderTraversal(root));
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorderHelper(root, list);
        return list;
    }

    private static void postorderHelper(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        postorderHelper(node.left, list);
        postorderHelper(node.right, list);
        list.add(node.val);
    }

    public static void printTree(TreeNode root) {
        printTreeHelper(root, 0);
    }

    private static void printTreeHelper(TreeNode node, int level) {
        if (node == null)
            return;

        // print right subtree first
        printTreeHelper(node.right, level + 1);

        // indentation
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        System.out.println(node.val);

        // print left subtree
        printTreeHelper(node.left, level + 1);
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
