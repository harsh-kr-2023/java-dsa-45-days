// =====================================
// DSA INTERVIEW TEMPLATE
// =====================================
// PROBLEM:
// Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

// INPUT:
// nums1 = [1,2,2,1], nums2 = [2,2]

// OUTPUT:
// [2,2]

// ASSUMPTIONS / CONSTRAINTS:
// 1 <= nums1.length, nums2.length <= 1000
// 0 <= nums1[i], nums2[i] <= 1000
// -------------------------------------
// BRUTE FORCE:
// - Idea:Approach: Find the smaller array, then traverse the array and try to find intersecting elements in the larger array, if found, then add in result arraylist and store -1 in larger array to handle duplicate values and create array of size of arraylist and convert arraylist to array and return.
// - Time: O(n^2)
// - Space: O(n)
// - Why not optimal? - Not optimal due to quadratic time and we are using extra space
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
import java.util.ArrayList;

public class IntersectionOfArrays {
    public static void main(String[] args) {
        int[] nums1 = { 2, 3, 7, 11, 3, 15 };
        int[] nums2 = { 2, 3, 3, 15 };
        int[] result = intersection(nums1, nums2);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    // Brute Force Approach
    public static int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> result = new ArrayList<>();
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    result.add(nums1[i]);
                    nums2[j] = -1;
                    break;
                }
            }
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}