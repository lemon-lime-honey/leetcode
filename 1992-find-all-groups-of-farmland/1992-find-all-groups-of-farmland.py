class Solution:
    def findFarmland(self, land: List[List[int]]) -> List[List[int]]:
        n, m = len(land), len(land[0])
        result = list()

        visited = [[False for i in range(m)] for j in range(n)]
        dr = [0, 0, -1, 1]
        dc = [1, -1, 0, 0]

        for i in range(n):
            for j in range(m):
                if land[i][j] and not visited[i][j]:
                    que = deque([[i, j]])
                    visited[i][j] = True
                    points = [[i, j]]

                    while que:
                        r, c = que.popleft()
                        for k in range(4):
                            nr, nc = r + dr[k], c + dc[k]
                            if (nr < 0 or nr >= n or
                                nc < 0 or nc >= m or
                                visited[nr][nc] or
                                land[nr][nc] == 0):
                                continue
                            visited[nr][nc] = True
                            points.append([nr, nc])
                            que.append([nr, nc])

                    points.sort()
                    result.append(points[0])
                    result[-1].extend(points[-1])

        return result