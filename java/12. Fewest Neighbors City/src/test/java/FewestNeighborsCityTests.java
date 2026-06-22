import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FewestNeighborsCityTests {


    @ParameterizedTest
    @MethodSource("generatedCities")
    void find_the_city_with_the_smallest_number_of_neighbors_at_a_threshold_distance(int n, int[][] edges, int distanceThreshold, int output) {
        final SmallestNeighborCity smallestNeighborCity = new SmallestNeighborCity();
        var result = smallestNeighborCity.findTheCity(n, edges, distanceThreshold);
        Assertions.assertThat(result).isEqualTo(output);
    }


    public static Stream<Arguments> generatedCities() {
        return Stream.of(
                Arguments.of(
                        4,
                        new int[][]{{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}},
                        4,
                        3),
                Arguments.of(
                        5,
                        new int[][]{{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}},
                        2,
                        0));

    }
}
