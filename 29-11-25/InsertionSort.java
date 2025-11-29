public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = { 64, 25, 12, 22, 1, 31 };
        insertionSort(arr);
        System.out.println("Sorted array:");
        printArray(arr);
    }

    // Helper function - print array
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Insertion Sort function
    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }
}