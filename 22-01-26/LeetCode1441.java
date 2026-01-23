import java.util.ArrayList;
import java.util.List;

public class LeetCode1441 {
    public static void main(String[] args) {
        int[] target = {1, 3};
        int n = 3;
        System.out.println(buildArray(target, n));
    }
    public static List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int current = 1;
        for (int i = 0; i < target.length; i++) {
            while (current < target[i]) {
                result.add("Push");
                result.add("Pop");
                current++;
            }
            result.add("Push");
            current++;
        }
        return result;
    }

}
