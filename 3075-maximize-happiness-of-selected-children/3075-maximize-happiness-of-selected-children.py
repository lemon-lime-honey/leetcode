class Solution:
    def maximumHappinessSum(self, happiness: List[int], k: int) -> int:
        happiness.sort(reverse=True)
        result = 0
        decay = 0

        for i in range(k):
            result += max(happiness[i] - decay, 0)
            decay += 1

        return result