public class NthRoot {
    public static void main(String[] args) {
        int N = 4;
        int M = 82;
        System.out.println(NthRoot(N, M));
    }

    public static int NthRoot(int N, int M) {
        if (N == 1) {
            return M;
        }
        int low = 1;
        int high = M/N;
        while(low<=high){
            int mid = (low+high)/2;
            if(Math.pow(mid, N) == M){
                return mid;
            } else if (Math.pow(mid, N) < M) {
                low = mid +1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }
}
