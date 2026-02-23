import java.util.HashSet;
import java.util.Set;

public class LeetCode1461 {
    public static void main(String[] args) {
        String s = "001101110";
        int k = 2;
        System.out.println(hasAllCodes(s, k));
    }
    public static boolean hasAllCodes(String s, int k) {
        int total = 1 << k; // 2^k
        Set<String> set = new HashSet<>();

        for (int i = 0; i + k <= s.length(); i++) {
            String sub = s.substring(i, i + k);
            set.add(sub);
            if (set.size() == total) {
                return true;
            }
        }
        return false;
    }
}
