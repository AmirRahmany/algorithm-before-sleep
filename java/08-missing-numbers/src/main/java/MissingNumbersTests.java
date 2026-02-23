import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MissingNumbersTests {


    @Test
    public void find_missing_numbers(){

        final MissingNumbers missingNumbers = new MissingNumbers();

        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        List<Integer> disappearedNumbers = missingNumbers.findDisappearedNumbers(nums);

        final List<Integer> expected = List.of(5, 6);
        assertThat(disappearedNumbers).isEqualTo(expected);
    }


}
