import java.util.Scanner;

public class Recursion3 {
    static void print(int n) {
        if (n < 1) {
            return;
        }
        System.out.println(n);
        print(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("Enter n : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        print(n);
    }
}
