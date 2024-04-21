class Solution:
    def validPath(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        chk = [False for i in range(n)]
        graph = [[] for i in range(n)]

        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)

        que = deque([source])
        chk[source] = True

        while que:
            now = que.popleft()
            if now == destination: return True
            for next_point in graph[now]:
                if chk[next_point]: continue
                chk[next_point] = True
                que.append(next_point)

        return False