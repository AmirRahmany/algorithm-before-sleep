import java.util.Arrays;
import java.util.LinkedHashMap;

public class TwoSum {
    public int[] findTwoValues(int[] array, int target) {
        final int[] sortedArray = Arrays.stream(array).sorted().toArray();

        int r = 0;
        int l = sortedArray.length - 1;

        while (r <= l) {
            final int sumTwoValues = sortedArray[r] + sortedArray[l];
            if (sumTwoValues == target)
                return new int[]{sortedArray[r], sortedArray[l]};
            else if (sumTwoValues > target) {
                l--;
            } else {
                r++;
            }
        }
        return new int[]{-1};
    }

    public int[] findTwoValuesByHash(int[] array, int target) {
        LinkedHashMap<Integer, Boolean> hashMap = new LinkedHashMap<>();

        int y;
        for (int n : array) {
            y = target - n;
            if (doesValueExistInHash(hashMap, y))
                return new int[]{n, y};
            else
                hashMap.put(n, Boolean.TRUE);
        }
        return new int[]{-1};
    }

    private static boolean doesValueExistInHash(LinkedHashMap<Integer, Boolean> hashMap, int y) {
        return Boolean.TRUE.equals(hashMap.get(y));
    }

    @Override
    public String toString() {
        return "TwoSum{}";
    }
}
