public class LeetCode1456 {
    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;
        int result = maxVowels(s, k);
        System.out.println(result);
    }
    public static int maxVowels(String s, int k) {
        // Sliding Window Approach
        int maxVowelCount = 0;
        int vowelCount = 0;
        int n = s.length();
        // Initialize the first window and count vowels
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                vowelCount++;
            }
        }
        maxVowelCount = vowelCount;
        // Slide the window across the string
        for (int i = k; i < n; i++) {
            // Remove the character going out of the window
            if (isVowel(s.charAt(i - k))) {
                vowelCount--;
            }
            // Add the character coming into the window
            if (isVowel(s.charAt(i))) {
                vowelCount++;
            }
            // Update max vowel count if needed
            maxVowelCount = Math.max(maxVowelCount, vowelCount);
        }
        return maxVowelCount;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
