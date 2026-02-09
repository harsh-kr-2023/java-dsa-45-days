import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 6};
        int[] result = productExceptSelf2(nums);
        System.out.println(Arrays.toString(result));
    }
    // Brute Force Approach
    public static int[] productExceptSelf(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    product *= nums[j];
                    nums[i] = product;
                }
            }
        }
        return nums;
    }
    // Optimised Approach using prefix and suffix arrays
    public static int[] productExceptSelf2(int[] nums){
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] result = new int[n];
        prefix[0] = 1;
        suffix[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        System.out.println(Arrays.toString(prefix));
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }
        System.out.println(Arrays.toString(suffix));
        for (int i = 0; i < n; i++) {
            result[i] = prefix[i] * suffix[i];
        }
        return result;
    }
}
