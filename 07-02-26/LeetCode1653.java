// =====================================
// DSA INTERVIEW TEMPLATE
// =====================================
// PROBLEM:
// - Given a string S consisting of only 'a' and 'b', find the minimum count of characters to be deleted to make it balanced.
// - Balanced means no 'a' will appear after 'b'
// INPUT:
// - S = "aababbab"
//
// OUTPUT:
// - 2
//
// ASSUMPTIONS / CONSTRAINTS:
// 1 <= s.length <= 10^5
// s[i] is 'a' or 'b'​​.
//
// -------------------------------------
// BRUTE FORCE:
// - Idea: For every index, find the cost of removing all succeeding a and all preceeding b
// - Time: O(n^2)
// - Space: O(1)
// - Why not optimal? - We are doing same thing twice that is counting all succeeding a and all preceeding b for all indexes.
//
// -------------------------------------
// OPTIMAL APPROACH:
// - Technique: Prefix Sum
// - Idea: Create 2 arrays of prefix_b and suffix_a in one pass and then find the min cost
// - Why it works: If we know that at each index, we do have count of preceeding B and succeeding A then we dont have to calculate it each time.
// - Invariant: After traversing array twice, we do know at each index, what will be the cost of deletion
//
// -------------------------------------
// EDGE CASES:
// - Look out for edge cases like single character string and empty string and string with only one kind of character.
// -------------------------------------
// FINAL COMPLEXITY:
// - Time: O(n)
// - Space: O(n)
//
// -------------------------------------
// FAILURE MODES:
// - This approach assumes STRING CONTAINS ONLY 'a' AND 'b' AND WILL FAIL IF THERE ARE ANY OTHER CHARACTERS.
// =====================================
public class LeetCode1653 {
    public static void main(String[] args) {
        String s = "aabbbaaaab";
        System.out.println(minimumDeletions2(s));
    }
    // Brute force approach
    public static int minimumDeletions(String s) {
        int n = s.length();
        if(n <= 1) return 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            // find all succeeding a and all preceeding b
            int a_count = 0;
            int b_count = 0;
            for (int j = i; j < n; j++) {
                if (s.charAt(j) == 'a') {
                    a_count++;
                }
            }
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(j) == 'b') {
                    b_count++;
                }
            }
            min = Math.min(min, a_count + b_count);
        }
        return min;
    }
    // Optimal approach using Prefix Sum
    public static int minimumDeletions2(String s) {
        int n = s.length();
        if(n <= 1) return 0;
        int[] prefix_b = new int[n + 1];
        int[] suffix_a = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            prefix_b[i] = prefix_b[i - 1] + (s.charAt(i - 1) == 'b' ? 1 : 0);
        }
        for (int i = n - 1; i >= 0; i--) {
            suffix_a[i] = suffix_a[i + 1] + (s.charAt(i) == 'a' ? 1 : 0);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            min = Math.min(min, prefix_b[i] + suffix_a[i]);
        }
        return min;
    }
}
