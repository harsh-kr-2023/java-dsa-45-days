import java.util.*;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "OUZODYXAZV";
        String t = "XYZ";
        System.out.println(minWindow(s, t));
    }

    // Brute Force Approach
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        String window = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (isWindowValid(s.substring(i, j), t)) {
                    if (window.isEmpty() || j - i < window.length()) {
                        window = s.substring(i, j);
                    }
                }
            }
        }
        return window;
    }

    public static boolean isWindowValid(String window, String t) {
        int[] windowCount = new int[128];
        int[] tCount = new int[128];
        for (char c : t.toCharArray()) {
            tCount[c]++;
        }
        for (char c : window.toCharArray()) {
            windowCount[c]++;
        }
        for (int i = 0; i < 128; i++) {
            if (tCount[i] > 0 && windowCount[i] < tCount[i]) {
                return false;
            }
        }
        return true;
    }

    // Optimised Approach using Sliding Window
    public static String minWindow2(String s, String t) {
        if (s.length() < t.length())
            return "";

        int[] tCount = new int[128];
        for (char c : t.toCharArray()) {
            tCount[c]++;
        }

        int required = 0;
        for (int i = 0; i < 128; i++) {
            if (tCount[i] > 0)
                required++;
        }

        int[] windowCount = new int[128];
        int formed = 0;

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            windowCount[c]++;

            if (tCount[c] > 0 && windowCount[c] == tCount[c]) {
                formed++;
            }

            while (formed == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                windowCount[leftChar]--;

                if (tCount[leftChar] > 0 && windowCount[leftChar] < tCount[leftChar]) {
                    formed--;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

}