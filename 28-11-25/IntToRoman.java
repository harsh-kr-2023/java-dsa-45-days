public class IntToRoman {
    public static void main(String[] args) {
        int num = 3749;
        System.out.println(intToRoman(num));
    }
    public static String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        int[] values = {1000, 500, 100, 50, 10, 5, 1};
        String[] symbols = {"M", "D", "C", "L", "X", "V", "I"};

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                roman.append(symbols[i]);
                num -= values[i];
            }
        }
        return roman.toString();
    }
}
