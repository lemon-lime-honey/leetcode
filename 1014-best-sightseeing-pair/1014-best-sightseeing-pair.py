class Solution:
    def maxScoreSightseeingPair(self, values: List[int]) -> int:
        result = 0
        before = values[0]

        for i in range(1, len(values)):
            result = max(result, before + values[i] - i)
            before = max(before, values[i] + i)

        return result