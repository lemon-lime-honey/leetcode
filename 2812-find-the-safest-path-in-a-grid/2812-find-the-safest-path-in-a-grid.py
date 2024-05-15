class Solution:
    def maximumSafenessFactor(self, grid: List[List[int]]) -> int:
        if grid[0][0] or grid[-1][-1] == 1: return 0

        maps = [[int(1e9) for i in range(len(grid))] for j in range(len(grid))]
        dr = [0, 0, -1, 1]
        dc = [1, -1, 0, 0]
        que = deque()

        for i in range(len(grid)):
            for j in range(len(grid)):
                if grid[i][j] == 1:
                    que.append((i, j))
                    maps[i][j] = 0

        while que:
            r, c = que.popleft()
            for i in range(4):
                nr, nc = r + dr[i], c + dc[i]
                if (nr < 0 or nr >= len(grid) or
                    nc < 0 or nc >= len(grid) or
                    maps[nr][nc] <= maps[r][c] + 1): continue
                maps[nr][nc] = maps[r][c] + 1
                que.append((nr, nc))

        chk = [[False for i in range(len(grid))] for j in range(len(grid))]
        heap = [(-maps[0][0], 0, 0)]
        chk[0][0] = True

        while heap:
            dist, r, c = heapq.heappop(heap)
            dist *= -1
            if r == len(grid) - 1 and c == len(grid) - 1:
                return dist
            for i in range(4):
                nr, nc = r + dr[i], c + dc[i]
                if (nr < 0 or nr >= len(grid) or
                    nc < 0 or nc >= len(grid) or
                    chk[nr][nc]): continue
                heapq.heappush(heap, (-min(dist, maps[nr][nc]), nr, nc))
                chk[nr][nc] = True

        return -1
