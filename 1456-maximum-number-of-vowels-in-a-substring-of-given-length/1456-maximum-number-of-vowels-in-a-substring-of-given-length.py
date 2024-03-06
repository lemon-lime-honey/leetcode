class Solution:
    def maxVowels(self, s: str, k: int) -> int:
        vowels = 'aeiou'
        cnt = 0

        for i in range(k):
            if s[i] in vowels:
                cnt += 1

        result = cnt
        lo, hi = 1, k

        while hi < len(s):
            if s[lo - 1] in vowels: cnt -= 1
            if s[hi] in vowels: cnt += 1
            result = max(result, cnt)
            lo += 1
            hi += 1

        return result