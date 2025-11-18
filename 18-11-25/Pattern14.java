import java.util.Scanner;

public class Pattern14 {
    public static void main(String[] args) {
        System.out.println("Enter Size : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            char currentChar = 'A';
            for (int j = 1; j <= i; j++) {
                System.out.print(currentChar);
                currentChar++;
            }
            System.out.println();
        }
    }
}
