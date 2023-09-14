from collections import deque


class Solution:
    def snakesAndLadders(self, board: List[List[int]]) -> int:
        n = len(board)
        newboard = [0]
        for i in range(n):
            if i % 2:
                newboard.extend(board[n - 1 - i][::-1])
            else:
                newboard.extend(board[n - 1 - i])
        visited = [int(1e9) for i in range(n ** 2 + 1)]
        que = deque([1])
        visited[1] = 0

        while que:
            point = que.popleft()

            for i in range(1, 7):
                next_point = point + i
                if next_point < n ** 2 + 1:
                    if newboard[next_point] != -1:
                        next_point = newboard[next_point]
                    if visited[next_point] > visited[point] + 1:
                        visited[next_point] = visited[point] + 1
                        que.append(next_point)

        return -1 if visited[n ** 2] == int(1e9) else visited[n ** 2]