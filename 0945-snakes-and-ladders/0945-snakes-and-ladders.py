from collections import deque


class Solution:
    def snakesAndLadders(self, board: List[List[int]]) -> int:
        def conversion(number):
            r = (number - 1) // n
            c = (number - 1) % n
            if r % 2: c = n - 1 - c

            return (r, c)


        board = board[::-1]
        n = len(board)
        que = deque([1])
        visited = [int(1e9) for i in range(n ** 2 + 1)]
        visited[1] = 0
        
        while que:
            now = que.popleft()

            for i in range(1, 7):
                point = now + i
                nr, nc = conversion(point)

                if 0 <= nr < n and 0 <= nc < n:
                    if board[nr][nc] != -1:
                        point = board[nr][nc]
                    if point == n ** 2: return visited[now] + 1
                    if visited[point] > visited[now] + 1:
                        visited[point] = visited[now] + 1
                        que.append(point)

        return -1