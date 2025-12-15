public class S2L12 {
    public static void main(String[] args) {
        System.out.println("Bubble Sort");
        int[] arr = { 2, 3, 6, -1, 0, 5 };
        bubbleSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    System.out.println("Swapping " + arr[j] + " with " + arr[j + 1]);
                    swap(arr, j, j + 1);
                }
            }
        }
        return arr;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
