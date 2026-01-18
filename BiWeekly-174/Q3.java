public class Q3 {
    public static void main(String[] args) {
        int[] nums = {1, 0, 0};
        int target1 = 1;
        int target2 = 0;
        int result = alternatingXOR(nums, target1, target2);
        System.out.println(result); // Should output 3
    }

    public static int alternatingXOR(int[] nums, int target1, int target2) {
        int n = nums.length;
        long mod = 1_000_000_007;
        
        long[] dp1 = new long[n + 1];
        long[] dp2 = new long[n + 1];
        
        dp1[0] = 0;
        dp2[0] = 0;
        
        for (int i = 1; i <= n; i++) {
            dp1[i] = 0;
            dp2[i] = 0;
            
            int xor = 0;
            for (int j = i - 1; j >= 0; j--) {
                xor ^= nums[j];
                
                if (j == 0) {
                    if (xor == target1) dp1[i] = (dp1[i] + 1) % mod;
                    if (xor == target2) dp2[i] = (dp2[i] + 1) % mod;
                } else {
                    if (xor == target1) {
                        dp1[i] = (dp1[i] + dp2[j]) % mod;
                    }
                    if (xor == target2) {
                        dp2[i] = (dp2[i] + dp1[j]) % mod;
                    }
                }
            }
        }
        
        return (int) ((dp1[n] + dp2[n]) % mod);
    }
}