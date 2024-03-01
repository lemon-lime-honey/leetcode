class Solution:
    def nearestExit(self, maze: List[List[str]], entrance: List[int]) -> int:
        m = len(maze)
        n = len(maze[0])
        que = deque([entrance])
        chk = [[-1 for i in range(n)] for j in range(m)]
        chk[entrance[0]][entrance[1]] = 0

        dr = [0, 0, -1, 1]
        dc = [1, -1, 0, 0]

        while que:
            r, c = que.popleft()
            if ((r == 0 or c == 0 or r == m - 1 or c == n - 1) and
                not (r == entrance[0] and c == entrance[1])):
                return chk[r][c]

            for i in range(4):
                nr, nc = r + dr[i], c + dc[i]
                if (0 <= nr < m and 0 <= nc < n and
                    chk[nr][nc] == -1 and
                    maze[nr][nc] == '.'):
                    chk[nr][nc] = chk[r][c] + 1
                    que.append((nr, nc))

        return -1