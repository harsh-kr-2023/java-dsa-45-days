import java.util.ArrayList;
import java.util.List;

public class LeetCode241 {
    public static void main(String[] args) {
        String expression = "2*3-4*5";
        int[] result = diffWaysToCompute(expression);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
    // Brute Force Approach - Pairing
    public static int[] diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String left = expression.substring(0, i);
                System.out.println(left);
                String right = expression.substring(i + 1);
                System.out.println(right);
                int[] leftResult = diffWaysToCompute(left);
                int[] rightResult = diffWaysToCompute(right);
                for (int leftValue : leftResult) {
                    for (int rightValue : rightResult) {
                        if (c == '+') {
                            result.add(leftValue + rightValue);
                            System.out.println("leftvalue: " + leftValue + " rightvalue: " + rightValue);
                        } else if (c == '-') {
                            result.add(leftValue - rightValue);
                            System.out.println("leftvalue: " + leftValue + " rightvalue: " + rightValue);
                        } else {
                            result.add(leftValue * rightValue);
                            System.out.println("leftvalue: " + leftValue + " rightvalue: " + rightValue);
                        }
                    }
                }
            }
        }
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
