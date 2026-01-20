public class LeetCode1323 { 
    public static void main(String[] args) {
        int num = 9669;
        System.out.println(maximum69Number(num));
    }
    public static int maximum69Number(int num) {
        String str = String.valueOf(num);
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '6') {
                arr[i] = '9';
                break;
            }
        }
        return Integer.parseInt(String.valueOf(arr));
    }
}