class Solution:
    def getRow(self, rowIndex: int) -> List[int]:
        result = [1]
        before = 1

        for i in range(1, rowIndex + 1):
            num = before * (rowIndex - i + 1) // i
            result.append(num)
            before = num

        return result