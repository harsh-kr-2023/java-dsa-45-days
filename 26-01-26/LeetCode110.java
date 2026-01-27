public class LeetCode110 {
    public static void main(String[] args) {
        Tree node = new Tree(1);
        node.left = new Tree(2);
        node.right = new Tree(3);
        node.left.left = new Tree(4);
        node.left.right = new Tree(5);
        System.out.println(isBalanced(node));
    }

    public static boolean isBalanced(Tree root) {
        return checkBalance(root) != -1;
    }

    public static int checkBalance(Tree root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = checkBalance(root.left);
        int rightHeight = checkBalance(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
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