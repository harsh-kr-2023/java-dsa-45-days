import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q3 {
    public static void main(String[] args) {
        // int n = 4;
        // int[][] edges = {
        //         { 0, 1 },
        //         { 0, 2 },
        //         { 0, 3 }
        // };
        // int x = 1;
        // int y = 2;
        // int z = 3;
        int n = 4;
        int[][] edges = {
                { 0, 1 },
                { 1, 2 },
                { 2, 3 }
        };
        int x = 0;
        int y = 3;
        int z = 2;
        System.out.println(specialNodes(n, edges, x, y, z));
    }

    public static int specialNodes(int n, int[][] edges, int x, int y, int z) {
        List<List<Integer>> g = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++)
            g.add(new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g.get(u).add(v);
            g.get(v).add(u);
        }

        int[] dx = bfsDistance(n, g, x);
        int[] dy = bfsDistance(n, g, y);
        int[] dz = bfsDistance(n, g, z);

        int count = 0;
        for (int u = 0; u < n; u++) {
            int a = dx[u], b = dy[u], c = dz[u];
            int[] t = new int[] { a, b, c };
            Arrays.sort(t);
            long aa = t[0], bb = t[1], cc = t[2];
            if (aa * aa + bb * bb == cc * cc) {
                count++;
            }
        }
        return count;
    }

    private static int[] bfsDistance(int n, List<List<Integer>> g, int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dist[start] = 0;
        dq.add(start);

        while (!dq.isEmpty()) {
            int u = dq.poll();
            for (int v : g.get(u)) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    dq.add(v);
                }
            }
        }
        return dist;
    }
}
