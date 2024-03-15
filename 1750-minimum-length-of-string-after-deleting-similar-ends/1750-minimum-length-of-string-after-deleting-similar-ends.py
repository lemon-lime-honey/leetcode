class Solution:
    def minimumLength(self, s: str) -> int:
        lo, hi = 0, len(s) - 1

        while lo < hi and s[lo] == s[hi]:
            target = s[lo]
            while lo <= hi and s[lo] == target:
                lo += 1
            while lo <= hi and s[hi] == target:
                hi -= 1

        return hi - lo  + 1