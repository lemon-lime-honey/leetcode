class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] chk = new boolean[n];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        Queue<Integer> que = new ArrayDeque<>();
        que.add(source);
        chk[source] = true;

        while (!que.isEmpty()) {
            int now = que.poll();
            if (now == destination) {
                return true;
            }
            for (int i = 0; i < graph.get(now).size(); i++) {
                int target = graph.get(now).get(i);
                if (chk[target]) continue;
                chk[target] = true;
                que.add(target);
            }
        }

        return false;
    }
}