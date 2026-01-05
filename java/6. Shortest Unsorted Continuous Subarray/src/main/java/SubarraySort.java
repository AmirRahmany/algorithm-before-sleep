import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class SubarraySort {

    public int findUnsortedSubarray(int[] nums) {
        final int arraySize = nums.length;
        LinkedHashMap<Integer, Integer> unsortedArray = new LinkedHashMap<>();
        int min, max;
        int[] subarray = new int[2];

        for (int i = 0; i < arraySize - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                unsortedArray.put(i, nums[i]);
                unsortedArray.put(i + 1, nums[i + 1]);
            }
        }

        max = unsortedArray.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(0);


        min = unsortedArray.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(0);

        subarray[0] = findMinPosition(nums, min);

        subarray[1] = findMaxPosition(nums, max, arraySize);

        return subarray[0] == subarray[1] ? 0 : subarray[1] - subarray[0] + 1;
    }

    private int findMaxPosition(int[] nums, int max, int arraySize) {
        int maxPosition = 0;
        for (int i = max + 1; i < arraySize; i++) {
            if (nums[max] > nums[i])
                maxPosition = i;
        }
        return maxPosition;
    }

    private int findMinPosition(int[] nums, int min) {
        int minPosition = 0;
        for (int i = 0; i < min; i++) {
            if (nums[min] < nums[i]) {
                minPosition = i;
                break;
            }
        }
        return minPosition;
    }
}
