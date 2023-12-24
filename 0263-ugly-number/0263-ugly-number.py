class Solution:
    def isUgly(self, n: int) -> bool:
        factors = [2, 3, 5]
        for factor in factors:
            while n >= factor and not n % factor:
                n //= factor
        return True if n == 1 else False