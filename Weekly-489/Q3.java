import java.util.*;

public class Q3 {
    public static void main(String[] args) {
        System.out.println(almostPalindromic("abca"));    // 4
        System.out.println(almostPalindromic("abba"));    // 4
        System.out.println(almostPalindromic("zzabba"));  // 5
        System.out.println(almostPalindromic2("abc"));    // 2
    }

    public static int almostPalindromic(String s) {
        int n = s.length();
        int best = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int len = j - i + 1;
                if (len <= best) continue;
                if (canBePalindromeByRemovingOne(s, i, j)) {
                    best = len;
                }
            }
        }
        return best;
    }

    private static boolean canBePalindromeByRemovingOne(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1);
            }
        }
        return true;
    }

    private static boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    public static int almostPalindromic2(String s) {
        int n = s.length();
        if (n <= 1) return n;

        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            maxLen = Math.max(maxLen, expandWithOneSkip(s, i, i, n));
            maxLen = Math.max(maxLen, expandWithOneSkip(s, i, i + 1, n));
        }
        return maxLen;
    }

    private static int expandWithOneSkip(String s, int l, int r, int n) {
        while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        int currentMax = r - l - 1;

        if (l >= 0) {
            int l1 = l - 1, r1 = r;
            while (l1 >= 0 && r1 < n && s.charAt(l1) == s.charAt(r1)) {
                l1--;
                r1++;
            }
            currentMax = Math.max(currentMax, r1 - l1 - 1);
        }

        if (r < n) {
            int l2 = l, r2 = r + 1;
            while (l2 >= 0 && r2 < n && s.charAt(l2) == s.charAt(r2)) {
                l2--;
                r2++;
            }
            currentMax = Math.max(currentMax, r2 - l2 - 1);
        }

        return currentMax;
    }
}