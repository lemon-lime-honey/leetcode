class Solution:
    def judgeSquareSum(self, c: int) -> bool:
        lo, hi = 0, int(c ** 0.5)

        while lo <= hi:
            chk = lo * lo + hi * hi
            if chk == c: return True
            if chk < c: lo += 1
            else: hi -= 1

        return False