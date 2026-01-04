public class CountUnhappyFriends {

    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int unhappyCount = 0;

        int[][] rank = new int[n][n];
        int[] pairMap = new int[n];

        for (int i = 0; i < n; i++) {
            for (int o = 0; o < preferences[i].length; o++) {
                int person = preferences[i][o];
                rank[i][person] = o;
            }
        }

        for (int[] pair : pairs) {
            int a = pair[0];
            int b = pair[1];
            pairMap[a] = b;
            pairMap[b] = a;
        }

        for (int x = 0; x < n; x++) {
            int y = pairMap[x];

            for (int u : preferences[x]) {
                if (u == y) break;
                int v = pairMap[u];
                if (rank[u][x] < rank[u][v]){
                    unhappyCount++;
                    break;
                }
            }

        }


        return unhappyCount;
    }
}
