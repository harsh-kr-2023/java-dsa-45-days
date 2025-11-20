import java.util.Scanner;

public class Armstrong {
    public static void main(String[] args) {
        System.out.println("Enter Digit : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int temp = n;
        int count = 0;
        while (n > 0) {
            n /= 10;
            count++;
        }
        temp = n;
        int sum = 0;
        while (temp > 0) {
            int rem = temp % 10;
            // sum += rem ^ count;
            sum += Math.pow(rem, count);
            temp /= 10;
        }
        System.out.println(n == sum);
    }
}
