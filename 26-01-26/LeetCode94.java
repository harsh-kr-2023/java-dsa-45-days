import java.util.*;

public class LeetCode94 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        List<Integer> result = inorderTraversal(root);
        System.out.println(result);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        // Using iterative approach with a stack
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                System.out.println("Pushing " + current.val);
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.println("Visiting and popping " + current.val);
            result.add(current.val);
            current = current.right;
        }
        return result;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
