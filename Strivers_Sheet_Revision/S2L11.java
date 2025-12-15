public class S2L11 {
    public static void main(String[] args) {
        System.out.println("Selection Sort");
        int[] arr = { 4, 3, 5, 6, 1, 2 };
        int[] sortedArr = selectionSort(arr);

        for (int i : sortedArr) {
            System.out.print(i + " ");
        }
    }

    static int[] selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
        int smallest = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[smallest]) {
                    smallest = j;
                }
            }
            swap(arr, i, smallest);
        }
        return arr;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
