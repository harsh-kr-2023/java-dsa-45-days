import java.util.Scanner;

public class Divisors {
    public static void main(String[] args) {
        System.out.println("Enter Digit : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 1st pass → count number of divisors
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) count++;
        }

        // 2nd pass → fill divisors into array of exact size
        int[] result = new int[count];
        int index = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                result[index] = i;
                index++;
            }
        }
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
