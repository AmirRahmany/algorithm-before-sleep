import java.util.Arrays;

public class TravelAgency {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        final int INF = Integer.MAX_VALUE;
        Arrays.fill(dist, INF);
        dist[src] = 0;
        for (int step = 0; step <= k; step++) {
            int[] temp = dist.clone();
            for (int[] flight : flights) {
                final int u = flight[0];
                final int v = flight[1];
                final int cost = flight[2];
                if (dist[u] != INF && temp[v] > dist[u] + cost) {
                    temp[v] = dist[u] + cost;
                }
            }

            dist = temp;
        }

        return dist[dst] != INF ? dist[dst] : -1;
    }
}
