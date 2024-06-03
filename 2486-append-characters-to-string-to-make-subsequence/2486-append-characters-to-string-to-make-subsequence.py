class Solution:
    def appendCharacters(self, s: str, t: str) -> int:
        idx = 0

        for letter in s:
            if idx == len(t): break
            if t[idx] == letter: idx += 1

        return len(t) - idx