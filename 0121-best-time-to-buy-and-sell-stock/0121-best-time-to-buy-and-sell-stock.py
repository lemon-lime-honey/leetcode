class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        max_cost = prices[-1]
        result = 0
        for i in range(len(prices) - 1, -1, -1):
            if prices[i] < max_cost:
                result = max(result, max_cost - prices[i])
            if prices[i] > max_cost:
                max_cost = prices[i]
        return result