import java.util.*;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow2(s, t));
    }

    // Brute Force Approach
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (isSubString(s.substring(i, j), t)) {
                    if (res.length() == 0 || res.length() > j - i) {
                        res = s.substring(i, j);
                    }
                }
            }
        }
        return res;
    }

    public static boolean isSubString(String s, String t) {
        if (s.length() < t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                if (map.get(s.charAt(i)) == 0) {
                    map.remove(s.charAt(i));
                }
            }
            if (map.isEmpty()) {
                return true;
            }
        }
        return false;
    }
    // Optimised Approach using Sliding Window
    public static String minWindow2(String s, String t){
        if (s.length() < t.length()) {
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0;
        int right = 0;
        int requiredCharsMissing = map.size();
        int bestWindowLength = Integer.MAX_VALUE;
        String bestWindow = "";

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            System.out.println("Expanding: right=" + right + ", char=" + rightChar);

            if (map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);
                if (map.get(rightChar) == 0) {
                    requiredCharsMissing--;
                }
            }

            while (requiredCharsMissing == 0) {
                int currentWindowLength = right - left + 1;
                String currentWindow = s.substring(left, right + 1);
                System.out.println("Valid window: [" + left + "," + right + "] -> " + currentWindow);

                if (bestWindowLength > currentWindowLength) {
                    bestWindowLength = currentWindowLength;
                    bestWindow = currentWindow;
                    System.out.println("Best updated: " + bestWindow);
                }

                char leftChar = s.charAt(left);
                System.out.println("Shrinking: left=" + left + ", char=" + leftChar);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) {
                        requiredCharsMissing++;
                    }
                }
                left++;
            }
            right++;
        }
        return bestWindow;
    }
}
