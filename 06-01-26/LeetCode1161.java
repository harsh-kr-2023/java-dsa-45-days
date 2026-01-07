public class LeetCode1161 {
    public static void main(String[] args) {
        int[] root = {1,7,0,7,-8,null,null};
        TreeNode treeNode = TreeNode.buildTree(root);
        System.out.println(maxLevelSum(treeNode));
    }
    public static int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxSum = Integer.MIN_VALUE;
        int level = 0;
        int resultLevel = 0;

        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            int currentLevelSum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                currentLevelSum += currentNode.val;

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            if (currentLevelSum > maxSum) {
                maxSum = currentLevelSum;
                resultLevel = level;
            }
        }

        return resultLevel;
    }
}
