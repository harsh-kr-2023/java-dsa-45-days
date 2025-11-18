import java.util.Scanner;

public class Pattern15 {
    public static void main(String[] args) {
        System.out.println("Enter Size : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = n-1; i >= 0; i--) {
            char currentChar = 'A';
            for (int j = 0; j <= i; j++) {
                System.out.print(currentChar);
                currentChar++;
            }
            System.out.println();
        }
    }
}
