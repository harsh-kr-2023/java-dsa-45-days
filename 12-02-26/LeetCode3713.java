import java.util.*;

public class LeetCode3713 {
    public static void main(String[] args) {
        String s = "abbac";
        System.out.println(longestBalanced(s));
    }

    // Brute Force Solution
    public static int longestBalanced(String s) {
        int n = s.length();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;
                if (isBalanced(freq)) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    public static boolean isBalanced(int[] freq) {
        int expected = 0;

        for (int f : freq) {
            if (f > 0) {
                if (expected == 0) {
                    expected = f;
                } else if (f != expected) {
                    return false;
                }
            }
        }

        return expected != 0;
    }
}