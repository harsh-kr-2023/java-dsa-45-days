public class ArrayReverse {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        reverseArray(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
    // using recursion
    public static void reverseArray(int[] arr) {
        reverseHelper(arr, 0, arr.length - 1);
    }
    public static void reverseHelper(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reverseHelper(arr, start + 1, end - 1);
    }

    // with recursion and single pointer
    public static void reverseArraySinglePointer(int[] arr) {
        reverseHelperSinglePointer(arr, 0);
    }
    public static void reverseHelperSinglePointer(int[] arr, int start) {
        if (start >= arr.length / 2) {
            return;
        }
        int temp = arr[start];
        arr[start] = arr[arr.length - 1 - start];
        arr[arr.length - 1 - start] = temp;
        reverseHelperSinglePointer(arr, start + 1);
    }
}
