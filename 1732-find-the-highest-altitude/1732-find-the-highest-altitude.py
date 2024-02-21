class Solution:
    def largestAltitude(self, gain: List[int]) -> int:
        result = 0
        num = 0

        for n in gain:
            num += n
            result = max(result, num)

        return result