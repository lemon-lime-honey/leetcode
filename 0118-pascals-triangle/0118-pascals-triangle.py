class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        result = list()

        for i in range(numRows):
            if not result:
                result.append([1])
            else:
                result.append(list())
                result[-1].append(1)
                for j in range(i - 1):
                    result[-1].append(result[-2][j] + result[-2][j + 1])
                result[-1].append(1)

        return result