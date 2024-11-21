class Solution:
    def countUnguarded(self, m: int, n: int, guards: List[List[int]], walls: List[List[int]]) -> int:
        dr = [0, 0, -1, 1]
        dc = [1, -1, 0, 0]

        graph = [[0 for i in range(n)] for j in range(m)]

        for r, c in walls:
            graph[r][c] = 2

        for r, c in guards:
            graph[r][c] = 2

        for r, c in guards:
            for i in range(4):
                nr, nc = r, c
                while True:
                    nr += dr[i]
                    nc += dc[i]
                    if (nr < 0 or nr >= m or
                        nc < 0 or nc >= n or
                        graph[nr][nc] == 2):
                        break
                    graph[nr][nc] = 1

        return sum(r.count(0) for r in graph)