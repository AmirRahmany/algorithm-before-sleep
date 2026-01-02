import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

class SubarraySortTest {


    @ParameterizedTest
    @CsvSource({
            "2 6 4 8 10 9 15,5",
            "1 2 3 4,0",
            "1,0",
            "1 3 2 2 2,4",
            "1 2 3 3 3,0",
            "1 2 3 3 2 4 5,3",
            "1 5 3 4 2 6 7,4",
            "2 1,2",
            "2 3 3 2 4,3",
            "1 2 4 5 3,3",
            "1 3 5 4 2 6 7 8,4",
            "1 2 2 2 1,4",
            "1 3 5 2 4,4",
            "5 4 3 2 1,5"
    })
    void find_the_length_of_unsorted_subarray_in_main_array(String inputArray, String subarrayLength) {
        final SubarraySort subarraySort = new SubarraySort();
        int[] array = Arrays.stream(inputArray.split(" ")).mapToInt(Integer::parseInt).toArray();
        int unsortedSubArrayLength = subarraySort.findUnsortedSubarray(array);

        Assertions.assertThat(unsortedSubArrayLength).isEqualTo(Integer.parseInt(subarrayLength));
    }
}
