import java.util.*;

public class LeetCode3719 {
    public static void main(String[] args) {
        // int[] nums = {2,5,4,3};
        int[] nums = { 1, 2, 3, 2 };
        System.out.println(longestBalanced(nums));
    }

    // Brute Force Approach
    public static int longestBalanced(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (isBalanced(nums, i, j)) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    public static boolean isBalanced(int[] nums, int start, int end) {
        // Use Hashset to count unique even and unique odd
        HashSet<Integer> even = new HashSet<>();
        HashSet<Integer> odd = new HashSet<>();
        for (int i = start; i <= end; i++) {
            if (nums[i] % 2 == 0) {
                even.add(nums[i]);
            } else {
                odd.add(nums[i]);
            }
        }
        return even.size() == odd.size();
    }
    // Optimised Approach
    public static int longestBalanced2(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            HashSet<Integer> even = new HashSet<>();
            HashSet<Integer> odd = new HashSet<>();
            for (int j = i; j < n; j++) {
                if (nums[j] % 2 == 0) {
                    even.add(nums[j]);
                } else {
                    odd.add(nums[j]);
                }
                if (even.size() == odd.size()) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }
}