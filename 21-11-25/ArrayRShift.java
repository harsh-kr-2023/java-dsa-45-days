public class ArrayRShift {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5 };
        int k = 3;
        k = k % array.length; // Handle cases where k > array.length
        for (int j = 0; j < k; j++) {
            int temp = array[array.length - 1];
            for (int i = array.length - 1; i > 0; i--) {
                array[i] = array[i - 1];
            }
            array[0] = temp;
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}