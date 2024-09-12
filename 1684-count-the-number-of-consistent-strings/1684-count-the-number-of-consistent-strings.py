class Solution:
    def countConsistentStrings(self, allowed: str, words: List[str]) -> int:
        target = set()
        result = 0

        for letter in allowed:
            target.add(letter)

        for word in words:
            chk = set()
            for letter in word:
                chk.add(letter)
            if chk.intersection(target) == chk:
                result += 1

        return result