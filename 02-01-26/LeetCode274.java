import java.lang.reflect.Array;
import java.util.Arrays;

public class LeetCode274 {
    public static void main(String[] args) {
        // int[] citations = { 3, 0, 6, 1, 5 };
        // int[] citations = { 1, 3, 1 };
        // int[] citations = { 100 };
        int[] citations = { 3, 4, 5, 8, 10 };
        System.out.println(hIndex(citations));
    }

    static int hIndex(int[] citations) {
        int n = citations.length;
        // sort the array
        Arrays.sort(citations);
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n - i) {
                return n - i;
            }
        }
        return 0;
    }
}
