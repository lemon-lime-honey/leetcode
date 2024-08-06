class Solution:
    def minimumPushes(self, word: str) -> int:
        counter = Counter(word).most_common()
        numDict = defaultdict(list)
        result = 0
        idx = 0

        for letter, cnt in counter:
            numDict[idx].append(letter)
            result += len(numDict[idx]) * cnt
            idx = (idx + 1) % 8

        return result
