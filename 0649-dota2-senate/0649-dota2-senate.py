class Solution:
    def predictPartyVictory(self, senate: str) -> str:
        r, d = deque(), deque()
        n = len(senate)

        for i in range(n):
            if senate[i] == 'R': r.append(i)
            else: d.append(i)

        while r and d:
            if r[0] < d[0]: r.append(n)
            else: d.append(n)
            n += 1
            r.popleft()
            d.popleft()

        return 'Radiant' if r else 'Dire'