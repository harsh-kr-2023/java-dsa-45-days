// =====================================
// DSA INTERVIEW TEMPLATE
// =====================================
// PROBLEM:
// - 
//
// INPUT:
// - 
//
// OUTPUT:
// - 
//
// ASSUMPTIONS:
// - 
//
// -------------------------------------
// BRUTE FORCE:
// - Idea:
// - Time:
// - Space:
// - Why not optimal?
//
// -------------------------------------
// OPTIMAL APPROACH:
// - Technique:
// - Idea:
// - Why it works:
// - Invariant: After processing the first i elements, <state> correctly represents <meaning for processed portion>.
//
// -------------------------------------
// EDGE CASES:
// - Boundary condition where input size or value is at its minimum or maximum
// - Case where assumptions are barely satisfied (e.g., smallest valid input)
// - Case that could break logic if not handled explicitly
//
// -------------------------------------
// FINAL COMPLEXITY:
// - Time:
// - Space:
//
// -------------------------------------
// FAILURE MODES:
// - This approach assumes <key assumption>.
// - It fails or becomes invalid if <assumption is violated>.
// =====================================
public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        for(int i : nums) {
            System.out.print(i + " ");
        }
    }
    // Brute Force Approach
    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++) {
                if(nums[i] == 0) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
    // Optimal Approach using 2 pointers
    public static void moveZeroes2(int[] nums) {
        int n = nums.length;
        int leftPointer = 0;
        int rightPointer = 0;
        while(rightPointer < n) {
            if(nums[rightPointer] != 0) {
                int temp = nums[leftPointer];
                nums[leftPointer] = nums[rightPointer];
                nums[rightPointer] = temp;
                leftPointer++;
            }
            rightPointer++;
        }
    }
}
