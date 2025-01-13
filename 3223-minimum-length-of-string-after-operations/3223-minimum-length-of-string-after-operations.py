class Solution:
    def minimumLength(self, s: str) -> int:
        freq = [0 for i in range(26)]
        result = 0

        for letter in s:
            freq[ord(letter) - ord("a")] += 1

        for i in range(26):
            if not freq[i]: continue
            if freq[i] % 2:
                result += 1
            else:
                result += 2

        return result