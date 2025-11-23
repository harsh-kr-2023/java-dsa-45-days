public class RearrangeBySign {
    public static void main(String[] args) {
        int[] arr = { -1, 2, 3, -4, 5, -6, 7, -8 };
        // int[] arr = { 3, 1, -2, -5, 2, -4 };

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < 0 && i % 2 == 0) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                i++;
            }
            if (arr[i] >= 0 && i % 2 != 0) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                i++;
            }
        }
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
