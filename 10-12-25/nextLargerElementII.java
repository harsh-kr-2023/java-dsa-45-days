import java.util.Stack;

public class nextLargerElementII {
    public static void main(String[] args) {
        int[] arr = { 3, 10, 4, 2, 1, 2, 6, 1, 7, 2, 9 };
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
    // // Check from i+1 to end
    // for (int j = i + 1; j < arr.length; j++) {
    // if (arr[j] > arr[i]) {
    // result[i] = arr[j];
    // break;
    // }
    // }
    // // If not found, check from beginning to i-1
    // if (result[i] == -1) {
    // for (int j = 0; j < i; j++) {
    // if (arr[j] > arr[i]) {
    // result[i] = arr[j];
    // break;
    // }
    // }
    // }
    // }
    // return result;
    // }

    // Second approach is using stack
    static int[] nextLargerElements(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i % n]) {
                stack.pop();
            }
            if (i < n) {
                if (stack.isEmpty()) {
                    result[i] = -1;
                } else {
                    result[i] = stack.peek();
                }
            }
            stack.push(arr[i % n]);
        }
        return result;
    }
}