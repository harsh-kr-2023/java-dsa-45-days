public class LeetCode2962 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 3, 3};
        int k = 2;
        System.out.println(countSubarrays(nums, k));
    }

    public static long countSubarrays(int[] nums, int k) {
        int max = maxVal(nums);

        int left = 0;
        long count = 0;
        long result = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == max) {
                count++;
            }

            while (count >= k) {
                // all subarrays starting at `left` and ending at >= right
                result += (long) nums.length - right;

                if (nums[left] == max) {
                    count--;
                }
                left++;
            }
        }
        return result;
    }

    public static int maxVal(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}
