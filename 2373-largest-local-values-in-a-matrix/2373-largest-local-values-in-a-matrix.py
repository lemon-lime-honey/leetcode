class Solution:
    def largestLocal(self, grid: List[List[int]]) -> List[List[int]]:
        maxLocal = [[0 for i in range(len(grid) - 2)] for j in range(len(grid) - 2)]

        for i in range(len(grid) - 2):
            for j in range(len(grid) - 2):
                for k in range(3):
                    for l in range(3):
                        maxLocal[i][j] = max(maxLocal[i][j], grid[i + k][j + l])

        return maxLocal