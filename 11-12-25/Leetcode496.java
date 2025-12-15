
import java.util.HashMap;
import java.util.Stack;

public class Leetcode496 {

    public static void main(String[] args) {
        int[] arr1 = { 4, 1, 2 };
        int[] arr2 = { 1, 3, 4, 2 };
        int[] arr = nextGreaterElement(arr1, arr2);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static int[] nextGreaterElement(int[] arr1, int[] arr2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = arr2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr2[i]) {
                stack.pop();
            }
            map.put(arr2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(arr2[i]);
        }
        int[] result = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            result[i] = map.get(arr1[i]);
        }
        return result;
    }
}
