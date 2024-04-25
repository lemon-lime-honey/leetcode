class Solution:
    def longestIdealString(self, s: str, k: int) -> int:
        result = [0 for i in range(26)]

        for letter in s:
            target = ord(letter) - ord('a')
            longest = 0
            for idx in range(26):
                if abs(target - idx) <= k:
                    longest = max(longest, 1 + result[idx])
            result[target] = longest

        return max(result)