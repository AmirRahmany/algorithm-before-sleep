import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CountUnhappyFriendsTest {

    @Test
    void detect_unhappy_friends() {
        final CountUnhappyFriends countUnhappyFriends = new CountUnhappyFriends();

        int[][] preferences = {{1, 2, 3}, {3, 2, 0}, {3, 1, 0}, {1, 2, 0}};
        int[][] pairs = {{0, 1}, {2, 3}};
        int output = countUnhappyFriends.unhappyFriends(4, preferences, pairs);

        assertThat(output).isEqualTo(2);
    }

    @Test
    void test_case2() {
        final CountUnhappyFriends countUnhappyFriends = new CountUnhappyFriends();

        int[][] preferences = {{1, 3, 2}, {2, 3, 0}, {1, 3, 0}, {0, 2, 1}};
        int[][] pairs = {{1, 3}, {0, 2}};
        int output = countUnhappyFriends.unhappyFriends(4, preferences, pairs);

        assertThat(output).isEqualTo(4);
    }

    @Test
    void test_case3() {
        final CountUnhappyFriends countUnhappyFriends = new CountUnhappyFriends();
        int[][] preferences = {{1}, {0}}, pairs = {{1, 0}};
        int output = countUnhappyFriends.unhappyFriends(2, preferences, pairs);

        assertThat(output).isEqualTo(0);
    }

    @Test
    void test_case4() {
        final CountUnhappyFriends countUnhappyFriends = new CountUnhappyFriends();
        int[][] preferences = {{1,3,2},{2,3,0},{1,0,3},{1,0,2}}, pairs = {{2, 1},{3,0}};
        int output = countUnhappyFriends.unhappyFriends(4, preferences, pairs);

        assertThat(output).isEqualTo(0);
    }
}
