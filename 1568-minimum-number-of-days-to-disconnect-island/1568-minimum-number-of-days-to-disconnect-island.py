class Solution:
    def minDays(self, grid: List[List[int]]) -> int:
        def bfs(row, col, visited, grid):
            que = deque([(row, col)])
            while que:
                r, c = que.popleft()
                for dr, dc in ((0, 1), (0, -1), (1, 0), (-1, 0)):
                    nr, nc = r + dr, c + dc
                    if (nr < 0 or nr >= len(grid)
                        or nc < 0 or nc >= len(grid[0])
                        or grid[nr][nc] == 0
                        or visited[nr][nc]):
                        continue
                    visited[nr][nc] = True
                    que.append((nr, nc))

        def cnt_isle(grid):
            chk = [[False for i in range(len(grid[0]))] for j in range(len(grid))]
            cnt = 0

            for i in range(len(grid)):
                for j in range(len(grid[0])):
                    if grid[i][j] == 1 and not chk[i][j]:
                        bfs(i, j, chk, grid)
                        cnt += 1

            return cnt != 1

        result = 0

        if cnt_isle(grid): return result

        result += 1

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    grid[i][j] = 0
                    if cnt_isle(grid): return result
                    grid[i][j] = 1

        result += 1

        return result