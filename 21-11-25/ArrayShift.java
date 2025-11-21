public class ArrayShift {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5 };
        int k = 3;
        k = k % array.length; // Handle cases where k > array.length
        for (int j = 0; j < k; j++) {
            int temp = array[0];
            for (int i = 0; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
            array[array.length - 1] = temp;
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}