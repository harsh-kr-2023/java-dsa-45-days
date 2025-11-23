
import java.util.ArrayList;

public class ArrayUnion {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {4,5,6,7,8};

        ArrayList<Integer> unionList = new ArrayList<>();
        for(int num : arr1) {
            if(!unionList.contains(num)) {
                unionList.add(num);
            }
        }
        for(int num : arr2) {
            if(!unionList.contains(num)) {
                unionList.add(num);
            }
        }
        System.out.print("Union of arrays: ");
        for(int num : unionList) {
            System.out.print(num + " ");
        }
    }
}
