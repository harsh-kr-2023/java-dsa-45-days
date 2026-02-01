import java.util.HashSet;
import java.util.Set;

public class Q2 {
    public static void main(String[] args) {
        int[] nums = { 1,1 };
        System.out.println(minimumK(nums));
    }

    public static int minimumK(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int x : nums) max = Math.max(max, x);

        int left = 1;
        int right = Math.max(max, n);
        int answer = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            long ops = 0;
            for (int x : nums) {
                ops += (x + mid - 1) / mid;
                if (ops > (long) mid * mid) break;
            }

            if (ops <= (long) mid * mid) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}