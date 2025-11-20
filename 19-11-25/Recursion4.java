import java.util.Scanner;

public class Recursion4 {
    static int printSum(int n) {
        if (n == 0) {
            return 0;
        }
        int sum = n + printSum(n - 1);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Enter n : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(printSum(n));
    }
}
