public class BinaryToInt {
    public static void main(String[] args) {
        String s = "1101";
        System.out.println(convertToInt(s));
    }

    static int convertToInt(String s) {
        int length = s.length();
        int result = 0;
        for (int i = 0; i < length; i++) {
            // int bit = s.charAt(length - 1 - i) - '0';
            // result += bit * Math.pow(2, i);
            int bit = s.charAt(i) - '0';
            result = result * 2 + bit;
        }
        return result;
    }
}
