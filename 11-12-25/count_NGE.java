
import java.util.ArrayList;
import java.util.List;

public class count_NGE {
    public static void main(String[] args) {
        int[] arr = { 3, 4, 2, 7, 5, 8, 10, 6 };
        int[] indices = { 0, 5 };
        List<Integer> result = countNextGreaterElements(arr, indices);
        for (int x : result) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    static List<Integer> countNextGreaterElements(int[] arr, int[] indices) {
        List<Integer> result = new ArrayList<>();
        for (int ind : indices) {
            int count = 0;
            for (int j = ind + 1; j < arr.length; j++) {
                if (arr[j] > arr[ind])
                    count++;
            }
            result.add(count);
        }
        return result;
    }
}
