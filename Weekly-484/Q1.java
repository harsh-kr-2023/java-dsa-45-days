public class Q1 {
    public static void main(String[] args) {
        String s = "bob";
        System.out.println(residuePrefixes(s));
    }

    public static int residuePrefixes(String s) {
        int result = 0;
        StringBuffer prefix = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            prefix.append(s.charAt(i));
            int distinct_characters = countDistinct(prefix);
            if ((distinct_characters) == (prefix.length() % 3)) {
                result++;
            }
        }
        return result;
    }

    public static int countDistinct(StringBuffer prefix) {
        return (int) prefix.chars().distinct().count();
    }
}
