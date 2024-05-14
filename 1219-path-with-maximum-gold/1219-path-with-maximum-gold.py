class Solution:
    def getMaximumGold(self, grid: List[List[int]]) -> int:
        def backtrack(r, c, total):
            nonlocal result
            result = max(result, total)
            for i in range(4):
                nr, nc = r + dr[i], c + dc[i]
                if (nr < 0 or len(grid) <= nr or
                    nc < 0 or len(grid[0]) <= nc or
                    (nr, nc) in chk or
                    grid[nr][nc] == 0): continue
                chk.add((nr, nc))
                backtrack(nr, nc, total + grid[nr][nc])
                chk.discard((nr, nc))


        dr = [0, 0, -1, 1]
        dc = [1, -1, 0, 0]

        result = 0
        chk = set()

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] != 0:
                    chk.add((i, j))
                    backtrack(i, j, grid[i][j])
                    chk.discard((i, j))

        return result