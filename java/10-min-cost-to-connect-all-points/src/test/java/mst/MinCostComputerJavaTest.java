package mst;

import net.jqwik.api.*;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.lang.Math.abs;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MinCostComputerJavaTest {
    MinCostComputerJava solution = new MinCostComputerJava();
    SlowerSolution slowerSolution = new SlowerSolution();

    @Test
    void compute_min_cost_to_make_all_points_connected_java_version() {
        int[][] points = new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}};
        int[][] points2 = new int[][]{{3,12},{-2,5},{-4,1},};

        MinCostComputerJava minCostComputer = new MinCostComputerJava();
        assertThat(minCostComputer.minCostConnectPoints(points)).isEqualTo(20);
        assertThat(minCostComputer.minCostConnectPoints(points2)).isEqualTo(18);
    }

    @Property(tries = 200)
    void optimized_version_should_match_slow_version(@ForAll("randomPoints") int[][] points) {
        int actual = solution.minCostConnectPoints(points);
        int expected = slowerSolution.minCostConnectPoints(points);

        assertEquals(expected, actual);
    }

    @Provide
    Arbitrary<int[][]> randomPoints() {
        Arbitrary<Integer> coordinate = Arbitraries.integers().between(-100, 100);

        return coordinate
                .array(int[].class)
                .ofSize(2)
                .array(int[][].class)
                .ofMinSize(1)
                .ofMaxSize(50);
    }

    public static class SlowerSolution {
        public int minCostConnectPoints(int[][] points) {
            int numberOfNodes = points.length;
            Map<Integer, int[]> nodes = new LinkedHashMap<>();
            int index = 1;
            for (int[] point : points) {
                nodes.put(index, point);
                index++;
            }
            int startNode = 1;
            int minDistance = 0;
            int minCost = 0;
            int minNode = startNode;
            Map<Integer, Boolean> visits = new LinkedHashMap<>();
            Map<Integer, int[]> frontier = new HashMap<>(nodes);
            visits.put(startNode, Boolean.TRUE);
            frontier.remove(startNode);
            for (int i = 0; i < numberOfNodes - 1; i++) {
                minDistance = Integer.MAX_VALUE;
                for (int visit : visits.keySet()) {
                    int[] nextNodeCoordinate = nodes.get(visit);
                    for (Map.Entry<Integer, int[]> entry : frontier.entrySet()) {
                        int neighboreNode = entry.getKey();
                        int[] neighboreCoordinate = entry.getValue();
                        int distance = abs(neighboreCoordinate[0] - nextNodeCoordinate[0]) + abs(neighboreCoordinate[1] - nextNodeCoordinate[1]);
                        if (distance < minDistance) {
                            minDistance = distance;
                            minNode = neighboreNode;
                        }
                    }
                }
                if (!visits.containsKey(minNode)) {
                    visits.put(minNode, Boolean.TRUE);
                    frontier.remove(minNode);
                    minCost += minDistance;
                }
            }
            return minCost;
        }
    }
}