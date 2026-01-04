public class Q1 {
    public static void main(String[] args) {
        String s = "11";
        System.out.println(largestEvenNumber(s));
    }

    static String largestEvenNumber(String digits) {
        char[] arr = digits.toCharArray();
        int n = arr.length;
        int evenIndex = -1;

        // Find the rightmost even digit
        for (int i = n - 1; i >= 0; i--) {
            if ((arr[i] - '0') % 2 == 0) {
                evenIndex = i;
                break;
            }
        }

        // If no even digit is found, return -1
        if (evenIndex == -1) {
            return "";
        }

        // delete the digits after last even digit
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i <= evenIndex) {
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }
}
