from collections import Counter


class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        ranCounter = Counter(ransomNote)
        magCounter = Counter(magazine)
        letters = list(ranCounter.items())

        for letter, cnt in letters:
            if letter not in magCounter or magCounter[letter] < cnt:
                return False

        return True