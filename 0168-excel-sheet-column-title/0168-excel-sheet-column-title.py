class Solution:
    def convertToTitle(self, columnNumber: int) -> str:
        result = list()
        while columnNumber:
            idx = (columnNumber - 1) % 26
            result.append(chr(idx + ord('A')))
            columnNumber = (columnNumber - 1) // 26
        return ''.join(result[::-1])
