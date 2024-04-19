class Solution:
    def countBits(self, n: int) -> List[int]:
        result = [0 for i in range(n + 1)]

        for i in range(1, n + 1):
            num = i
            while num:
                result[i] += num & 1
                num = num >> 1

        return result