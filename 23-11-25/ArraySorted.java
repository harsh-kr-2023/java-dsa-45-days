public class ArraySorted {
    public static boolean isSorted(int[] arr) {
        int count = 0;
        for(int i=0;i<arr.length-1;i++) {
            if(arr[i] >arr[i+1]) {
                count++;
            }
        }
        if(arr[arr.length-1] > arr[0]) {
            count++;
        }  
        if(count > 1) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isSorted(new int[]{1,2,3,4}));
    }
}
