class Solution:
    def maximumBeauty(self, items: List[List[int]], queries: List[int]) -> List[int]:
        beauties = [0]
        result = list()
        prices = list()

        for price, beauty in sorted(items):
            prices.append(price)
            beauties.append(max(beauties[-1], beauty))

        for query in queries:
            result.append(beauties[bisect_right(prices, query)])

        return result
