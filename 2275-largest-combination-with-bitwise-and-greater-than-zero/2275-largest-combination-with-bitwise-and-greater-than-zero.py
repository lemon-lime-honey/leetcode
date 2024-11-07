class Solution:
    def largestCombination(self, candidates: List[int]) -> int:
        result = 0

        for i in range(32):
            chk = sum(1 for num in candidates if num & (1 << i))
            result = max(chk, result)

        return result