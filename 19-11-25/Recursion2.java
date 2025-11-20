import java.util.Scanner;

public class Recursion2 {
    static void print(int n) {
        if (n < 1) {
            return;
        }
        print(n - 1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        System.out.println("Enter n : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        print(n);
    }
}
