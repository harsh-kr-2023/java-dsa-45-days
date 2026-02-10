public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
    // Brute Force Approach
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (isUnique(s.substring(i, j))) {
                    maxLength = Math.max(maxLength, j - i);
                }
            }
        }
        return maxLength;
    }
    public static boolean isUnique(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }

    // Brute Force Approach - 2
    public static int lengthOfLongestSubstring2(String s) {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            String currentString = "";
            for (int j = i; j < s.length(); j++) {
                if (!currentString.contains(String.valueOf(s.charAt(j)))) {
                    currentString += s.charAt(j);
                    maxLength = Math.max(maxLength, currentString.length());
                } else {
                    break;
                }
            }
        }
        return maxLength;
    }
    // Optimised Approach using Sliding Window
    public static int lengthOfLongestSubstring3(String s) {
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
