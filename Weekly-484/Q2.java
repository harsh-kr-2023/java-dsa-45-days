import java.util.Set;

public class Q2 {
    public static void main(String[] args) {
        int[] nums = { -1, 1, 0 };
        // int[] nums = { 2, -3 };
        System.out.println(centeredSubarrays(nums));
    }

    public static int centeredSubarrays(int[] nums) {
        // Brute Force
        int result = 0;
        // Generate all subarrays and check if they are centered
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (isCentered(nums, i, j)) {
                    result++;
                }
            }
        }
        
        return result;
    }
    public static boolean isCentered(int[] nums, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += nums[i];
        }
        // if sum is in array return true
        for (int i = start; i <= end; i++) {
            if (sum == nums[i]) {
                return true;
            }
        }
        return false;
    }

    // Optimized Sol
    public static int centeredSubarraysOptimized(int[] nums) {
        int n = nums.length;
        int result = 0;

        // Precompute prefix sum
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        // Generate all subarrays and check if they are centered
        for (int i = 0; i < n; i++) {
            // use a set to track elements
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                set.add(nums[j]);
                int sum = prefixSum[j + 1] - prefixSum[i];
                if (set.contains(sum)) {
                    result++;
                }
            }
        }
        return result;
}
