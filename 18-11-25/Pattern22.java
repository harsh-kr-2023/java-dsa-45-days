import java.util.Scanner;

public class Pattern22 {
    public static void main(String[] args) {
        System.out.println("Enter Size : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == n - 1) {
                    System.out.print(n-2);
                } else {
                    System.out.print(n-2-i);
                }
            }
            System.out.println();
        }
    }
}
