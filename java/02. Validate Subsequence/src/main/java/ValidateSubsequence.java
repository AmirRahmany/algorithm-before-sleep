import java.util.ArrayList;
import java.util.List;

public class ValidateSubsequence {


    public boolean isValidSubsequence(int[] array, int[] subsequence) {
        int i = 0, j = 0;
        int isValid = 0;

        while (i < array.length && j < subsequence.length) {
            if (array[i] == subsequence[j]) {
                j++;
                i++;
                isValid++;
            } else i++;
        }
        return isValid == subsequence.length;
    }
}
