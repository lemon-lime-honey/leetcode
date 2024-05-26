class Solution:
    def minReorder(self, n: int, connections: List[List[int]]) -> int:
        routes = defaultdict(list)

        for a, b in connections:
            routes[a].append((b, 1))
            routes[b].append((a, 0))

        que = deque([0])
        chk = set([0])
        result = 0

        while que:
            now = que.popleft()
            for next_point, cost in routes[now]:
                if next_point in chk: continue
                chk.add(next_point)
                result += cost
                que.append(next_point)

        return result