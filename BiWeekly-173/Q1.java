public class Q1 {
    public static void main(String[] args) {
        String s = "wyuwyx";
        int k = 2;
        // Output: "bacd"
        System.out.println(reverseStr(s, k));
    }

    static String reverseStr(String s, int k) {
        // reverse only first k characters AND leave the other as it is AND RETURN THE NEW STRING
        char[] arr = s.toCharArray();
        int low = 0;
        int high = k - 1;
        while (low < high) {
            char temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
        return new String(arr);
    }
}
