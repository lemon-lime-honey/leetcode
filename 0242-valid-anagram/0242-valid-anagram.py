from collections import Counter


class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        sCounter = sorted(Counter(s).most_common())
        tCounter = sorted(Counter(t).most_common())
        if sCounter == tCounter: return True
        return False