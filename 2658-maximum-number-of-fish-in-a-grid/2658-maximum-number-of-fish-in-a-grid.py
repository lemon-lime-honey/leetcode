class Solution:
    def findMaxFish(self, grid: List[List[int]]) -> int:
        def bfs(row, col):
            que = deque([(row, col)])
            res = grid[row][col]
            chk[row][col] = True

            while que:
                r, c = que.popleft()
                for i in range(4):
                    nr, nc = r + dr[i], c + dc[i]
                    if ((nr < 0 or nr >= len(grid)) or
                        (nc < 0 or nc >= len(grid[0])) or 
                        (grid[nr][nc] == 0 or chk[nr][nc])):
                        continue
                    res += grid[nr][nc]
                    que.append((nr, nc))
                    chk[nr][nc] = True

            return res

        chk = [[False for i in range(len(grid[0]))] for j in range(len(grid))]
        dr = [0, 0, -1, 1]
        dc = [1, -1, 0, 0]
        result = 0

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 0 or chk[i][j]:
                    continue
                result = max(result, bfs(i, j))

        return result