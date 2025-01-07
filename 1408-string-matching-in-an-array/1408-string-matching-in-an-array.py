class Solution:
    def stringMatching(self, words: List[str]) -> List[str]:
        result = list()

        for i in range(len(words)):
            for j in range(len(words)):
                if i != j and re.search(words[i], words[j]):
                    result.append(words[i])
                    break

        return result