class Solution:
    def countCharacters(self, words: List[str], chars: str) -> int:
        letters = [0 for i in range(26)]
        result = 0

        for letter in chars:
            letters[ord(letter) - ord("a")] += 1

        for word in words:
            ref = copy.deepcopy(letters)
            for letter in word:
                idx = ord(letter) - ord("a")
                if ref[idx] == 0:
                    break
                ref[idx] -= 1
            else:
                result += len(word)

        return result