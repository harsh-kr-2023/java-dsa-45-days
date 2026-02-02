public class Q1 {
    public static void main(String[] args) {
        int n = 9;
        System.out.println(countMonobit(n));
    }
    public static int countMonobit(int n) {
        // An integer is monobit if all its bits are the same (either all 0s or all 1s)
        if(n == 0) return 1; // only 0 is monobit
        if(n == 1) return 2; // 0 and 1 are monobit
        int count = 2; // for 0 and 1
        int monobit = 1;
        while(true) {
            monobit = (monobit << 1) | 1; // generate next monobit number
            if(monobit <= n) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
