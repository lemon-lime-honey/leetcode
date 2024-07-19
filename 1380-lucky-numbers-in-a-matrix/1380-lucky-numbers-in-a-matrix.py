class Solution:
    def luckyNumbers (self, matrix: List[List[int]]) -> List[int]:
        minimum = set()
        result = list()

        for row in matrix:
            minimum.add(min(row))

        for col in zip(*matrix):
            target = max(col)
            if target in minimum:
                result.append(target)

        return result
