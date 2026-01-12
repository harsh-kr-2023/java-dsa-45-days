import java.util.*;

public class Q3 {
    public static void main(String[] args) {
        String[] words = { "fusion", "layout" };
        System.out.println(countPairsOptimized(words));
    }

    public static long countPairs(String[] words) {
        // Count Ceaser Cipher Pairs
        long result = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isCeaserCipher(words[i], words[j])) {
                    result++;
                }
            }
        }
        return result;
    }

    public static boolean isCeaserCipher(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        if (word1.equals(word2)) {
            return true;
        }
        int n = word1.length();
        // Calculate the shift needed for first character
        // Note: shift could be negative, so we use modulo arithmetic
        int shift = (word2.charAt(0) - word1.charAt(0) + 26) % 26;

        // Verify this shift works for all characters
        for (int i = 0; i < n; i++) {
            char expected = (char) ((word1.charAt(i) - 'a' + shift) % 26 + 'a');
            if (expected != word2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    // Optimized Sol
    public static long countPairsOptimized(String[] words) {
        Map<String, Integer> freq = new HashMap<>();
        long result = 0;
        for (String word : words) {
            String s = getShifted(word);
            int count = freq.getOrDefault(s, 0);
            result += count;
            freq.put(s, count + 1);
        }
        return result;
    }

    public static String getShifted(String word) {
        if (word.length() <= 1) {
            return ""; // Empty string for single character or empty word
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < word.length(); i++) {
            int diff = (word.charAt(i) - word.charAt(i - 1) + 26) % 26;
            // Encode as character to create a compact signature
            sb.append((char) ('a' + diff));
        }
        return sb.toString();
    }

}
