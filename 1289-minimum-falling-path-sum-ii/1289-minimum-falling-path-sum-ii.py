class Solution:
    def minFallingPathSum(self, grid: List[List[int]]) -> int:
        n = len(grid)
        m = len(grid[0])
        dp = [[int(1e9) for i in range(m)] for j in range(n)]

        for i in range(n):
            for j in range(m):
                if i == 0:
                    dp[i][j] = grid[i][j]
                else:
                    for k in range(m):
                        if j != k:
                            dp[i][j] = min(dp[i][j], dp[i - 1][k] + grid[i][j])

        return min(dp[-1])