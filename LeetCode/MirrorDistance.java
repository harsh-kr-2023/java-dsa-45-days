public class MirrorDistance {
    public static void main(String[] args) {
        int n = 25;
        System.out.println(mirrorDistance(n));
    }
    static int mirrorDistance(int n) {
        reverseDigits(n);
        return Math.abs(n - reverseDigits(n));
    }
    static int reverseDigits(int n) {
        int reversed = 0;
        while (n != 0) {
            int digit = n % 10;
            reversed = reversed * 10 + digit;
            n /= 10;
        }
        return reversed;
    }
}
