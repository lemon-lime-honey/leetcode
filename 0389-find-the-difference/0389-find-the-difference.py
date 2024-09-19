class Solution:
    def findTheDifference(self, s: str, t: str) -> str:
        letters = [0 for i in range(26)]

        for letter in s:
            letters[ord(letter) - ord('a')] += 1

        for letter in t:
            target = ord(letter) - ord('a')
            if letters[target] == 0:
                return letter
            letters[target] -= 1

        return -1