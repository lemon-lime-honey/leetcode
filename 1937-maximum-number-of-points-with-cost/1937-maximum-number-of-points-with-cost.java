class Solution {
    public long maxPoints(int[][] points) {
        int n = points.length, m = points[0].length;
        long [] dp = new long[m];
        long [] left = new long[m];
        long [] right = new long[m];

        for (int i = 0; i < m; i++) {
            dp[i] = points[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) left[j] = dp[j];
                else left[j] = Math.max(dp[j], left[j - 1] - 1);
            }

            for (int j = m - 1; j >= 0; j--) {
                if (j == m - 1) right[j] = dp[j];
                else right[j] = Math.max(dp[j], right[j + 1] - 1);
            }

            for (int j = 0; j < m; j++) {
                dp[j] = Math.max(left[j], right[j]) + points[i][j];
            }
        }

        long result = 0;

        for (long num: dp) {
            result = Math.max(result, num);
        }

        return result;
    }
}