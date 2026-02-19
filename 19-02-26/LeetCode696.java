public class LeetCode696 {
    public static void main(String[] args) {
        System.out.println(countBinarySubstrings("00110011")); // 6
    }

    // Brute force solution
    public static int countBinarySubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) { // <= is important
                if (isValid(s.substring(i, j))) {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean isValid(String s) {
        int n = s.length();
        if (n % 2 != 0) return false; // must be even length

        int mid = n / 2;
        char first = s.charAt(0);
        char second = s.charAt(mid);

        if (first == second) return false; // should be 0...1... or 1...0...

        // first half all same
        for (int i = 0; i < mid; i++) {
            if (s.charAt(i) != first) return false;
        }

        // second half all same
        for (int i = mid; i < n; i++) {
            if (s.charAt(i) != second) return false;
        }

        return true;
    }
}
