import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println("Enter Digit : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int og = n;
        int reversedNum = 0;
        while (n > 0) {
            reversedNum = (reversedNum * 10) + (n % 10);
            n /= 10;
        }
        System.out.println(reversedNum == og);
    }
}
