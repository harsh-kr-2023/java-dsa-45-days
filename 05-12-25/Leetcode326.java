public class Leetcode326 {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(27));
        System.out.println(isPowerOfThree(0));
        System.out.println(isPowerOfThree(9));
        System.out.println(isPowerOfThree(19));
    }
    static boolean isPowerOfThree(int n) {
        if(n == 1) return true;
        if(n <= 0 || n % 3 != 0) return false;
        return isPowerOfThree(n / 3);
    }
}
