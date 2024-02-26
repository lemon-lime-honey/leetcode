from collections import deque


class RecentCounter:
    def __init__(self):
        self.que = deque()


    def ping(self, t: int) -> int:
        while self.que and t - self.que[0] > 3000:
            self.que.popleft()
        self.que.append(t)
        return len(self.que)