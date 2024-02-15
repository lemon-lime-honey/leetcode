class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        n, m = len(word1), len(word2)
        result = list()
        idx = 0

        while idx < n and idx < m:
            result.append(word1[idx])
            result.append(word2[idx])
            idx += 1

        if idx < n:
            return ''.join(result) + word1[idx:]

        if idx < m:
            return ''.join(result) + word2[idx:]

        return ''.join(result)