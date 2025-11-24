import java.util.List;

public class LeadersInArray {
    public static List<Integer> leaders(int[] nums) {
        List<Integer> result = new java.util.ArrayList<>();
        int maxFromRight = nums[nums.length - 1];
        result.add(maxFromRight);
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > maxFromRight) {
                maxFromRight = nums[i];
                result.add(maxFromRight);
            }
        }
        java.util.Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 3, 1, 2};
        List<Integer> leaders = leaders(nums);
        System.out.println("Leaders in the array: " + leaders);
    }
}