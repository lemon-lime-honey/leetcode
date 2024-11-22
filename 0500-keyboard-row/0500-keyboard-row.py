class Solution:
    def findWords(self, words: List[str]) -> List[str]:
        result = list()

        for word in words:
            target = set(word.lower())
            if target <= set("qwertyuiop"):
                result.append(word)
            elif target <= set("asdfghjkl"):
                result.append(word)
            elif target <= set("zxcvbnm"):
                result.append(word)

        return result