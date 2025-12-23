import java.util.HashSet;

public class B11 {
    public static void main(String[] args) {
        // System.out.println(
        //         """
        //                 You are given an integer array nums.
        //                 In one operation, you remove the first three elements of the current array. If there are fewer than three elements remaining, all remaining elements are removed.
        //                 Repeat this operation until the array is empty or contains no duplicate values.
        //                 Return an integer denoting the number of operations required.""");
        int[] nums = {3,8,3,6,5,8}; // ->1
        // int[] nums = {1,2,3,4,5,6}; // ->0
        // int[] nums = {2,2}; // ->1
        // int[] nums = { 4, 3, 5, 1, 2 }; // ->0
        System.out.println("Number of operations: " + countOperations(nums));
    }

    // static int countOperations(int[] nums) {
    // int n = nums.length;
    // int operations = 0;
    // while (n > 0 && hasDuplicates(nums, n)) {
    // operations++;
    // nums = java.util.Arrays.copyOfRange(nums, Math.min(3, n), n);
    // n = nums.length;
    // }
    // return operations;
    // }

    // static boolean hasDuplicates(int[] nums, int n) {
    // for (int i = 0; i < n; i++) {
    // for (int j = i + 1; j < n; j++) {
    // if (nums[i] == nums[j]) {
    // return true;
    // }
    // }
    // }
    // return false;
    // }

    // Optimized version in O(n) time complexity
    static int countOperations(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int i = nums.length - 1;

        while (i >= 0) {
            if (set.contains(nums[i])) {
                break;
            }
            set.add(nums[i]);
            i--;
        }

        int prefixLength = i + 1;
        return (prefixLength + 2) / 3;
    }
}