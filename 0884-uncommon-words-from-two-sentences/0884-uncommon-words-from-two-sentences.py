class Solution:
    def uncommonFromSentences(self, s1: str, s2: str) -> List[str]:
        wordDict = defaultdict(int)

        for word in s1.split():
            wordDict[word] += 1

        for word in s2.split():
            wordDict[word] += 1

        return [word for word in wordDict.keys() if wordDict[word] == 1]