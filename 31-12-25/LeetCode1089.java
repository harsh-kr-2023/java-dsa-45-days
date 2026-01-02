public class LeetCode1089 {
    public static void main(String[] args) {
        int[] arr = { 1, 0, 2, 3, 0, 4, 5, 0 };
        // int[] res = duplicateZeroes(arr);
        int[] res = duplicateZeroesOptimized(arr);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    // Brute Force
    static int[] duplicateZeroes(int[] arr) {
        int n = arr.length;
        int pointer = 0;
        while (pointer < n) {
            if (arr[pointer] == 0) {
                // duplicate zero and shift elements to 1 index right
                for (int i = n - 1; i > pointer; i--) {
                    arr[i] = arr[i - 1];
                }
                pointer++;
            }
            pointer++;
        }
        return arr;
    }

    // Optimized Approach using 2 pointers
    static int[] duplicateZeroesOptimized(int[] arr) {
        // find last element then write backward
        int n = arr.length;
        int virtualLen = 0;
        int i = 0;

        while (i < n && virtualLen < n) {
            if (arr[i] == 0) {
                virtualLen += 2;
            } else {
                virtualLen++;
            }
            i++;
        }

        int write = n - 1;
        int read = i - 1;

        if (virtualLen > n && arr[read] == 0) {
            arr[write] = 0;
            write--;
            read--;
        }

        while (read >= 0) {
            if (arr[read] == 0) {
                arr[write--] = 0;
                arr[write--] = 0;
            } else {
                arr[write--] = arr[read];
            }
            read--;
        }
        return arr;
    }
}