class BitOperations {
    public static void main(String[] args) {
        int n = 9;
        int i = 2;
        System.out.println(setIthBit(n, i));

        int n1 = 13;
        int i1 = 2;
        System.out.println(clearIthBit(n1, i1));

        int n2 = 13;
        int i2 = 1;
        System.out.println(toggleIthBit(n2, i2));

        int n3 = 12;
        System.out.println(removeLastSetBit(n3));

        int n4 = 16;
        System.out.println(countSetBits(n4));
    }

    static int setIthBit(int n, int i) {
        return (n | (1 << i));
    }

    static int clearIthBit(int n, int i) {
        return (n & ~(1 << i));
    }

    static int toggleIthBit(int n, int i) {
        return (n ^ (1 << i));
    }

    static int removeLastSetBit(int n) {
        return (n & (n - 1));
    }

    static int countSetBits(int n) {
        int counter = 0;
        while (n > 1) {
            // if (n % 2 == 1)
            //     counter++;

            counter += n & 1;

            // n /= 2;
            n = n >> 1;
        }
        if (n == 1)
            counter++;
        return counter;
    }
}
