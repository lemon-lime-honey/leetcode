class Solution:
    def reverseWords(self, s: str) -> str:
        words = s.split()
        result = list()

        for word in words:
            result.append(word[::-1])

        return ' '.join(result)