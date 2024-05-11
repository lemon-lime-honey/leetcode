class Solution:
    def kidsWithCandies(self, candies: List[int], extraCandies: int) -> List[bool]:
        n = len(candies)
        ref = max(candies)
        result = [False for i in range(n)]

        for i in range(n):
            if ref <= candies[i] + extraCandies:
                result[i] = True

        return result