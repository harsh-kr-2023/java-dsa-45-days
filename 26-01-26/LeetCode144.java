import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode144 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        List<Integer> result = preorderTraversal(root);
        System.out.println(result);
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        // Using iterative approach with a stack
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            System.out.println("Visiting node: " + current.val);
            result.add(current.val);
            if (current.right != null) {
                System.out.println("Pushing right child: " + current.right.val);
                stack.push(current.right);
            }
            if (current.left != null) {
                System.out.println("Pushing left child: " + current.left.val);
                stack.push(current.left);
            }
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
