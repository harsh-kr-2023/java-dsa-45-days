// ✅ 3. Remove Element

// Remove all occurrences of val from array in-place.

// Test Cases

// TC1: nums = [3,2,2,3], val = 3
// TC2: nums = [0,1,2,2,3,0,4,2], val = 2

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };
        int val = 2;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        int count = 0;
        for (int num : nums) {
            if (num != val) {
                count++;
            }
        }
        System.out.println("New length: " + count);
    }
}
