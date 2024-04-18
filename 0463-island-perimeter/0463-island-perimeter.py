class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        dr = (0, 0, -1, 1)
        dc = (1, -1, 0, 0)
        n = len(grid)
        m = len(grid[0])
        result = 0

        for i in range(n):
            for j in range(m):
                if grid[i][j] == 1:
                    cnt = 0
                    for k in range(4):
                        r, c = i + dr[k], j + dc[k]
                        if r < 0 or r >= n or c < 0 or c >= m:
                            cnt += 1
                            continue
                        if grid[r][c] == 0:
                            cnt += 1
                    result += cnt

        return result
