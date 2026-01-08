public class LeetCode424 {
    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        System.out.println(characterReplacement(s, k));
    }
    public static int characterReplacement(String s, int k) {
        // Sliding Window approach
        int left = 0, right = 0;
        int maxCount = 0; // Max frequency of a single character in the current window
        int[] count = new int[26]; // Frequency array for characters A-Z
        int maxLength = 0;
        while (right < s.length()) {
            count[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);
            // Current window size is right - left + 1
            // If we need to replace more than k characters, shrink the window from the left
            while (right - left + 1 - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}
