class Solution:
    def countPalindromicSubsequence(self, s: str) -> int:
        letters = set(s)
        result = 0

        for letter in letters:
            left, right = s.index(letter), s.rindex(letter)
            cnt = set()

            for i in range(left + 1, right):
                cnt.add(s[i])

            result += len(cnt)

        return result