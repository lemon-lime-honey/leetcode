class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] graph = new int[n][n];
        Map<Integer, List<Integer>> dist = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                graph[i][j] = (int) Math.pow(10, 9);
            }
        }

        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]][edges[i][1]] = edges[i][2];
            graph[edges[i][1]][edges[i][0]] = edges[i][2];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (graph[j][k] <= graph[j][i] + graph[i][k]) continue;
                    graph[j][k] = graph[j][i] + graph[i][k];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && graph[i][j] <= distanceThreshold) cnt++;
            }
            if (!dist.containsKey(cnt)) dist.put(cnt, new ArrayList<>());
            dist.get(cnt).add(i);
        }

        List<Integer> keySet = new ArrayList<>(dist.keySet());
        Collections.sort(keySet);

        List<Integer> result = dist.get(keySet.get(0));
        Collections.reverse(result);

        return result.get(0);
    }
}
