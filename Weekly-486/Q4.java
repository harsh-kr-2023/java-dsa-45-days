public class Q4 {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        System.out.println(nthSmallest(n, k));
    }

    public static long nthSmallest(int n, int k) {
        long[][] C = new long[51][51];

        for (int i = 0; i <= 50; i++) {
            C[i][0] = C[i][i] = 1;
            for (int j = 1; j < i; j++) {
                C[i][j] = Math.min((long) 1e18, C[i - 1][j - 1] + C[i - 1][j]);
            }
        }

        long result = 0;

        for (int pos = 49; pos >= 0 && k > 0; pos--) {
            long count = C[pos][k];

            if (count >= n) {
                continue;
            } else {
                result |= (1L << pos);
                n -= count;
                k--;
            }
        }
        return result;
    }
}