import java.util.Scanner;

public class Recursion1 {
    static void print(int n) {
        if (n < 0) {
            return;
        }
        System.out.println("Harsh");
        print(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("Enter n : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        print(n);
    }
}
