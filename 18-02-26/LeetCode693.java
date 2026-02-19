public class LeetCode693 {
    public static void main(String[] args) {
        int n = 5;
        boolean result = hasAlternatingBits(n);
        System.out.println(result);
    }
    public static boolean hasAlternatingBits(int n) {
        String binary = Integer.toBinaryString(n);
        for (int i = 0; i < binary.length() - 1; i++) {
            if (binary.charAt(i) == binary.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
