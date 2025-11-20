import java.util.Scanner;

public class DigitCount {
    public static void main(String[] args) {
        System.out.println("Enter Digit : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        while (n > 0) {
            n /= 10;
            count++;
        }
        System.out.println(count);
    }
}