// =====================================
// DSA INTERVIEW TEMPLATE
// =====================================
// PROBLEM:
// - Given an integer array nums, rotate the array to the right by k steps, where k is non-negative..
//
// INPUT:
// - nums = [1,2,3,4,5,6,7], k = 3
//
// OUTPUT:
// - [5,6,7,1,2,3,4]
//
// ASSUMPTIONS / CONSTRAINTS:
// 1 <= nums.length <= 10^5
// -2^31 <= nums[i] <= 2^31 - 1
// 0 <= k <= 10^5
//
// -------------------------------------
// BRUTE FORCE:
// - Use a while loop until k > 0 and bring the last element to the front and push the remaining element to right by 1 and decrement k by 1
// - Time: O(n * k)
// - Space: O(1) 
//
// -------------------------------------
// OPTIMAL APPROACH:
// - Technique: Reverse the entire array, then reverse the first k elements and then reverse the remaining elements
// - Idea:
// - Why it works: 
// - Invariant: No extra memory is used.
//
// -------------------------------------
// EDGE CASES:
// - k > nums.length
// - k = 0
// - array.length = 1
//
// -------------------------------------
// FINAL COMPLEXITY:
// - Time: O(N)
// - Space: O(1)
//
// -------------------------------------
// FAILURE MODES:
// - Forgetting k = k % nums.length
// =====================================
public class RotateArray {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;
        rotate(nums, k);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    // Bring the last element to the front and push the remaining element to right by 1
    public static void rotate(int[] nums, int k) {
        if (k == 0) {
            return;
        }
        if (k > nums.length) {
            k = k % nums.length;
        }
        if (nums.length == 1) {
            return;
        }
        while(k > 0) {
            int temp = nums[nums.length - 1];
            for (int i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = temp;
            k--;
        }
    }

    // Pick last k elements and push the remaining by k positions and put the last k elements in the front.
    public static void rotate2(int[] nums, int k) {
        k = k % nums.length;
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = nums[nums.length - k + i];
        }
        for (int i = nums.length - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }

    // Optimal Approach
    public static void rotate3(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        if(k == 0 || k == n || n == 1) return;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }
    private static void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }    
} 