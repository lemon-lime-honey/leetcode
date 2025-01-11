class Solution:
    def canConstruct(self, s: str, k: int) -> bool:
        if len(s) < k:
            return False

        mask = 0

        for letter in s:
            mask ^= (1 << (ord(letter) - ord("a")))

        odd = bin(mask).count("1")

        return odd <= k