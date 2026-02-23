import java.util.*;

public class MissingNumbers {

    public static final int NOT_VISITED = 0;
    public static final int VISITED = 1;

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missingNumbers = new LinkedList<>();

        for (int num : nums) {
            final int index = Math.abs(num) - 1;
            final int value = nums[index];
            if (value > 0) {
                nums[index] = -value;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (isNumberNotExists(nums[i])) {
                missingNumbers.add(i + 1);
            }
        }

        return missingNumbers;
    }

    private static boolean isNumberNotExists(int nums) {
        return nums > 0;
    }

    public List<Integer> findDisappearedNumbersWithExtraSpace(int[] nums) {
        List<Integer> missingNumbers = new LinkedList<>();

        int[] range = new int[nums.length];
        for (int num : nums) {
            range[num - 1] = VISITED;
        }

        for (int i = 0; i < nums.length; i++) {
            if (range[i] == NOT_VISITED) {
                missingNumbers.add(i + 1);
            }
        }

        return missingNumbers;
    }
}
