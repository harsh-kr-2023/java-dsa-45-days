
import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longestStreak = 0;
        for(int num : numSet) {
            // System.out.println("Checking number: " + num); // Debug statement
            if(!numSet.contains(num-1)){
                int currentNum = num;
                int currentStreak = 1;
                while(numSet.contains(currentNum + 1)){
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
                // System.out.println("Current streak for " + num + ": " + currentStreak); // Debug statement
                // System.out.println("Longest streak so far: " + longestStreak); // Debug statement
            }
        }
        return longestStreak;
    }
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println("Length of longest consecutive sequence: " + longestConsecutive(nums));
    }
}
