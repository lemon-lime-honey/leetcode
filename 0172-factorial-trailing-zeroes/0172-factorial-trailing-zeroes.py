class Solution:
    def trailingZeroes(self, n: int) -> int:
        result = 0

        while n:
            if n < 5: break
            result += n // 5
            n //= 5

        return result