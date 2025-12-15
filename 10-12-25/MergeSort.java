public class MergeSort {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };

        arr = mergeSort(arr); 

        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // ➡️ DIVIDE: Recursively splits the array into single elements (base case).
    static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];
        
        // Copy data into new left and right arrays
        System.arraycopy(arr, 0, left, 0, mid); // More concise copy
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        // Recursively sort halves and then merge them
        left = mergeSort(left);
        right = mergeSort(right);
        
        return merge(left, right);
    }

    // ⬅️ CONQUER: Merges two already sorted arrays into a single sorted array.
    static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0; // i for left, j for right, k for result
        
        // Compare elements from both arrays and put the smaller one into result
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        
        // Copy any remaining elements from the left or right array
        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }
        
        return result;
    }
}