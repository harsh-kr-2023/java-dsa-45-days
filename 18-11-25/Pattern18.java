import java.util.Scanner;

public class Pattern18 {
    public static void main(String[] args) {
        System.out.println("Enter Size : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            char currentChar = (char) ('A' + n - 1 - i);
            for (int j = 0; j <= i; j++) {
                System.out.print(currentChar + " ");
                currentChar++;
            }
            System.out.println();
        }
    }
}
