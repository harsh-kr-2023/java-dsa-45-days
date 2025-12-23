public class FindDisappearedNum {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }
    static int[] findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        // Brute Force Approach O(n^2)
        for (int i = 1; i <= n; i++) {
            boolean found = false;
            for (int j = 0; j < n; j++) {
                if (nums[j] == i) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                result[i - 1] = i;
            }
        }
        return result;
    }
}   