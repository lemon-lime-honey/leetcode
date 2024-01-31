class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows == 1 or numRows >= len(s):
            return s

        result = ['' for i in range(numRows)]
        idx = 0
        ref = 1

        for letter in s:
            result[idx] += letter
            if idx == 0:
                ref = 1
            elif idx == numRows - 1:
                ref = -1
            idx += ref

        return ''.join(result)