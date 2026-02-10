public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s, k));
    }
    // Brute Force Approach
    public static int characterReplacement(String s, int k) {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (isReplacementPossible(s.substring(i, j), k)) {
                    maxLength = Math.max(maxLength, j - i);
                }
            }
        }
        return maxLength;
    }
    public static boolean isReplacementPossible(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int maxFreq = 0;
        for (int value : map.values()) {
            maxFreq = Math.max(maxFreq, value);
        }
        return s.length() - maxFreq <= k;
    }

    // Optimised Approach using Sliding Window
    public static int characterReplacement2(String s, int k) {
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            while (right - left + 1 - Collections.max(map.values()) > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
    // Optimised Approach using Sliding Window - 2
    public static int characterReplacement3(String s, int k) {
        int left = 0, right = 0;
        int maxCount = 0;
        int maxLength = 0;
        int[] count = new int[26];
        while (right < s.length()) {
            count[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);
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
