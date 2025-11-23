public class ReverseInt {
    public static int rev(int n) {
        int rev = 0;

        while (n != 0) {
            if(rev > (Integer.MAX_VALUE / 10)) {
                return 0;
            }
            if(rev < (Integer.MIN_VALUE /10)) {
                return 0;
            }
            int digit = n % 10;
            rev = rev * 10 + digit;
            n = n / 10;
        }
        return rev;
    }
    public static void main(String[] args) {
        System.out.println(rev(-1234569999));
    }
}
