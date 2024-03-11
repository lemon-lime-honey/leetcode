class Solution:
    def customSortString(self, order: str, s: str) -> str:
        letters = {letter: 0 for letter in order}
        result = list()

        for letter in s:
            if letter in letters:
                letters[letter] += 1

        for letter in order:
            for i in range(letters[letter]):
                result.append(letter)

        for letter in s:
            if letter not in letters:
                result.append(letter)

        return ''.join(result)