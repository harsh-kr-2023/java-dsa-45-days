import java.util.Arrays;

public class SmallerNumbersThanCurrent {
    public static void main(String[] args) {
        int[] nums = {8, 1, 2, 2, 3};
        int[] result = smallerNumbersThanCurrent(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
    static int[] smallerNumbersThanCurrent(int[] nums) {
        // brute force approach
        int[] count = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    count[i]++;
                }
            }
        }
        return count;
    }
    // Optimized approach
    static int[] smallerNumbersThanCurrentOptimized(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = indexOfFirstOccurrence(sorted, nums[i]);
        }
        return result;
    }
    static int indexOfFirstOccurrence(int[] sorted, int target) {
        int left = 0;
        int right = sorted.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sorted[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
