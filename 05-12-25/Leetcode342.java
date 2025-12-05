public class Leetcode342 {
    public static void main(String[] args) {
        System.out.println(isPowerOfFour(4));
        System.out.println(isPowerOfFour(0));
        System.out.println(isPowerOfFour(16));
        System.out.println(isPowerOfFour(64));
    }
    static boolean isPowerOfFour(int n) {
        if(n == 1) return true;
        if(n <= 0 || n % 4 != 0) return false;
        return isPowerOfFour(n / 4);
    }
}
