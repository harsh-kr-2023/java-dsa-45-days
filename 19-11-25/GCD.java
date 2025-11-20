import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
        System.out.println("Enter first Digit : ");
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        System.out.println("Enter second Digit : ");
        int n = sc.nextInt();
        int gcd = 1;
        for (int i = 1; i <= Math.min(m, n); i++) {
            if ((m % i == 0) && (n % i == 0)) {
                gcd = Math.max(gcd, i);
            }
        }
        System.out.println(gcd);
    }
}
