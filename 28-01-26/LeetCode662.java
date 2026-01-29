import java.util.LinkedList;
import java.util.Queue;

public class LeetCode662 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.right.right = new TreeNode(3);
        root.left.left.left = new TreeNode(6);
        root.right.right.left = new TreeNode(7);
        System.out.println(widthOfBinaryTree(root));
    }

    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // use 0-based index for the position of each node and use long to avoid
        // overflow and answer = right - left + 1
        int maxWidth = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> posQueue = new LinkedList<>();
        nodeQueue.offer(root);
        posQueue.offer(0);
        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            int left = 0, right = 0;
            for (int i = 0; i < size; i++) {
                TreeNode currNode = nodeQueue.poll();
                int currPos = posQueue.poll();
                if (i == 0) {
                    left = currPos;
                }
                if (i == size - 1) {
                    right = currPos;
                }
                if (currNode.left != null) {
                    nodeQueue.offer(currNode.left);
                    posQueue.offer(2 * currPos + 1);
                }
                if (currNode.right != null) {
                    nodeQueue.offer(currNode.right);
                    posQueue.offer(2 * currPos + 2);
                }
            }
            maxWidth = Math.max(maxWidth, right - left + 1);
        }
        return maxWidth;
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
