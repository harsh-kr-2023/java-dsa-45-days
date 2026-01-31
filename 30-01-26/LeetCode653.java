import java.util.ArrayList;
import java.util.List;

public class LeetCode653 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        System.out.println(findTarget(root, 9)); // true
        System.out.println(findTarget(root, 28)); // false
    }
    // 1. Traverse the BST and store values in an array and use two pointers to find if there exist two numbers that sum to k
    public static boolean findTarget(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        int left = 0, right = nums.size() - 1;
        while (left < right) {
            int sum = nums.get(left) + nums.get(right);
            if (sum == k) {
                return true;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
    public static void inorder(TreeNode root, List<Integer> nums) {
        if(root == null) {
            return;
        }
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }

    // 2. Use a HashSet to store the values we have seen so far during the DFS traversal
    public boolean findTargetWithSet(TreeNode root, int k) {
        return dfs(root, k, new ArrayList<>());
    }
    public boolean dfs(TreeNode root, int k, List<Integer> nums) {
        if(root == null) {
            return false;
        }
        if(nums.contains(k - root.val)) {
            return true;
        }
        nums.add(root.val);
        return dfs(root.left, k, nums) || dfs(root.right, k, nums);
    }
    
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
