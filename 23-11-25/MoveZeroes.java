public class MoveZeroes {
    public static int[] move(int[] nums) {
        int left = 0;
        for(int right=0;right<nums.length;right++){
            if(nums[right] != 0){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }
        return nums;
    }
    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        int[] result = move(arr);
        System.out.print("Array after moving zeroes: ");
        for(int num : result){
            System.out.print(num + " ");
        }
    }
}
