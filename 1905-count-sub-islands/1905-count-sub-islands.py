class Solution:
    def countSubIslands(self, grid1: List[List[int]], grid2: List[List[int]]) -> int:
        def find(r, c):
            grid2[r][c] = 0

            if grid1[r][c] == 0:
                nonlocal flag
                flag = False

            for i in range(4):
                nr, nc = r + dr[i], c + dc[i]
                if (nr < 0 or nc < 0
                    or nr >= n or nc >= m
                    or grid2[nr][nc] == 0):
                    continue
                find(nr, nc)

            return flag

        n, m = len(grid1), len(grid1[0])
        dr = [0, 0, -1, 1]
        dc = [1, -1, 0, 0]
        result = 0

        for i in range(n):
            for j in range(m):
                if grid2[i][j] == 1:
                    flag = True
                    if find(i, j):
                        result += 1

        return result