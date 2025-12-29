import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ValidateSubsequenceTests {

    @ParameterizedTest
    @CsvSource({
            "1 2 3 4,2 4",
            "5 1 22 25 6 -1 8 10,1 6 -1 10",
            "5 1 2 3 9,1 2 3",
            "1 2 2 3,1 2 3"
    })
    void determine_given_array_is_subsequence_of_main_array(String sequence,String inputSubsequence) {
        int[] array = Arrays.stream(sequence.split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] subsequence = Arrays.stream(inputSubsequence.split(" ")).mapToInt(Integer::parseInt).toArray();

        final ValidateSubsequence validateSubsequence = new ValidateSubsequence();
        boolean isValid = validateSubsequence.isValidSubsequence(array,subsequence);

        assertThat(isValid).isTrue();
    }

    @ParameterizedTest
    @CsvSource({
            "1 2 3 4 5,1 4 3",
            "5 6 1 7 8 2 4 3,1 3 4",
            "1 2 3,1 4 4",
            "1 2,2 3"
    })
    void determine_a_given_sequence_is_not_subsequence_of_array(String sequence,String inputSubsequence) {
        int[] array = Arrays.stream(sequence.split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] subsequence = Arrays.stream(inputSubsequence.split(" ")).mapToInt(Integer::parseInt).toArray();

        final ValidateSubsequence validateSubsequence = new ValidateSubsequence();
        boolean isValid = validateSubsequence.isValidSubsequence(array,subsequence);

        assertThat(isValid).isFalse();
    }
}
