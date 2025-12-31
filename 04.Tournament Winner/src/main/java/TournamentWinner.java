import java.util.LinkedHashMap;
import java.util.Map;

public class TournamentWinner {

    private static final int HOME_TEAM_WON = 1;
    public static final int WINNER_SCORE = 3;
    public static final int LOSER_SCORE = 0;
    private static final int HOME_TEAM = 0;
    private static final int AWAY_TEAM = 1;

    public String predictTheWinner(String[][] competitions, int[] result) {
        LinkedHashMap<String, Integer> matches = new LinkedHashMap<>();

        for (int i = LOSER_SCORE; i < result.length; i++) {
            final String homeTeam = competitions[i][HOME_TEAM];
            final String awayTeam = competitions[i][AWAY_TEAM];
            if (isTheHomeTeamWinner(result[i])) {
                int homeTeamPoint = calculateWinnerTeamPoint(matches, homeTeam);
                int awayTeamPoint = calculateLoserTeamPoint(matches, homeTeam);
                matches.put(homeTeam, homeTeamPoint);
                matches.put(awayTeam, awayTeamPoint);
            } else {
                int homeTeamPoint = calculateLoserTeamPoint(matches, homeTeam);
                int awayTeamPoint = calculateWinnerTeamPoint(matches, awayTeam);
                matches.put(awayTeam, awayTeamPoint);
                matches.put(homeTeam, homeTeamPoint);
            }
        }

        return whichTeamIsWinner(matches);
    }

    private int calculateLoserTeamPoint(LinkedHashMap<String, Integer> matches, String loserTeam) {
        return matches.get(loserTeam) != null ? matches.get(loserTeam) : LOSER_SCORE;
    }

    private static int calculateWinnerTeamPoint(LinkedHashMap<String, Integer> matches, String team) {
        return matches.get(team) != null ? matches.get(team) + WINNER_SCORE : WINNER_SCORE;
    }

    private static String whichTeamIsWinner(LinkedHashMap<String, Integer> matches) {
        int winnerPoint = LOSER_SCORE;
        String winner = "";
        for (Map.Entry<String, Integer> entry : matches.entrySet()) {
            String team = entry.getKey();
            int point = entry.getValue();
            if (point > winnerPoint) {
                winnerPoint = point;
                winner = team;
            }
        }
        return winner;
    }

    private static boolean isTheHomeTeamWinner(int result) {
        return result == HOME_TEAM_WON;
    }
}
