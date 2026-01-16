public class LeetCode1922 {
    public static void main(String[] args) {
        long n = 50;
        int result = countGoodNumbers(n);
        System.out.println(result);
    }
    public static int countGoodNumbers(long n) {
        long mod = 1000000007;
        long even = (n + 1)/2;
        long odd = n/2;

        long result = (pow(5, even) * pow(4, odd)) % mod;
        return (int) result;
    }
    public static long pow(long base, long exp) {
        if(exp == 0) {
            return 1;
        }
        long half = pow(base, exp/2);
        long result = (half * half) % 1000000007;

        if(exp % 2 == 1) {
            result = (result * base) % 1000000007;
        }
        return result;
    }
}
