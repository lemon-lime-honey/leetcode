class Solution {
public:
    double maxProbability(int n, vector<vector<int>>& edges, vector<double>& succProb, int start_node, int end_node) {
        vector<double> result(n, 0.0);
        result[start_node] = 1.0;

        for (int i = 0; i < n - 1; i++) {
            bool flag = false;
            for (int j = 0; j < edges.size(); j++) {
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
};