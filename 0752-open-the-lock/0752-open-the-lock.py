class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        stop = set(deadends)
        que = deque([('0000', 0)])
        seen = set('0000')

        while que:
            now, cnt = que.popleft()
            if now == target: return cnt
            if now in stop: continue
            for i in range(4):
                temp = int(now[i])
                for step in (-1, 1):
                    ttemp = (temp + step) % 10
                    new = now[:i] + str(ttemp) + now[i + 1:]
                    if new not in seen:
                        seen.add(new)
                        que.append((new, cnt + 1))

        return -1