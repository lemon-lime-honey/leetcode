class Solution:
    def findTheWinner(self, n: int, k: int) -> int:
        que = deque([i for i in range(1, n + 1)])

        while len(que) > 1:
            que.rotate(1 - k)
            que.popleft()

        return que[0]