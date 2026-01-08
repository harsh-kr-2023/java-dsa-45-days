import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 5, 7, 9, 1};
        quickSort(arr, 0, arr.length - 1, 0);

        System.out.println("\nFINAL SORTED ARRAY:");
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] arr, int low, int high, int depth) {
        print(depth, "quickSort(" + low + ", " + high + ")");

        if (low >= high) {
            print(depth, "Base case reached");
            return;
        }

        int pivotIndex = partition(arr, low, high, depth);
        print(depth, "Pivot fixed at index " + pivotIndex);
        print(depth, "Array now: " + Arrays.toString(arr));

        quickSort(arr, low, pivotIndex - 1, depth + 1);
        quickSort(arr, pivotIndex + 1, high, depth + 1);
    }

    static int partition(int[] arr, int low, int high, int depth) {

        int pivot = arr[high];
        int i = low - 1;

        print(depth, "Partitioning from " + low + " to " + high);
        print(depth, "Pivot = " + pivot);

        for (int j = low; j < high; j++) {
            print(depth, "Compare arr[" + j + "]=" + arr[j] + " with pivot");

            if (arr[j] < pivot) {
                i++;
                print(depth, "  Swap arr[" + i + "] and arr[" + j + "]");
                swap(arr, i, j);
                print(depth, "  Array: " + Arrays.toString(arr));
            }
        }

        print(depth, "Final swap pivot into position " + (i + 1));
        swap(arr, i + 1, high);
        print(depth, "After pivot swap: " + Arrays.toString(arr));

        return i + 1;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void print(int depth, String msg) {
        for (int i = 0; i < depth; i++) {
            System.out.print("│   ");
        }
        System.out.println(msg);
    }
}
