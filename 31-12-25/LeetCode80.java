public class LeetCode80 {
    public static void main(String[] args) {
        int[] nums = { 0, 0, 1, 1, 1, 1, 2, 3, 3};
        int res = removeDuplicatesII(nums);
        System.out.println(res);
    }

    // Brute Force Approach
    static int removeDuplicatesII(int[] nums) {
        int slow = 0;
        int fast = 0;
        int n = nums.length;
        while (fast < n) {
            if (slow < 2 || nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
