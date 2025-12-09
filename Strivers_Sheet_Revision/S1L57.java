public class S1L57 {
    public static void main(String[] args) {
        System.out.println("You are given an array. The task is to reverse the array and print it.");
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 3, 4, 5};
        int[] arr3 = {1, 2, 3, 4, 5};

        // Approach 1
        arr1 = reverseArrayNew(arr1);
        printArray(arr1);

        // Approach 2
        reverseArrayTwoPointer(arr2);
        printArray(arr2);

        // Approach 3
        reverseArrayRec(arr3, 0, arr3.length - 1);
        printArray(arr3);
    }

    // 1st approach – using new array
    static int[] reverseArrayNew(int[] arr) {
        int[] revArray = new int[arr.length];
        int j = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            revArray[j++] = arr[i];
        }
        return revArray;
    }

    // 2nd approach – two pointer (in place)
    static void reverseArrayTwoPointer(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            swap(arr, low, high);
            low++;
            high--;
        }
    }

    // 3rd approach – recursion
    static void reverseArrayRec(int[] arr, int low, int high) {
        if (low >= high) return;
        swap(arr, low, high);
        reverseArrayRec(arr, low + 1, high - 1);
    }

    // Helper Function
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void printArray(int[] arr) {
        for (int x : arr) System.out.print(x + " ");
        System.out.println();
    }
}
