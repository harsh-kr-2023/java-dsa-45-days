public class LeetCode55 {
    public static void main(String[] args) {
        // int[] nums = {2, 3, 1, 1, 4};
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(canJump(nums));
    }
    static boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        int maxReach = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i >= maxReach) return false;
            maxReach = Math.max(maxReach, i + nums[i]);
            if(maxReach >= nums.length - 1) return true;
        }
        return false;
    }
}