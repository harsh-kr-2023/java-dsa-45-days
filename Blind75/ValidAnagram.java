public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }
    // Brute Force Approach
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        // convert to char array, traverse one and try to find char in t and if found delete char to avoid duplicates
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        for (char c : sArray) {
            if (t.contains(String.valueOf(c))) {
                t = t.replaceFirst(String.valueOf(c), "");
            } else {
                return false;
            }
        }
        return t.isEmpty();
    }
    // Optimised Approach using HashMap
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) {
                map.remove(c);
            }
        }
        return map.isEmpty();
    }
    // Optimised Approach using Sorting
    public static boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] s = s.toCharArray();
        char[] t = t.toCharArray();
        Arrays.sort(s);
        Arrays.sort(t);
        return Arrays.equals(s, t);
    }
}
