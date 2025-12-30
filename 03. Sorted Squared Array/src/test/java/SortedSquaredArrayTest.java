import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.stream.Stream;

class SortedSquaredArrayTest {

    @ParameterizedTest
    @CsvSource({
            "-4 -1 0 3 10,0 1 9 16 100",
            "-7 -3 2 3 11,4 9 9 49 121"
    })
    void name(String input, String inputSorted) {
        final String separator = " ";
        int[] array = Arrays.stream(input.split(separator)).mapToInt(Integer::parseInt).toArray();
        int[] expectedSortedArray = Arrays.stream(inputSorted.split(separator)).mapToInt(Integer::parseInt).toArray();

        final SortedSquaredArray sortedSquaredArray = new SortedSquaredArray();

        Assertions.assertThat(sortedSquaredArray.sortedSquare(array)).isEqualTo(expectedSortedArray);
    }
}
