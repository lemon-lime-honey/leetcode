class Solution:
    def mostWordsFound(self, sentences: List[str]) -> int:
        result = 0

        for sentence in sentences:
            result = max(result, len(sentence.split()))

        return result