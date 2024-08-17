class Solution {
public:
    long long maxPoints(vector<vector<int>>& points) {
        int n = points.size(), m = points[0].size();
        long long result = 0;
        vector<long long> dp(m, 0);
        vector<long long> left(m, 0);
        vector<long long> right(m, 0);

        for (int i = 0; i < m; i++) {
            dp[i] = points[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) left[j] = dp[j];
                else left[j] = max(dp[j], left[j - 1] - 1);
            }

            for (int j = m - 1; j >= 0; j--) {
                if (j == m - 1) right[j] = dp[j];
                else right[j] = max(dp[j], right[j + 1] - 1);
            }

            for (int j = 0; j < m; j++) {
                dp[j] = max(left[j], right[j]) + points[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            result = max(result, dp[i]);
        }

        return result;
    }
};