class Solution:
    def maxPoints(self, points: List[List[int]]) -> int:
        n, m = len(points), len(points[0])

        dp = points[0]
        left = [0 for i in range(m)]
        right = [0 for i in range(m)]

        for i in range(1, n):
            for j in range(m):
                if j == 0:
                    left[j] = dp[j]
                else:
                    left[j] = max(left[j - 1] - 1, dp[j])

            for j in range(m - 1, -1, -1):
                if j == m - 1:
                    right[j] = dp[j]
                else:
                    right[j] = max(right[j + 1] - 1, dp[j])

            for j in range(m):
                dp[j] = max(left[j], right[j]) + points[i][j]

        return max(dp)
