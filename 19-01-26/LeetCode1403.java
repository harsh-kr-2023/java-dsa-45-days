import java.util.Arrays;

public class LeetCode1403 {
    public static void main(String[] args) {
        int[] nums = { 4, 3, 10, 9, 8 };
        System.out.println(minSubsequence(nums));
    }
    public static List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int sum1 = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = nums.length - 1; i >=0; i--) {
            sum1 += nums[i];
            res.add(nums[i]);
            if (sum1 > sum - sum1) {
                break;
            }
        }
        return res;
    }
}
