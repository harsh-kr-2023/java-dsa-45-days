=====================================
DSA INTERVIEW TEMPLATE
=====================================
PROBLEM:
- Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.
Consider the number of unique elements in nums to be k​​​​​​​​​​​​​​. After removing duplicates, return the number of unique elements k.
The first k elements of nums should contain the unique numbers in sorted order. The remaining elements beyond index k - 1 can be ignored.

INPUT:
- nums = [1,1,2]
- nums = [0,0,1,1,1,2,2,3,3,4]
OUTPUT:
- k = 2, nums = [1,2,_]
- k = 5, nums = [0,1,2,3,4,_,_,_,_,_]
ASSUMPTIONS:
- The array is sorted in non-decreasing order.
- The array can contain negative numbers.
- 1 <= nums.length <= 3 * 10^4
- -100 <= nums[i] <= 100
- nums is sorted in non-decreasing order.
-------------------------------------
BRUTE FORCE:
- Idea: Use a Set to store unique elements and then copy back to the array.
- Time Complexity: O(n)
- Space Complexity: O(n)
- Why not optimal? Extra space is used.
-------------------------------------
OPTIMAL APPROACH:
- Technique / Pattern: Two Pointers
- Idea: Use two pointers to overwrite duplicates in the array.
- Why it works: We maintain a pointer for the position of the next unique element.
- Invariant (if any): The first pointer always points to the last unique element found.
-------------------------------------
EDGE CASES:
- Empty array
- Array with all duplicates
- Array with no duplicates
- Array with negative numbers
- Array with only one element
-------------------------------------
FINAL COMPLEXITY:
- Time: O(n)
- Space: O(1)
-------------------------------------
FAILURE MODES:
- Algorithm fails on empty array.
- Cannot be used if modification of the original array is not allowed.
- Requires at least one element in the array to function correctly.
=====================================
CODE BELOW
=====================================

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        int k = removeDuplicates(nums);
        System.out.println(k);
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 1;

        while(right < nums.length) {
            if (nums[left] == nums[right]) {
                right++;
            } else {
                left++;
                nums[left] = nums[right];
                right++;
            }
        }
        return left + 1;
    }
}