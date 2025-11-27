public class GCD {
    public static void main(String[] args) {
        int num1 = 240000;
        int num2 = 36000;
        System.out.println(gcd(num1, num2));
        System.out.println(gcd2(num1, num2));
    }

    public static int gcd(int num1, int num2) {
        int gcd = 1;
        for (int i = 1; i <= Math.min(num1, num2); i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    public static int gcd2(int num1, int num2) {
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }
}