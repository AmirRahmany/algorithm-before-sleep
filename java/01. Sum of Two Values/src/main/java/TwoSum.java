import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class TwoSum {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String input = scanner.nextLine();
        final String[] splitInput = input.split(" ");
        final int arraySize = Integer.parseInt(splitInput[0]);
        final int targetSum = Integer.parseInt(splitInput[1]);
        final String inputArray = scanner.nextLine();
        int[] array = Arrays.stream(inputArray.split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(findTwoValuesByHash(array, targetSum));
    }

    public static String findTwoValuesByHash(int[] array, int target) {
        LinkedHashMap<Integer, Integer> hashMap = new LinkedHashMap<>();

        int complement;
        for (int i = 0; i < array.length; i++) {
            int current = array[i];
            complement = target - current;
            if (hashMap.containsKey(complement)) {
                return String.format("%d %d", hashMap.get(complement), i + 1);
            } else
                hashMap.put(current, i + 1);
        }
        return "-1";
    }

    @Override
    public String toString() {
        return "TwoSum{}";
    }
}
