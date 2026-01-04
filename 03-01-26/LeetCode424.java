public class LeetCode424 {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s, k));
    }
    static int characterReplacement(String s, int k) {
        // Brute Force Approach
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substring = s.substring(i, j);
                if (canBeConverted(substring, k)) {
                    maxLength = Math.max(maxLength, substring.length());
                }
            }
        }
        return maxLength;
    }
    static boolean canBeConverted(String s, int k) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'A']++;
        }
        int maxCount = 0;
        for (int c : count) {
            maxCount = Math.max(maxCount, c);
        }
        return s.length() - maxCount <= k;
    }
}
