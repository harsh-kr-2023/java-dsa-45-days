public class LeetCode1877 {
    public static void main(String[] args) {
        int[] nums = {3,5,2,3};
        System.out.println(minPairSum(nums));
    }
    public static int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            max = Math.max(max, nums[i] + nums[nums.length - 1 - i]);
        }
        return max;
    }
}
