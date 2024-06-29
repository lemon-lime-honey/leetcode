class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        int[] degree = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        List<Set<Integer>> answer = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<Integer> que = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            answer.add(new HashSet<>());
        }

        for (int i = 0; i < edges.length; i++) {
            degree[edges[i][1]]++;
            graph.get(edges[i][0]).add(edges[i][1]);
        }

        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) que.add(i);
        }

        while (!que.isEmpty()) {
            int now = que.poll();
            for (int i = 0; i < graph.get(now).size(); i++) {
                degree[graph.get(now).get(i)]--;
                answer.get(graph.get(now).get(i)).addAll(answer.get(now));
                answer.get(graph.get(now).get(i)).add(now);
                if (degree[graph.get(now).get(i)] == 0) {
                    que.add(graph.get(now).get(i));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            result.add(answer.get(i).stream().sorted().collect(Collectors.toList()));
        }

        return result;
    }
}