import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class FindDuplicateTests {

    @ParameterizedTest
    @CsvSource({
            "1 3 2 2,2",
            "1 3 4 2 2,2",
            "3 1 3 4 2, 3",
            "3 3 3 3 3,3"
    })
    void find_duplicate_number(String inNumbers,String strExpected) {
        int[] numbers = Arrays.stream(inNumbers.split(" ")).mapToInt(Integer::parseInt).toArray();
        int expected = Integer.parseInt(strExpected);

        final Solution solution = new Solution();
        int duplicateNumber = solution.findDuplicateNumber(numbers);

        assertThat(duplicateNumber).isEqualTo(expected);
    }
}
