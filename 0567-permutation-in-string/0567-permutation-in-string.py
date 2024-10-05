class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        letters = [0 for i in range(26)]
        lo, hi = 0, 0
        cnt = len(s1)

        for letter in s1:
            letters[ord(letter) - ord('a')] += 1

        while hi < len(s2):
            if letters[ord(s2[hi]) - ord('a')] > 0:
                cnt -= 1

            letters[ord(s2[hi]) - ord('a')] -= 1
            hi += 1

            if cnt == 0:
                return True

            if hi - lo == len(s1):
                if letters[ord(s2[lo]) - ord('a')] >= 0:
                    cnt += 1
                letters[ord(s2[lo]) - ord('a')] += 1
                lo += 1

        return False