class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if amount == 0: return 0

        dp = [int(1e9) for i in range(amount + 1)]

        for i in range(1, amount + 1):
            for coin in coins:
                if coin == i: dp[i] = 1
                elif coin > i: continue
                else: dp[i] = min(dp[i], dp[i - coin] + 1)

        return dp[amount] if dp[amount] != int(1e9) else -1