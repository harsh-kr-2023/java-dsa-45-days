public class LeetCode394 {
    static int i = 0;

    public static void main(String[] args) {
        String s = "2[a2[b]]";
        System.out.println(decodeString(s));
    }

    static String decodeString(String s) {
        i = 0;
        return helper(s);
    }

    static String helper(String s) {
        StringBuilder result = new StringBuilder();
        int k = 0;
        while (i < s.length() && s.charAt(i) != ']') {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                k = 0;
                while (Character.isDigit(s.charAt(i))) {
                    k = k * 10 + (s.charAt(i) - '0');
                    i++;
                }
            } else if (c == '[') {
                i++;
                String sub = helper(s);
                i++;
                for (int j = 0; j < k; j++) {
                    result.append(sub);
                }
            } else {
                result.append(c);
                i++;
            }
        }
        return result.toString();
    }
}
