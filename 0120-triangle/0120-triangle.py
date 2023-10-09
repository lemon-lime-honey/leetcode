class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        result = list()

        for line in triangle:
            if not result:
                result.append(line)
            else:
                temp = [int(1e9) for i in range(len(line))]
                for i in range(len(result[-1])):
                    temp[i] = min(line[i] + result[-1][i], temp[i])
                    temp[i + 1] = min(line[i + 1] + result[-1][i], temp[i + 1])
                result.append(temp)

        return min(result[-1])