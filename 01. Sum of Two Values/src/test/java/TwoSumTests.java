import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class TwoSumTests {

    @ParameterizedTest
    @CsvSource({
            "4 8 2 7 5 1,10,2 3",
            "5 5,10,1 2",
            "2 7 5 1,8,2 4"
    })
    void find_two_values_whose_sum_is_target_by_given_array_with_hashmap(String inputArray, int target, String expected) {
        int[] array = Arrays.stream(inputArray.split(" ")).mapToInt(Integer::parseInt).toArray();
        assertThat(TwoSum.findTwoValuesByHash(array, target)).contains(expected);
    }
}
