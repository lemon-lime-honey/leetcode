class Solution:
    def firstUniqChar(self, s: str) -> int:
        freq = defaultdict(int)

        for letter in s:
            freq[letter] += 1

        for i in range(len(s)):
            if freq[s[i]] == 1:
                return i

        return -1