
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem3 {
    public static void main(String[] args) {
        // int[] balance = { 1, 2, -5, 2 };
        int[] balance = { 5, 1, -4 };
        System.out.println(minMoves(balance));
    }

    static long minMoves(int[] balance) {
        // First case if solution is possible
        long sum = 0;
        for (int i : balance) {
            sum += i;
        }
        if (sum < 0)
            return -1;

        int n = balance.length;
        int negativeIndex = 0;
        for (int i = 0; i < n; i++) {
            if (balance[i] < 0) {
                negativeIndex = i;
                break;
            }
        }

        long demand = -balance[negativeIndex];

        List<Supply> sources = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (balance[i] > 0) {
                long supplyUnits = balance[i];
                int distance = Math.abs(i - negativeIndex);
                int cost = Math.min(distance, n - distance);
                sources.add(new Supply(supplyUnits, cost));
            }
        }

        sources.sort(Comparator.comparingInt(s -> s.cost));

        long totalMoves = 0;

        for (Supply s : sources) {
            if (demand <= 0) {
                break;
            }

            long unitsToTransfer = Math.min(demand, s.units);

            totalMoves += unitsToTransfer * s.cost;

            demand -= unitsToTransfer;
        }

        return totalMoves;
    }
}

class Supply {
    long units;
    int cost;

    public Supply(long u, int c) {
        this.units = u;
        this.cost = c;
    }
}