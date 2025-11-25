public class SquareRoot {
    public static void main(String[] args) {
        int n = 50;
        System.out.println(func(n));
    }

    public static int func(int n) {
        if (n < 2) return n;
        int low = 1;
        int high = n / 2;
        int ans = 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid * mid == n) {
                return mid;
            } else if (mid * mid < n) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}