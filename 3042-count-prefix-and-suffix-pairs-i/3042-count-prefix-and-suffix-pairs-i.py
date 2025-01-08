class Solution:
    def countPrefixSuffixPairs(self, words: List[str]) -> int:
        result = 0

        for i in range(len(words)):
            for j in range(i + 1, len(words)):
                if len(words[j]) < len(words[i]): continue
                prefix = words[j][:len(words[i])]
                suffix = words[j][-len(words[i]):]
                if prefix == words[i] and suffix == words[i]:
                    result += 1

        return result