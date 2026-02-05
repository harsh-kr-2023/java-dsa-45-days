// =====================================
// DSA INTERVIEW TEMPLATE
// =====================================
// PROBLEM:
// - You are given an integer array nums of length n.
// A trionic subarray is a contiguous subarray nums[l...r] (with 0 <= l < r < n) for which there exist indices l < p < q < r such that:
// nums[l...p] is strictly increasing,
// nums[p...q] is strictly decreasing,
// nums[q...r] is strictly increasing.
// Return the maximum sum of any trionic subarray in nums..
//
// INPUT:
// - nums = [0,-2,-1,-3,0,2,-1]
//
// OUTPUT:
// - -4
//
// ASSUMPTIONS / CONSTRAINTS:
// - It is guaranteed that at least one trionic subarray exists.
// - 4 <= n = nums.length <= 10^5
// - -10^9 <= nums[i] <= 10^9

// -------------------------------------
// BRUTE FORCE:
// - Use 2 nested for loops to find the trio and return the sum
// - Time: O(n^2)
// - Space: O(1)
// - Not optimal due to quadratic time
//
// -------------------------------------
// OPTIMAL APPROACH:
// - Technique: DynamicProgramming
// - Idea: 
// - Why it works: 
// - Invariant: 
//
// -------------------------------------
// EDGE CASES:
// - 
//
// -------------------------------------
// FINAL COMPLEXITY:
// - Time:
// - Space:
//
// -------------------------------------
// FAILURE MODES:
// - 
// - 
// =====================================
public class LeetCode3640 {
    public static void main(String[] args) {
        int[] nums = { 0, -2, -1, -3, 0, 2, -1 };
        System.out.println(maxSumTrionic(nums));
    }

    public static long maxSumTrionic(int[] nums) {
        long maxSum = 0;

        for (int p = 1; p < nums.length - 2; p++) {
            for (int q = p + 1; q < nums.length - 1; q++) {
                maxSum = Math.max(maxSum, isIncreasing(nums, 0, p) + isDecreasing(nums, p, q) + isIncreasing(nums, q, nums.length));
            }
        }
        return maxSum;
    }

    private static int isIncreasing(int[] nums, int start, int end) {
        System.out.println("Increasing");
        System.out.println("Start: " + start + " End: " + end);
        int sum = 0;
        for (int i = start; i < end; i++) {
            if (nums[i] >= nums[i + 1]) {
                return 0;
            } else {
                sum += nums[i];
            }
        }
        System.out.println("Increasing Sum" + sum);
        return sum;
    }

    private static int isDecreasing(int[] nums, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            if (nums[i] <= nums[i + 1]) {
                return 0;
            } else {
                sum += nums[i];
            }
        }
        System.out.println("Decreasing Sum" + sum);
        return sum;
    }
}