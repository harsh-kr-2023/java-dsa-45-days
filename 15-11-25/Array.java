import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter sze of array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println(arr.length);
        System.out.println("Enter elements of array");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int largestNum = arr[0];
        for (int i = 0; i < n; i++) {
            if(arr[i] > largestNum){
                largestNum = arr[i];
            }
        }
        System.out.println(largestNum);
    }
}
