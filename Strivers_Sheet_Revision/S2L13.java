public class S2L13 {
    public static void main(String[] args) {
        System.out.println("Insertion Sort");
        int[] arr = { 1, 2, -3, 4, 0, 7 };
        insertionSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static int[] insertionSort(int[] arr) {
        // ek element uthao aur usko sahi jagah pahuchao
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
