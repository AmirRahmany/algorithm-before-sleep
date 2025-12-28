import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TwoSumTests {


    @Test
    void find_two_values_whose_sum_is_target_by_given_array() {
        int[] array = new int[]{4,8,2,7,5,1};
        int target = 11;

        final TwoSum twoSum = new TwoSum();
        assertThat(twoSum.findTwoValues(array,target)).isEqualTo(new int[]{4,7});
    }

    @Test
    void find_two_values_whose_sum_is_target_by_given_array_with_hashmap() {
        int[] array = new int[]{4,8,2,7,5,1};
        int target = 11;

        final TwoSum twoSum = new TwoSum();
        assertThat(twoSum.findTwoValuesByHash(array,target)).containsOnly(4,7);
    }
}
