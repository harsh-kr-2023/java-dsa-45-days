import java.util.Arrays;

public class PermutationInString {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "lecabee";
        System.out.println(checkInclusion(s1, s2));
    }
    // Brute Force Approach using sorting
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        char[] s1Array = s1.toCharArray();
        Arrays.sort(s1Array);
        String sortedS1 = new String(s1Array);
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            String substring = s2.substring(i, i + s1.length());
            char[] substringArray = substring.toCharArray();
            Arrays.sort(substringArray);
            String sortedSubstring = new String(substringArray);
            if (sortedSubstring.equals(sortedS1)) {
                return true;
            }
        }
        return false;
    }
    // Optimised Approach using Sliding Window
    public static boolean checkInclusion2(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        // make a window of length of s1 on s2 and check if it is a permutation of s1
        int[] s1Count = new int[26];
        int[] windowCount = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            windowCount[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(s1Count, windowCount)) {
            return true;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            windowCount[s2.charAt(i) - 'a']++;
            windowCount[s2.charAt(i - s1.length()) - 'a']--;
            if (Arrays.equals(s1Count, windowCount)) {
                return true;
            }
        }
        return false;
    }
}
