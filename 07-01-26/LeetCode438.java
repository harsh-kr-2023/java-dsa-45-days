public class LeetCode438 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p));
    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length() - p.length(); i++) {
            if (matches(pCount, sCount)) {
                result.add(i);
            }
            sCount[s.charAt(i + p.length()) - 'a']++;
            sCount[s.charAt(i) - 'a']--;
        }
        if (matches(pCount, sCount)) {
            result.add(s.length() - p.length());
        }
        return result;
    }
    public static boolean matches(int[] pCount, int[] sCount) {
        for (int i = 0; i < 26; i++) {
            if (pCount[i] != sCount[i]) {
                return false;
            }
        }
        return true;
    }
}
