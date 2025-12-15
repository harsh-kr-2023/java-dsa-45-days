public class CheckIthBit {
    public static void main(String[] args) {
        int n = 13;
        int i = 2;
        System.out.println(isIthBitSet(n, i));
    }

    static boolean isIthBitSet(int n, int i) {
        // Left Shift
        // if ((n & (1 << i)) != 0) {
        // return true;
        // }
        // return false;

        // Right Shift
        if ((1 & (n >> i)) == 0) {
            return false;
        }
        return true;
    }
}
