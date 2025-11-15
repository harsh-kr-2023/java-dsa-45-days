import java.util.Scanner;

public class LinearSearch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements of array");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter element to search");
        int element = sc.nextInt();
        int flag = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == element) {
                flag = 1;
                break;
            }
        }
        if (flag == 1) {
            System.out.println("Found");
        } else {

            System.out.println("Not Found");
        }
    }
}
