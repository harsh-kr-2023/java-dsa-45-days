public class MergeSort {
    public static void main(String[] args) {
        int[] arr = { 64, 25, 12, 22, 1, 31 };
        int n = arr.length - 1;
        mergeSort(arr, 0, n);
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
    public static void mergeSort(int[] arr, int left, int right) {
        if(left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    public static void merge(int[] arr, int left, int mid, int right){
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for(int i=0; i < n1; i++){
            leftArr[i] = arr[left + i];
        }
        for(int i=0; i < n2; i++){
            rightArr[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0, k = left;

         while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
        
        // Copy remaining elements of leftArray if any
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        
        // Copy remaining elements of rightArray if any
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
}