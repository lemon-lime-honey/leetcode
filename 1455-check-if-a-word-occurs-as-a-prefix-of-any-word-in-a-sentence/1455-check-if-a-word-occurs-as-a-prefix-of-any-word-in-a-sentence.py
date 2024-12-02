class Solution:
    def isPrefixOfWord(self, sentence: str, searchWord: str) -> int:
        for idx, word in enumerate(sentence.split()):
            if re.match(searchWord, word):
                return idx + 1
        return -1