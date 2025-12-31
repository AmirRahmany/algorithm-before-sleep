public class SortedSquaredArray {

    public int[] sortedSquare(int[] array) {
        final int arraySize = array.length;
        int[] sort = new int[arraySize];

        int start = 0;
        int end = arraySize - 1;

        for (int index = arraySize - 1; index >= 0; index--) {
            if (getAbsOf(array[end]) > getAbsOf(array[start])) {
                sort[index] = getPowerTwoOf(array[end]);
                end--;
            } else {
                sort[index] = getPowerTwoOf(array[start]);
                start++;
            }
        }
        return sort;
    }

    private static int getPowerTwoOf(int num) {
        return num * num;
    }

    private static int getAbsOf(int array) {
        return Math.abs(array);
    }
}
