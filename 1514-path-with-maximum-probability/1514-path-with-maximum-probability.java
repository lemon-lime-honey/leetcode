class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] result = new double[n];
        result[start_node] = 1.0;

        for (int i = 0; i < n - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < edges.length; j++) {
                int u = edges[j][0], v = edges[j][1];
                if (result[u] * succProb[j] > result[v]) {
                    result[v] = result[u] * succProb[j];
                    flag = true;
                }
                if (result[v] * succProb[j] > result[u]) {
                    result[u] = result[v] * succProb[j];
                    flag = true;
                }
            }
            if (!flag) break;
        }

        return result[end_node];
    }
}