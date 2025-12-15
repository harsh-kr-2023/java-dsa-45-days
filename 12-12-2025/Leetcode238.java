public class Leetcode238 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int[] result = product(arr);
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static int[] product(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        // for (int i = 0; i < n; i++) {
        //     int product = 1;
        //     for (int j = 0; j < n; j++) {
        //         if (i != j) {
        //             System.out.println(product + " " + arr[i] + " " + arr[j]);
        //             product *= arr[j];
        //         }
        //     }
        //     result[i] = product;
        // }
        // return result;

        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i-1] * arr[i-1];
        }

        int suffix = 1;
        for (int i = n-1; i >= 0; i--) {
            result[i] = result[i] * suffix;
            suffix *= arr[i];
        }
        return result;
    }
}