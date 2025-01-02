class Solution:
    def vowelStrings(self, words: List[str], queries: List[List[int]]) -> List[int]:
        prefix = [0 for i in range(len(words))]
        result = list()

        for i in range(len(words)):
            prefix[i] = prefix[i - 1]
            if words[i][0] in "aeiou" and words[i][-1] in "aeiou":
                prefix[i] += 1

        for start, end in queries:
            if start == 0:
                result.append(prefix[end])
            else:
                result.append(prefix[end] - prefix[start - 1])

        return result
