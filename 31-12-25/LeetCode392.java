public class LeetCode392 {
    public static void main(String[] args) {
        String s = "aqbc";
        String t = "ahbgdcq";
        boolean res = isSubsequence(s, t);
        System.out.println(res);
    }

    static boolean isSubsequence(String s, String t) {
        // Brute Force Approach
        // Pick first character from s and find it in t if yes then find next character, if not found, return false
        int i = 0;
        int j = 0;
        int n = s.length();
        int m = t.length();
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }
}
