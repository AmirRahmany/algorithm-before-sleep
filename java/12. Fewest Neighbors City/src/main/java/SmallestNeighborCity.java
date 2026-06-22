import java.util.Arrays;
import java.util.stream.IntStream;

public class SmallestNeighborCity {
    private static final int INF = 1_000_000_000;

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        setupDistanceMatrix(n, dist);

        populateDirectEdges(edges, dist);

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (dist[i][k] == INF) continue;
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        int[] numberOfNeighbors = countNeighborsWithThreshold(dist, distanceThreshold);

        return getCityWithMinNeighbors(n, numberOfNeighbors);
    }

    private static void setupDistanceMatrix(int n, int[][] dist) {
        for (int[] d : dist) {
            Arrays.fill(d, INF);
        }
        for (int i = 0; i < n; i++) {
            dist[i][i] = 0;
        }
    }

    private static void populateDirectEdges(int[][] edges, int[][] dist) {
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            dist[u][v] = w;
            dist[v][u] = w;
        }
    }

    private static int[] countNeighborsWithThreshold(int[][] dist, int distanceThreshold) {
        int[] numberOfNeighbors = new int[dist.length];
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist.length; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) numberOfNeighbors[i]++;
            }
        }
        return numberOfNeighbors;
    }

    private static int getCityWithMinNeighbors(int n, int[] numberOfNeighbor) {
        return IntStream.range(0, n)
                .reduce((cityA, cityB) -> numberOfNeighbor[cityB] <= numberOfNeighbor[cityA] ? cityB : cityA)
                .orElse(0);
    }

}
