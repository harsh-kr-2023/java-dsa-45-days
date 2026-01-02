public class LeetCode45 {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 1, 4 };
        // int[] nums = {3, 2, 1, 0, 4};
        System.out.println(jump(nums));
    }

    static int jump(int[] nums) {
        int n = nums.length;
        int maxReach = 0;
        int jumps = 0;
        int end = 0;
        for (int i = 0; i < n - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (i == end) {
                jumps++;
                end = maxReach;
            }
        }
        return jumps;
    }
}