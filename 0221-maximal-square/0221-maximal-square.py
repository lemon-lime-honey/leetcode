class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        result = 0
        m = len(matrix)
        n = len(matrix[0])
        dp = [[0 for i in range(n + 1)] for j in range(m + 1)]

        for i in range(m):
            for j in range(n):
                dp[i + 1][j + 1] = int(matrix[i][j])

        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if dp[i][j] == 0: continue
                dp[i][j] = min(dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j]) + 1
                result = max(result, dp[i][j])

        return result * result