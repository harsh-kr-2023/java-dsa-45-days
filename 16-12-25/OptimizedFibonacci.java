public class OptimizedFibonacci {
    public static void main(String[] args) {
        System.out.println(climbStairs(45));
    }
    static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int a = 1;
        int b = 2;

        for (int i = 3; i <= n; i++) {
            int sum = a + b;
            System.out.println("Sum in " + i + "th iteration is " + sum);
            a = b;
            b = sum;
        }
        return b;
    }
}
