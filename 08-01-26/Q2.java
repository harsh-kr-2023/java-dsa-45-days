public class Q2 {
    public static void main(String[] args) {
        int n = 8;
        System.out.println(pivotInteger(n));
    }

    public static int pivotInteger(int n) {
        int totalSum = n * (n + 1) / 2;
        int x = (int)Math.sqrt(totalSum);
        if(x * x == totalSum) return x;
        return -1;
    }
}
