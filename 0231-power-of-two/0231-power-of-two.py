class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        if n < 0: return False

        while n:
            if n & 1:
                if n > 1: return False
                return True
            n >>= 1