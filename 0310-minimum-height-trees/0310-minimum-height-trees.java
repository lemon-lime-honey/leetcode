class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if (n == 1) {
            result.add(0);
            return result;
        }

        Map<Integer, Set<Integer>> degree = new HashMap<>();
        Queue<Integer> que = new ArrayDeque<>();

        for (int i = 0; i < edges.length; i++) {
            if (!degree.containsKey(edges[i][0])) {
                degree.put(edges[i][0], new HashSet<>());
            }
            if (!degree.containsKey(edges[i][1])) {
                degree.put(edges[i][1], new HashSet<>());
            }
            degree.get(edges[i][0]).add(edges[i][1]);
            degree.get(edges[i][1]).add(edges[i][0]);
        }

        for (int key: degree.keySet()) {
            if (degree.get(key).size() == 1) {
                que.add(key);
                result.add(key);
            }
        }

        while (!que.isEmpty()) {
            int len = que.size();
            result = new ArrayList<>();

            for (int i = 0; i < len; i++) {
                int now = que.poll();
                result.add(now);
                for (int next: degree.get(now)) {
                    degree.get(next).remove(now);
                    if (degree.get(next).size() == 1) {
                        que.add(next);
                    }
                }
            }
        }

        return result;
    }
}