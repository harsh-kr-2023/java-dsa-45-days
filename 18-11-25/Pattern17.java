import java.util.Scanner;

public class Pattern17 {
    public static void main(String[] args) {
        System.out.println("Enter Size : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            char currentChar = 'A';
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(currentChar);
                currentChar++;
            }
            currentChar--;
            for (int j = 0; j < i; j++) {
                currentChar--;
                System.out.print(currentChar);
            }
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
