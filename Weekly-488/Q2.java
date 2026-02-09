import java.util.ArrayList;
import java.util.List;

public class Q2 {
    public static void main(String[] args) {
        // int[] numbers = {3, 1, 1, 2 };
        int[] numbers = { 4, 4, 1, 1, 1, 1, 2 };
        System.out.println(mergeAdjacent(numbers));
    }

    public static List<Long> mergeAdjacent(int[] nums) {
        List<Long> stack = new ArrayList<>();

        for (int num : nums) {
            long curr = num;

            while (!stack.isEmpty() && stack.get(stack.size() - 1) == curr) {
                curr += stack.remove(stack.size() - 1);
            }

            stack.add(curr);
        }

        return stack;
    }
}