public class LeetCode3637 {
    public static void main(String[] args) {
        // int[] nums = { 1, 3, 5, 4, 2, 6 };
        // int[] nums = { 5, 9, 1, 7 };
        int[] nums = { 1, 1, 1, 9 };
        System.out.println(isTrionic(nums));
    }

    public static boolean isTrionic(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        for (int p = 1; p < nums.length - 2; p++) {
            for (int q = p + 1; q < nums.length - 1; q++) {
                if (isIncreasing(nums, 0, p) &&
                        isDecreasing(nums, p, q) &&
                        isIncreasing(nums, q, nums.length - 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isIncreasing(int[] nums, int start, int end) {
        for (int i = start; i < end; i++) {
            if (nums[i] >= nums[i + 1]) {
                return false;
            }
        }
        System.out.println("Increase from " + start + " to " + end);
        return true;
    }

    private static boolean isDecreasing(int[] nums, int start, int end) {
        for (int i = start; i < end; i++) {
            if (nums[i] <= nums[i + 1]) {
                return false;
            }
        }
        System.out.println("Decrease from " + start + " to " + end);
        return true;
    }
}