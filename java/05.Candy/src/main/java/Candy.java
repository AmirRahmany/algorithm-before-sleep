import java.util.Arrays;

public class Candy {
    public int getNumberOfCandies(int[] ratings) {
        final int numberOfChildren = ratings.length;
        int[] children = new int[numberOfChildren];
        int h = 1;

        Arrays.fill(children, 1);

        for (int i = 1; i <= numberOfChildren - 1; i++) {
            if (ratings[i] > ratings[i - 1])
                h++;
            else
                h = 1;

            children[i] = h;
        }

        h = 1;

        for (int i = numberOfChildren - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                h++;
            else
                h = 1;

            children[i] = Math.max(h, children[i]);

        }
        return Arrays.stream(children).sum();
    }

}
