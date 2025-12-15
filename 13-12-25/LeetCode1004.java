public class LeetCode1004 {
    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int k = 2;
        System.out.println(longestOnes(arr, k));
    }

    static int longestOnes(int[] nums, int k) {
        int maxLength = 0;
        int l = 0;
        int r = 0;
        int zeroes = 0;
        while (r < nums.length) {
            if (nums[r] == 0)
                zeroes++;
            while (zeroes > k) {
                if (nums[l] == 0) {
                    zeroes--;
                }
                l++;
            }
            if (zeroes <= k) {
                int length = r - l + 1;
                maxLength = Math.max(length, maxLength);
            }
            r++;
        }
        return maxLength;
    }
}