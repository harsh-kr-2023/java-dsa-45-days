import java.util.HashMap;

public class ContainsDuplicateII {
    public static void main(String[] args) {
        int[] arr = { 1, 0, 1, 1 };
        int k = 1;
        System.out.println(containsNearbyDuplicate(arr, k));

    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(indexMap.containsKey(nums[i])) {
                if(i - indexMap.get(nums[i]) <= k){
                    return true;
                }
            }
            indexMap.put(nums[i], i);
        }
        return false;
    }
}