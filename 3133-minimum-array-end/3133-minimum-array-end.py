class Solution:
    def minEnd(self, n: int, x: int) -> int:
        result = x
        cnt = n - 1
        pos = 1

        while cnt:
            if not x & pos:
                result |= (cnt & 1) * pos
                cnt >>= 1
            pos <<= 1

        return result
