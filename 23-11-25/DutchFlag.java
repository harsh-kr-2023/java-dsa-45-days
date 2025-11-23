public class DutchFlag {
    public static void main(String[] args) {
        int[] arr = {2,0,1,0,2,1,1,0};
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while(mid <= high) {
            switch (arr[mid]) {
                case 0 ->                     {
                        int temp = arr[low];
                        arr[low] = arr[mid];
                        arr[mid] = temp;
                        low++;
                        mid++;
                    }
                case 1 -> mid++;
                default ->                     {
                        int temp = arr[mid];
                        arr[mid] = arr[high];
                        arr[high] = temp;
                        high--;
                    }
            }
        }
        for(int num : arr) {
            System.out.print(num + " ");
        }
    }
}
