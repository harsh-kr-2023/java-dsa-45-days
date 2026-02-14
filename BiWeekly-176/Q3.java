public class Q3 {
    public static void main(String[] args) {
        int[] nums = { 1, 4, 3, 5 };
        int[] colors = { 1, 1, 2, 2 };
        System.out.println(rob(nums, colors));
    }

    public static long rob(int[] nums, int[] colors) {
        if (nums == null || colors == null || nums.length == 0 || nums.length != colors.length) {
            return 0;
        }
        long take = nums[0];
        long skip = 0;
        for (int i = 1; i < nums.length; i++) {
            long bestPrev = Math.max(take, skip);
            long newTake;
            if (colors[i] == colors[i - 1]) {
                newTake = nums[i] + skip;
            } else {
                newTake = nums[i] + bestPrev;
            }
            long newSkip = bestPrev;
            take = newTake;
            skip = newSkip;
        }

        return Math.max(take, skip);
    }

    public static long rob2(int[] nums, int[] colors) {
        // cannot rob two adjacent houses if they share the same color code.
        // Brute Force - Rob a house, move to next, match the color codes, if same then
        // compare money, if less then continue else rob the currenthouse and reduce the
        // previous amount from totalmoney
        if (nums == null || colors == null || nums.length != colors.length)
            return 0;
        return dfs(0, false, nums, colors);
    }

    private static long dfs(int i, boolean prevRobbed, int[] nums, int[] colors) {
        if (i == nums.length)
            return 0;

        // option 1: skip current
        long skip = dfs(i + 1, false, nums, colors);

        // option 2: take current (if allowed)
        boolean canTake = true;
        if (i > 0 && prevRobbed && colors[i] == colors[i - 1]) {
            canTake = false;
        }

        long take = Long.MIN_VALUE;
        if (canTake) {
            take = nums[i] + dfs(i + 1, true, nums, colors);
        }

        return Math.max(skip, take);
    }
}