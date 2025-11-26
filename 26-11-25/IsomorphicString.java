public class IsomorphicString {
    public static void main(String[] args) {
        String s1 = "paper";
        String s2 = "title";
        System.out.println(areIsomorphic(s1, s2)); // Output: true
    }

    public static boolean areIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] mapS = new int[256];
        int[] mapT = new int[256];

        System.out.println("Comparing strings: " + s + " and " + t);

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            System.out.println("Comparing characters: " + charS + " and " + charT);

            mapS[charS]++;
            mapT[charT]++;

            System.out.println("Mapping counts - mapS[" + charS + "] = " + mapS[charS] + ", mapT[" + charT + "] = " + mapT[charT] + ")");
            
            if (mapS[charS] != mapT[charT]) {
                System.out.println("Mismatch at index " + i + ": charS = " + charS + ", charT = " + charT);
                return false;
            }
        }
        return true;
    }
}