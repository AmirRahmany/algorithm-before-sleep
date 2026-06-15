package mst;

import java.util.Arrays;

import static java.lang.Math.abs;

public class MinCostComputerJava {

    public int minCostConnectPoints(int[][] points) {
        int numberOfNodes = points.length;
        int minCost = 0;
        boolean[] visits = new boolean[numberOfNodes];
        int[] minDistances = new int[numberOfNodes];
        Arrays.fill(minDistances, Integer.MAX_VALUE);
        minDistances[0] = 0;

        for (int i = 0; i < numberOfNodes; i++) {
            int minDistance = Integer.MAX_VALUE;
            int minNode = -1;

            for (int node = 0; node < numberOfNodes; node++) {
                if (!visits[node] && minDistances[node] < minDistance) {
                    minDistance = minDistances[node];
                    minNode = node;
                }
            }

            visits[minNode] = true;
            minCost += minDistance;

            for (int neigborNode = 0; neigborNode < numberOfNodes; neigborNode++) {
                if (!visits[neigborNode]) {
                    final int x2 = points[neigborNode][0];
                    final int y2 = points[neigborNode][1];
                    int distance = abs(x2 - points[minNode][0]) + abs(y2 - points[minNode][1]);
                    if (distance < minDistances[neigborNode]) {
                        minDistances[neigborNode] = distance;
                    }
                }
            }
        }

        return minCost;
    }
}
