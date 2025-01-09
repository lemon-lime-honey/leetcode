class Solution:
    def prefixCount(self, words: List[str], pref: str) -> int:
        result = 0

        for word in words:
            if re.match(pref, word):
                result += 1

        return result