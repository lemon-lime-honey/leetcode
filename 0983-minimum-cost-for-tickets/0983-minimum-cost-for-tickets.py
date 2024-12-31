class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        tf = [False for i in range(days[-1] + 1)]
        dp = [0 for i in range(days[-1] + 1)]
        idx = 0

        for day in days:
            tf[day] = True

        for i in range(1, days[-1] + 1):
            if not tf[i]:
                dp[i] = dp[i - 1]
                continue

            dp[i] = costs[0] + dp[i - 1]

            if i > 6:
                dp[i] = min(dp[i], dp[i - 7] + costs[1])
            else:
                dp[i] = min(dp[i], costs[1])

            if i >= 30:
                dp[i] = min(dp[i], dp[i - 30] + costs[2])
            else:
                dp[i] = min(dp[i], costs[2])

        return dp[-1]