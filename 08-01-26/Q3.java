public class Q3 {
    public static void main(String[] args) {
        int x = 121;
        System.out.println(isPalindrome(x));
    }
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int num = x;
        int rev = 0;
        while (num > 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev == x;
    }
}
