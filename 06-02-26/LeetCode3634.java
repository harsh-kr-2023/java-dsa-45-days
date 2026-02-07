// =====================================
// DSA INTERVIEW TEMPLATE
// =====================================
// PROBLEM:
// - You are given an integer array nums and an integer k.
// An array is considered balanced if the value of its maximum element is at most k times the minimum element.
// You may remove any number of elements from nums​​​​​​​ without making it empty.
// Return the minimum number of elements to remove so that the remaining array is balanced.
// Note: An array of size 1 is considered balanced as its maximum and minimum are equal, and the condition always holds true.
//
// INPUT:
// - nums = [2,1,5], k = 2
// - nums = [4,6], k = 2
// - nums = [1,2,6,9], k = 3
//
// OUTPUT:
// - 1
// - 0
// - 2
//
// ASSUMPTIONS / CONSTRAINTS:
// 1 <= nums.length <= 10^5
// 1 <= nums[i] <= 10^9
// 1 <= k <= 10^5
//
// -------------------------------------
// BRUTE FORCE:
// - Idea: Sort the array and fix i as the minimum element, then for every j >= i, check if nums[j] <= nums[i] * k. Keep a track of maximum window size.
// - Time: O(n^2)
// - Space: O(1)
// - Why not optimal? - Two nested loops and checks for every explicit pair of elements. so time complexity will be quadratic which is not optimal for bigger inputs.
//
// -------------------------------------
// OPTIMAL APPROACH:
// - Technique: Sliding Window
// - Idea: Sort the array, fix i as minimim element, expand j as far as possible while nums[j] <= nums[i] * k. Keep a track of maximum window size.
// - Why it works: i only moves forward → O(n)
// j expands the window
// Window always satisfies:
// nums[j] <= nums[i] * k
// maxWindow stores best subset size
// - Invariant: After processing the first i elements, maxWindow correctly represents the sliding window.
//
// -------------------------------------
// EDGE CASES:
// - when array length is 1.
// - 
//
// -------------------------------------
// FINAL COMPLEXITY:
// - Time: O(nlogn)
// - Space: O(1) (excluding sort)
//
// -------------------------------------
// FAILURE MODES:
// - 
// =====================================

import java.util.Arrays;

public class LeetCode3634 {
    public static void main(String[] args) {
        // int[] nums = {1,2,6,9};
        // int k = 3;
        // int[] nums = {2,1,5};
        // int k = 2;
        int[] nums = {4,6};
        int k = 2;
        System.out.println(minRemoval(nums, k));
    }

    // Brute Force Approach
    public static int minRemoval(int[] nums, int k) {
        int n = nums.length;
        if(n <= 1) return 0;
        Arrays.sort(nums);
        int maxSize = 1;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                System.out.println(nums[i] + " " + nums[j]);
                if(nums[j] <= (long) nums[i] * k) {
                    maxSize = Math.max(maxSize, j - i + 1);
                }
                else {
                    break;
                }
            }
        }
        return n - maxSize;
    }

    // Optimal Approach
    public static int minRemoval2(int[] nums, int k) {
        int n = nums.length;
        if(n <= 1) return 0;
        Arrays.sort(nums);
        int maxWindow = 1;
        int i = 0;
        for(int j = 0; j < n; j++) {
            while(nums[j] > (long) nums[i] * k) {
                i++;
            }
            maxWindow = Math.max(maxWindow, j - i + 1);
        }
        return n - maxWindow;
    }
}
