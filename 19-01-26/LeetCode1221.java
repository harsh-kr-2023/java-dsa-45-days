public class LeetCode1221 {
    public static void main(String[] args) {
        String s = "RLRRLLRLRL";
        System.out.println(balancedStringSplit(s));
    }
    public static balancedStringSplit(String s) {
        int count = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'R') {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                res++;
            }
        }
        return res;
    }
}
