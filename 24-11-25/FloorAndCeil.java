public class FloorAndCeil {
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        int x = 5;
        int[] result = getFloorAndCeil(arr, x);
        System.out.println("Floor: " + result[0] + ", Ceil: " + result[1]);
    }
    public static int[] getFloorAndCeil(int[] nums, int x) {
        int[] newArr = new int[2];
        for(int i=0; i<nums.length; i++){
            if(nums[i] == x){
                newArr[0] = nums[i];
                newArr[1] = nums[i];
                break;
            }
            if(nums[i] >= x){
                newArr[0] = nums[i-1];
                newArr[1] = nums[i];
                break;
            }
        }
        return newArr;
    }
}
