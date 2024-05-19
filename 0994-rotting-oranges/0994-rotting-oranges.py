class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        dr = [0, 0, -1, 1]
        dc = [1, -1, 0, 0]

        chk = [[False for i in range(len(grid[0]))] for j in range(len(grid))]
        que = deque()
        result = 0

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 2:
                    que.append((i, j))
                    chk[i][j] = True

        while que:
            n = len(que)
            flag = False
            for i in range(n):
                r, c = que.popleft()
                for i in range(4):
                    nr, nc = r + dr[i], c + dc[i]
                    if (nr < 0 or nc < 0 or
                        nr >= len(grid) or nc >= len(grid[0]) or
                        grid[nr][nc] != 1 or
                        chk[nr][nc]):
                        continue
                    grid[nr][nc] = 2
                    que.append((nr, nc))
                    chk[nr][nc] = True
                    flag = True
            if flag: result += 1

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    return -1

        return result
