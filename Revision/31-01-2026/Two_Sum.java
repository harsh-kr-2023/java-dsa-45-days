/*
================ INTERVIEW THINKING =================

Problem (in my own words): You are given an integer array nums and a target, return indices of 2 numbers such that they add up to target.


Clarifying questions I would ask the interviewer:
- Can I use the same element twice?
- 


Constraints that matter:
- Input size: 2 <= nums.length <= 10^4
              -10^9 <= nums[i] <= 10^9
              -10^9 <= target <= 10^9
- Value ranges:
- Time limit:
- Memory limit:


1) Brute Force Approach:
- Idea: Select first element, then traverse the array searching for target - first element, if found, return indices of both elements.
- Time Complexity: O(N^2)
- Space Complexity: O(1)
- Why it fails / why not acceptable: It traverses array twice in worst case scenario.


2) Optimized Approach:
- Key insight:  we'll have to optimise this further using hashmap, Use a HashMap to store element and its index in first pass only so we can remember that we have seen this element at this index
- Data structure(s) used: HashMap
- Why this works: Because in one pass, we have the index of elements and when searching for target - first element, we already know where it exists


3) Complexity Analysis:
- Time (best / average / worst):
- Space:


4) Edge Cases:
- 
- 
- 


5) Follow-up Scenarios:
- What if input is streaming?
- What if memory is limited?
- What if duplicates / negative values exist?

=====================================================
*/

import java.util.*;

public class Two_Sum {
    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 26;
        int[] result = findTwoSumOptimized(nums, target);
        for (int x : result) {
            System.out.print(x + " ");
        }
    }

    // Brute Force - O(N^2)
    public static int[] findTwoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    // Optimised Approach - O(N)
    public static int[] findTwoSumOptimized(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                result[0] = i;
                result[1] = map.get(complement);
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}