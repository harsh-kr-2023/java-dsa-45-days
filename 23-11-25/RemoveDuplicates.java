// 2. Remove Duplicates from Sorted Array

// Return new length of array after removing duplicates in-place.

// Test Cases

// TC1: [1,1,2] → 2 , nums = [1,2,_]
// TC2: [0,0,1,1,1,2,2,3,3,4] → 5

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if(nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        System.out.println("New length: " + (i + 1));
    }
}