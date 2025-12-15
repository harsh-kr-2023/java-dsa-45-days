public class Q2 {
    public static void main(String[] args) {
        int n = 498639;
        int sum = sumOfFirstNPrimes(n);
        System.out.println("Sum of first " + n + " prime numbers is: " + sum);
    }

    // find sum of first n prime numbers
    public static int sumOfFirstNPrimes(int n) {
        int sum = 0;
        int lastPrime = 0;

        for (int num = 2; num <= n; num++) {
            if (isPrime(num)) {
                sum += num;

                if (sum <= n && isPrime(sum)) {
                    lastPrime = sum;
                }
            }
        }

        return lastPrime;
    }

    // helper method to check if a number is prime
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
