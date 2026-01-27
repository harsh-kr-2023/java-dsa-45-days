import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class TreeTraversal {

    static class Pair {
        TreeNode node;
        int state;

        Pair(TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        List<List<Integer>> result = treeTraversal(root);
        System.out.println("Preorder: " + result.get(0));
        System.out.println("Inorder: " + result.get(1));
        System.out.println("Postorder: " + result.get(2));
    }

    public static List<List<Integer>> treeTraversal(TreeNode root) {
        // All traversals combined: Preorder, Inorder, Postorder
        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));

        while (!stack.isEmpty()) {
            Pair top = stack.peek();

            if (top.state == 1) {
                preorder.add(top.node.val);
                top.state++;
                if (top.node.left != null) {
                    stack.push(new Pair(top.node.left, 1));
                }
            } else if (top.state == 2) {
                inorder.add(top.node.val);
                top.state++;
                if (top.node.right != null) {
                    stack.push(new Pair(top.node.right, 1));
                }
            } else {
                postorder.add(top.node.val);
                stack.pop();
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(preorder);
        result.add(inorder);
        result.add(postorder);

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
