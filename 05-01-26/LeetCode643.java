public class LeetCode643 {
    public static void main(String[] args) {
        int[] nums = { 1, 12, -5, -6, 50, 3 };
        int k = 4;
        double result = findMaxAverage(nums, k);
        System.out.println("Maximum average of subarrays of length " + k + " is: " + result);
    }

    public static double findMaxAverage(int[] nums, int k) {
        // Sliding window approach
        int n = nums.length;
        // Calculate the sum of the first 'k' elements
        double windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        double maxAverage = windowSum / k;
        // Slide the window from start to end of the array
        for (int i = k; i < n; i++) {
            windowSum += nums[i] - nums[i - k];
            double currentAverage = windowSum / k;
            if (currentAverage > maxAverage) {
                maxAverage = currentAverage;
            }
        }
        return maxAverage;
    }
}
