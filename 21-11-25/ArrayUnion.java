
import java.util.ArrayList;

public class ArrayUnion {
    public static void main(String[] args) {
        int[] array1 = { 3, 4, 6, 7, 9, 9 };
        int[] array2 = { 1, 5, 7, 8, 8 };
        
        ArrayList<Integer> unionList = new ArrayList<>();
        // Add elements from the first array
        for (int num : array1) {
            if (!unionList.contains(num)){
                unionList.add(num);
            }
        }
        for (int num : array2) {
            if (!unionList.contains(num)) {
                unionList.add(num);
                unionList.sort(null);
            }
        }
        int[] unionArray = new int[unionList.size()];
        for (int i = 0; i < unionList.size(); i++) {
            unionArray[i] = unionList.get(i);
        }
        for (int num : unionArray) {
            System.out.print(num + " ");
        }
    }
}
