class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                for (int j = 0; j < m; j++) {
                    dp[i][j] = grid[i][j];
                }
            } else {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    if (j != k) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + grid[i][j]);
                    }
                }
            }
        }

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            result = Math.min(result, dp[n - 1][i]);
        }

        return result;
    }
}