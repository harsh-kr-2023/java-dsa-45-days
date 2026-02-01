public class Q3 {
    public static void main(String[] args) {
        // int[] nums = { 5, 4, 7 };
        // int[] nums = { 2, 3, 6 };
        // int[] nums = { 0, 1 };
        int[] nums = { 5, 6, 11 };
        System.out.println(longestSubsequence(nums));
        
    }

    public static int longestSubsequence(int[] nums) {
        // longest strictly increasing subsequence with non-zero bitwise AND
        int ans = 0;

        for (int bit = 0; bit < 32; bit++) {
            int count = 0;
            for (int x : nums) {
                if ((x & (1 << bit)) != 0) {
                    count++;
                }
            }
            ans = Math.max(ans, count);
        }

        return ans;
    }
}