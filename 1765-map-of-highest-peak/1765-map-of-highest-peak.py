class Solution:
    def highestPeak(self, isWater: List[List[int]]) -> List[List[int]]:
        n, m = len(isWater), len(isWater[0])
        maps = [[-1 for i in range(m)] for j in range(n)]
        dr = [0, 0, 1, -1]
        dc = [-1, 1, 0, 0]
        que = deque()

        result = list()
        val = 0

        for i in range(n):
            for j in range(m):
                if isWater[i][j] == 1:
                    que.append((i, j))
                    maps[i][j] = 0

        while que:
            r, c = que.popleft()
            for i in range(4):
                nr, nc = r + dr[i], c + dc[i]
                if nr < 0 or nr >= n or nc < 0 or nc >= m or maps[nr][nc] != -1:
                    continue
                maps[nr][nc] = maps[r][c] + 1
                que.append((nr, nc))

        return maps