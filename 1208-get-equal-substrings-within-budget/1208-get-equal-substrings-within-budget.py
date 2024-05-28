class Solution:
    def equalSubstring(self, s: str, t: str, maxCost: int) -> int:
        lo, hi = 0, 0
        result = 0
        cost = 0

        while hi < len(t):
            if abs(ord(s[hi]) - ord(t[hi])) + cost <= maxCost:
                cost += abs(ord(s[hi]) - ord(t[hi]))
                result = max(result, hi - lo + 1)
                hi += 1
            else:
                cost -= abs(ord(s[lo]) - ord(t[lo]))
                lo += 1

        return result