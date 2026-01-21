import java.util.HashSet;
import java.util.Set;


public class LeetCode128 {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }
    public static int longestConsecutive(int[] nums) {
        // Brute Force with Sorting
        if (nums.length == 0) return 0;
        java.util.Arrays.sort(nums);
        int longestStreak = 1;
        int currentStreak = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) { // Skip duplicates
                if (nums[i] == nums[i - 1] + 1) {
                    currentStreak += 1;
                } else {
                    longestStreak = Math.max(longestStreak, currentStreak);
                    currentStreak = 1;
                }
            }
        }
        return Math.max(longestStreak, currentStreak);
    }
    // public static int longestConsecutive(int[] nums) {
        // Set<Integer> set = new HashSet<>();
        // for (int num : nums) {
        //     set.add(num);
        // }
        // int longestStreak = 0;
        // for (int num : set) {
        //     if (!set.contains(num - 1)) {
        //         int currentNum = num;
        //         int currentStreak = 1;

        //         while (set.contains(currentNum + 1)) {
        //             currentNum += 1;
        //             currentStreak += 1;
        //         }
        //         longestStreak = Math.max(longestStreak, currentStreak);
        //     }
        // }
        // return longestStreak;
    // }
}