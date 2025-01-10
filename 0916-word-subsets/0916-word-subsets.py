class Solution:
    def wordSubsets(self, words1: List[str], words2: List[str]) -> List[str]:
        freq = [0 for i in range(26)]
        result = list()

        for word in words2:
            _freq = [0 for i in range(26)]
            for letter in word:
                _freq[ord(letter) - ord("a")] += 1
            for i in range(26):
                if freq[i] < _freq[i]:
                    freq[i] = _freq[i]

        for word in words1:
            _freq = [0 for i in range(26)]
            for letter in word:
                _freq[ord(letter) - ord("a")] += 1
            for i in range(26):
                if _freq[i] < freq[i]:
                    break
            else:
                result.append(word)

        return result