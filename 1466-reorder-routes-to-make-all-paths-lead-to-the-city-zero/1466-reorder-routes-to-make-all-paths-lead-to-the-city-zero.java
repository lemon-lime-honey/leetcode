class Solution {
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<int[]>> routes = new HashMap<>();

        for (int i = 0; i < connections.length; i++) {
            if (!routes.containsKey(connections[i][0]))
                routes.put(connections[i][0], new ArrayList<>());
            if (!routes.containsKey(connections[i][1]))
                routes.put(connections[i][1], new ArrayList<>());
            routes.get(connections[i][0]).add(new int[] {connections[i][1], 1});
            routes.get(connections[i][1]).add(new int[] {connections[i][0], 0});
        }

        Queue<Integer> que = new ArrayDeque<>();
        Set<Integer> chk = new HashSet<>();
        int result = 0;
        que.add(0);
        chk.add(0);

        while (!que.isEmpty()) {
            int now = que.poll();
            for (int i = 0; i < routes.get(now).size(); i++) {
                int next_point = routes.get(now).get(i)[0], cost = routes.get(now).get(i)[1];
                if (chk.contains(next_point))
                    continue;
                chk.add(next_point);
                result += cost;
                que.add(next_point);
            }
        }

        return result;
    }
}