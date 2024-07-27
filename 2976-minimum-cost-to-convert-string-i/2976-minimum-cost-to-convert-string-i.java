class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = source.length(), m = original.length;
        int[][] graph = new int[26][26];
        long result = 0;

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                graph[i][j] = Integer.MAX_VALUE / 2;
            }
        }

        for (int i = 0; i < m; i++) {
            int o = original[i] - 'a', c = changed[i] - 'a';
            graph[o][c] = Math.min(graph[o][c], cost[i]);
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                for (int k = 0; k < 26; k++) {
                    if (graph[j][k] <= graph[j][i] + graph[i][k]) continue;
                    graph[j][k] = graph[j][i] + graph[i][k];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (source.charAt(i) == target.charAt(i)) continue;
            int u = source.charAt(i) - 'a', v = target.charAt(i) - 'a';
            if (graph[u][v] == Integer.MAX_VALUE / 2) return -1;
            result += graph[u][v];
        }

        return result;
    }
}