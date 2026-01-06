public class Subsequence {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2};
        printSubsequences(arr);
    }
    // using recursion
    public static void printSubsequences(int[] arr) {
        printSubsequencesHelper(arr, 0, "");
    }
    public static void printSubsequencesHelper(int[] arr, int index, String current) {
        if (index == arr.length) {
            System.out.println(current);
            return;
        }
        // include the current element
        // System.out.println("Include " + arr[index] + " " + current);
        printSubsequencesHelper(arr, index + 1, current + arr[index] + " ");
        // exclude the current element
        // System.out.println("Exclude " + arr[index] + " " + current);
        printSubsequencesHelper(arr, index + 1, current);
    }
}
