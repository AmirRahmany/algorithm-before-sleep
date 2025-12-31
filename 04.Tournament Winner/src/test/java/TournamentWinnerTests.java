import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TournamentWinnerTests {

    @Test
    void determine_winner_in_a_tournament_by_results() {
        String[][] competitions = new String[][]{{"HTML", "C#"}, {"C#", "Python"}, {"Python", "HTML"}};
        int[] result = new int[]{0, 0, 1};

        final TournamentWinner tournamentWinner = new TournamentWinner();
        String winner = tournamentWinner.predictTheWinner(competitions,result);

        assertThat(winner).isEqualTo("Python");
    }
}
