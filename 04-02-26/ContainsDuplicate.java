// =====================================
// DSA INTERVIEW TEMPLATE
// =====================================
// PROBLEM:
// - Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
//
// INPUT:
// - nums = [1,2,3,1]
//
// OUTPUT:
// - true
//
// ASSUMPTIONS / CONSTRAINTS:
// 1 <= nums.length <= 10^5
// -10^9 <= nums[i] <= 10^9
//
// -------------------------------------
// BRUTE FORCE:
// - Scan the array using 2 nested for loops and if we find duplicate, return true else return false
// - Time: O(n^2)
// - Space: O(1)
// - Not optimal due to quadratic time
//
// -------------------------------------
// OPTIMAL APPROACH:
// - Technique: HashSet
// - Idea: Traverse the array once while storing seen elements in a HashSet.
//         If an element already exists in the set, a duplicate is found.
// - Why it works: HashSet provides O(1) average-time lookup and does not allow duplicates.
// - Invariant: Before processing index i, the HashSet contains all elements from indices [0 .. i-1].
//
// -------------------------------------
// EDGE CASES:
// - Array with 1 element
//
// -------------------------------------
// FINAL COMPLEXITY:
// - Time: O(n)
// - Space: O(n)
//
// -------------------------------------
// FAILURE MODES:
// - 
// =====================================
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        System.out.println(containsDuplicate(nums));
    }
    // Brute Force Approach
    public static boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // Optimal Approach
    public static boolean containsDuplicate2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
