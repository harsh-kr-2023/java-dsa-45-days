public class LeetCode1390 {
    public static void main(String[] args) {
        int[] nums = {21,4,7};
        System.out.println(sumFourDivisors(nums));
    }
    static int sumFourDivisors(int[] nums) {
        // Brute force - find the nums  with exactly 4 divisors and sum them up
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            int currentSum = 0;
            for (int j = 1; j * j <= nums[i]; j++) {
                if (nums[i] % j == 0) {
                    count++;
                    currentSum += j;
                    if (j != nums[i] / j) {
                        count++;
                        currentSum += nums[i] / j;
                    }
                }
                if (count > 4) {
                    break;
                }
            }
            if (count == 4) {
                sum += currentSum;
            }
        }
        return sum;
    }
}
