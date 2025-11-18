import java.util.Scanner;

public class Pattern16 {
    public static void main(String[] args) {
        System.out.println("Enter Size : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char currentChar = 'A';
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(currentChar);
            }
            System.out.println();
            currentChar++;
        }
    }
}
