class Solution:
    def reverseVowels(self, s: str) -> str:
        vowels = {'A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 'U', 'u'}
        result = list(s)
        lo, hi = 0, len(s) - 1

        while lo < hi:
            while lo < hi and result[lo] not in vowels:
                lo += 1

            while hi > -1 and result[hi] not in vowels:
                hi -= 1

            if lo < hi:
                result[lo], result[hi] = result[hi], result[lo]
                lo += 1
                hi -= 1

        return ''.join(result)