public class S2L21 {
    public static void main(String[] args) {
        System.out.println("Merge Sort");
        int[] arr = { 1, 2, -3, 4, 0, 7 };
        mergeSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static int[] mergeSort(int[] arr) {
        // find mid
        // divide
        // merge
        int low = 0;
        int high = arr.length-1;
        mergeSortAlgo(arr,low,high);
        return arr;
    }
}