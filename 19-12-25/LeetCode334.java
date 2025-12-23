public class LeetCode334 {
    public static void main(String[] args) {
        // int[] nums = { 20, 100, 10, 12, 5, 13 };
        int[] nums = { 6, 7, 1, 2 };
        System.out.println(increasingTriplet(nums));
    }

    static boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE; // nums[i]
        int second = Integer.MAX_VALUE; // nums[j]

        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                // num > first AND num > second
                // i < j < k exists
                return true;
            }
        }
        return false;
    }
}