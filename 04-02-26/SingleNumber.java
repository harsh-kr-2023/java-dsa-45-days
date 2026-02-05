// =====================================
// DSA INTERVIEW TEMPLATE
// =====================================
// PROBLEM:
// - Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
// You must implement a solution with a linear runtime complexity and use only constant extra space.
//
// INPUT:
// - nums = [1,2,2]
//
// OUTPUT:
// - 1
//
// ASSUMPTIONS:
// - Each element in the array appears twice except for one element which appears only once.
// 1 <= nums.length <= 3 * 10^4
// -3 * 10^4 <= nums[i] <= 3 * 10^4
// -------------------------------------
// BRUTE FORCE:
// - Run a nested for loop and check which element is not repeated
// - Time: O(n^2)
// - Space: O(1)
// - This approach is correct but not acceptable because it does not meet the required linear time constraint
// -------------------------------------
// OPTIMAL APPROACH:
// - Technique: XOR
// - Idea: XOR all elements of the array together.
// - Why it works: a ^ a = 0 and a ^ 0 = a, so all paired elements cancel out.
// - Invariant: After processing index i, result stores XOR of elements nums[0..i-1].
// -------------------------------------
// EDGE CASES:
// Minimum length array (n = 1)
// -------------------------------------
// FINAL COMPLEXITY:
// - Time: O(n)
// - Space: O(1)
// -------------------------------------
// FAILURE MODES:
// Assumes exactly one element appears once and all others appear exactly twice
// =====================================
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {2,2,1};
        System.out.println(singleNumber(nums));
    }
    // Brute Force Approach
    public static int singleNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean found = false;
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] == nums[j]) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return nums[i];
            }
        }
        return -1;
    }
    // Optimal Approach using XOR operation
    public static int singleNumber2(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}