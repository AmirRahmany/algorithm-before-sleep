import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CandyTest {

    @ParameterizedTest
    @CsvSource({
            "1 0 2,5",
            "1 2 2,4",
            "1 3 2 2 1,7",
            "1 2 87 87 87 2 1,13",
            "1 3 4 5 2,11"
    })
    void return_the_minimum_number_of_candies_to_distribute_candy_to_children(String inputRatings,String expectedCandy) {
        final Candy candy = new Candy();
        int[] ratings = Arrays.stream(inputRatings.split(" ")).mapToInt(Integer::parseInt).toArray();
        int result = candy.getNumberOfCandies(ratings);

        assertThat(result).isEqualTo(Integer.parseInt(expectedCandy));
    }
}
