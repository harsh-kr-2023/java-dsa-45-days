import java.util.List;
import javax.swing.tree.TreeNode;
import java.util.ArrayList;

public class LeetCode230 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        int k = 3;
        int result = kthSmallest(root, k);
        System.out.println(result);
    }
    public static int kthSmallest(TreeNode root, int k) {
        // In-order traversal to find the k-th smallest element
        List<Integer> elements = new ArrayList<>();
        inOrderTraversal(root, elements);
        return elements.get(k - 1);
    }
    public static void inOrderTraversal(TreeNode node, List<Integer> elements) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, elements);
        elements.add(node.val);
        inOrderTraversal(node.right, elements);
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
