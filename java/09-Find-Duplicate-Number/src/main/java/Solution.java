public class Solution {

    public int findDuplicateNumber(int[] nums) {
        final int n = nums.length - 1;
        int[] duplicateNumbers = new int[n];


        for (int i = 0; i <= n; i++) {
            final int indexOfNumber = nums[i] - 1;
            duplicateNumbers[indexOfNumber] = duplicateNumbers[indexOfNumber] + 1;
        }

        for (int i = 0; i <= n; i++) {
            final int value = duplicateNumbers[i];
            if (isDuplicateNumber(value)) return i + 1;
        }


        return 0;
    }

    private static boolean isDuplicateNumber(int value) {
        return value >= 2;
    }
}
