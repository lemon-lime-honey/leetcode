import re


class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        if not s: return True
        if not t: return False

        i, j = 0, 0

        while j < len(t):
            if s[i] != t[j]:
                j += 1
            else:
                i += 1
                j += 1
            if i == len(s): return True

        return False