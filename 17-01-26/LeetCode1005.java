import java.util.Arrays;

public class LeetCode1005 {
    public static void main(String[] args) {
        int[] nums = { -2, 9, 9, 8, 4 };
        int k = 5;
        System.out.println(largestSumAfterKNegations(nums, k));
    }

    public static int largestSumAfterKNegations(int[] nums, int k) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] *= -1;
                k--;
            }
            sum += nums[i];
        }
        Arrays.sort(nums);
        if (k % 2 != 0) {
            sum -= 2 * nums[0];
        }
        return sum;
    }
}