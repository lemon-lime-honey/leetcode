class Solution:
    def guessNumber(self, n: int) -> int:
        lo, hi = 1, n

        while lo < hi:
            mid = (lo + hi) // 2
            chk = guess(mid)
            if chk == 0:
                return mid
            if chk == -1:
                hi = mid - 1
            else:
                lo = mid + 1

        return lo