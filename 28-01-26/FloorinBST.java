public class FloorinBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);
        int target = 9;
        Integer floorValue = findFloor(root, target);
        System.out.println(floorValue);
    }
    public static Integer findFloor(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        Integer floor = null;
        TreeNode current = root;
        while (current != null) {
            if (current.val == target) {
                return current.val;
            } else if (current.val > target) {
                current = current.left;
            } else {
                floor = current.val;
                current = current.right;
            }
        }
        return floor;
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
