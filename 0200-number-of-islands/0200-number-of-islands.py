from collections import deque


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        dr, dc = (0, 0, 1, -1), (1, -1, 0, 0)
        n, m = len(grid), len(grid[0])
        visited = [[False for i in range(m)] for j in range(n)]
        que = deque()
        result = 0

        for i in range(n):
            for j in range(m):
                if grid[i][j] == '1' and not visited[i][j]:
                    visited[i][j] = True
                    que.append((i, j))

                    while que:
                        r, c = que.popleft()

                        for k in range(4):
                            nr, nc = r + dr[k], c + dc[k]
                            if (0 <= nr < n and
                                0 <= nc < m and
                                not visited[nr][nc] and
                                grid[nr][nc] == '1'
                                ):
                                visited[nr][nc] = True
                                que.append((nr, nc))

                    result += 1

        return result