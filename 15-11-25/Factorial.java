
import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = factorial(n);
        System.out.println(result);
    }
    public static int factorial(int x)
    {
        if(x == 0 || x == 1)
        {
            return 1;
        }
        else {
            return x * factorial(x-1);
        }
    }
}
