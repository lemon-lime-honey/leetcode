class Solution:
    def closeStrings(self, word1: str, word2: str) -> bool:
        letter1 = [0 for i in range(26)]
        letter2 = [0 for i in range(26)]

        for letter in word1:
            letter1[ord(letter) - ord('a')] += 1

        for letter in word2:
            letter2[ord(letter) - ord('a')] += 1

        for i in range(26):
            if ((letter1[i] and not letter2[i]) or
                (not letter1[i] and letter2[i])):
                return False

        letter1.sort(reverse=True)
        letter2.sort(reverse=True)

        for i in range(26):
            if letter1[i] != letter2[i]:
                return False
            elif letter1[i] == 0:
                return True

        return True