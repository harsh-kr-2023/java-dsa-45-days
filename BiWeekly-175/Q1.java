import java.util.Arrays;

public class Q1 {
    public static void main(String[] args) {
        String s = "!@#$%^&*()";
        System.out.println(reverseByType(s));
    }

    public static String reverseByType(String s){
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;

        while (left < right) {
            if (!Character.isLetter(arr[left])) {
                left++;
            } else if (!Character.isLetter(arr[right])) {
                right--;
            } else {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        left = 0;
        right = arr.length - 1;

        while (left < right) {
            if (Character.isLetter(arr[left])) {
                left++;
            } else if (Character.isLetter(arr[right])) {
                right--;
            } else {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return new String(arr);
    }
}