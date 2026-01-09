import java.lang.reflect.Array;
import java.util.Arrays;

public class Q1 {
    public static void main(String[] args) {
        int[] arr = {3,5,1};
        System.out.println(canMakeArithmeticProgression(arr));
    }
    public static boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length <= 2) {
            return true;
        }
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] != diff) {
                return false;
            }
        }
        return true;
    }
}
