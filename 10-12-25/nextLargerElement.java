import java.util.Stack;

public class nextLargerElement {
    public static void main(String[] args) {
        int[] arr = { 6, 8, 0, 1, 3 };
        int[] result = nextLargerElements(arr);
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // First approach is naive and brute force

    // static int[] nextLargerElements(int[] arr) {
    // int[] result = new int[arr.length];
    // for (int i = 0; i < arr.length; i++) {
    // result[i] = -1;
    // for (int j = i + 1; j < arr.length; j++) {
    // if (arr[j] > arr[i]) {
    // result[i] = arr[j];
    // break;
    // }
    // }
    // }
    // return result;
    // }

    // Second approach is using stack
    static int[] nextLargerElements(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
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