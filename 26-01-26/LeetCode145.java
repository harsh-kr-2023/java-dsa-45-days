import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode145 {
    public static void main(String[] args) {
        Tree node = new Tree(1);
        node.left = new Tree(2);
        node.right = new Tree(3);
        node.left.left = new Tree(4);
        node.left.right = new Tree(5);
        List<Integer> result = postorderTraversal1(node);
        System.out.println(result);
    }

    public static List<Integer> postorderTraversal(Tree root) {
        // Using iterative approach with 2 stacks
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<Tree> stack1 = new Stack<>();
        Stack<Tree> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            Tree current = stack1.pop();
            stack2.push(current);
            if (current.left != null) {
                stack1.push(current.left);
            }
            if (current.right != null) {
                stack1.push(current.right);
            }
        }
        while (!stack2.isEmpty()) {
            result.add(stack2.pop().val);
        }
        return result;
    }

    // Using 1 stack
    public static List<Integer> postorderTraversal1(Tree root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<Tree> stack = new Stack<>();
        Tree current = root;
        Tree lastVisited = null;
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                Tree peekNode = stack.peek();
                if (peekNode.right != null && lastVisited != peekNode.right) {
                    current = peekNode.right;
                } else {
                    result.add(peekNode.val);
                    lastVisited = stack.pop();
                }
            }
        }
        return result;
    }

    public static class Tree {
        int val;
        Tree left;
        Tree right;

        Tree(int x) {
            val = x;
        }
    }
}
