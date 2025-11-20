import java.util.Scanner;

public class Recursion5 {
    static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int res = n * factorial(n - 1);
        return res;
    }

    public static void main(String[] args) {
        System.out.println("Enter n : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(factorial(n));
    }
}
