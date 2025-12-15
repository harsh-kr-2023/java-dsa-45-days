public class BitManipulation {
    public static void main(String[] args) {
        System.out.println(5 & 7);
        System.out.println(5 | 7);
        System.out.println(5 ^ 7);
        System.out.println(13 >> 2);
        System.out.println(13 << 2);

        int a = 5;
        int b = 6;
        swap(a, b);
    }

    static void swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a : " + a);
        System.out.println("b : " + b);
    }
}
