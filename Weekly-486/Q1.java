public class Q1 {
    public static void main(String[] args) {
        // int[] nums = { 1, -1, 2, 3, 3, 4, 5 };
        // int[] nums = { 4, 3, -2, -5 };
        // int[] nums = { 1, 2, 3, 4 };
        int[] nums = { 5, 6, 1, 2, 3, 0, 4 };
        System.out.println(minimumPrefixLength(nums));
    }

    public static int minimumPrefixLength(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] >= nums[i + 1]) {
                count = i + 1;
            }
        }
        return count;
    }
}
