class Solution:
    def sortVowels(self, s: str) -> str:
        result = list()
        vowel = list()
        idx = -1

        for index, letter in enumerate(s):
            if letter in "AEIOUaeiou":
                vowel.append(letter)
                result.append(None)
                if idx == -1:
                    idx = index
            else:
                result.append(letter)

        vowel.sort()

        for letter in vowel:
            result[idx] = letter
            for index in range(idx + 1, len(s)):
                if result[index] is None:
                    idx = index
                    break

        return "".join(result)