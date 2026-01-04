import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        // System.out.println("You are given an integer array nums and an integer k.
        // Return the minimum length of a subarray whose sum of the distinct values
        // present in that subarray (each value counted once) is at least k. If no such
        // subarray exists, return -1.
        // A subarray is a contiguous non-empty sequence of elements within an array");
        // int[] nums = {2,2,3,1};
        // int k = 4;
        // int[] nums = { 3, 2, 3, 4 };
        // int k = 5;
        // int[] nums = {5,5,4};
        // int k = 5;
        int[] nums = { 6, 6, 11 };
        int k = 12;
        System.out.println(minSubarrayLength(nums, k));
    }

    static int minSubarrayLength_old(int[] nums, int k) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;

        for (int start = 0; start < n; start++) {
            Set<Integer> distinctValues = new HashSet<>();
            int currentSum = 0;

            for (int end = start; end < n; end++) {
                distinctValues.add(nums[end]);
                currentSum = distinctValues.stream().mapToInt(Integer::intValue).sum();

                if (currentSum >= k) {
                    minLength = Math.min(minLength, end - start + 1);
                    break; // No need to extend the subarray further
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    // Optimized Approach using Sliding Window
    static int minSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;

        Map<Integer, Integer> countMap = new HashMap<>();
        int left = 0;
        int distinctSum = 0;

        for (int right = 0; right < n; right++) {
            int num = nums[right];
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);

            // If this is the first occurrence in current window, add to sum
            if (countMap.get(num) == 1) {
                distinctSum += num;
            }

            // Try to shrink window while condition is satisfied
            while (distinctSum >= k) {
                minLength = Math.min(minLength, right - left + 1);

                // Remove leftmost element
                int leftNum = nums[left];
                countMap.put(leftNum, countMap.get(leftNum) - 1);

                // If no more of this value in window, remove from sum
                if (countMap.get(leftNum) == 0) {
                    distinctSum -= leftNum;
                }

                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}
