
import java.util.Stack;

public class NSE {
    public static void main(String[] args) {
        int[] arr = { 4, 8, 5, 2, 25 };
        arr = nextSmallerElements(arr);
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    static int[] nextSmallerElements(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return result;
    }
}
