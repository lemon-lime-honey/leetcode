class Solution:
    def getAncestors(self, n: int, edges: List[List[int]]) -> List[List[int]]:
        degree = [0 for i in range(n)]
        graph = [[] for i in range(n)]
        answer = [set() for i in range(n)]
        result = list()
        que = deque()

        for u, v in edges:
            degree[v] += 1
            graph[u].append(v)

        for i in range(n):
            if degree[i] == 0:
                que.append(i)

        while que:
            now = que.popleft()
            for next_point in graph[now]:
                degree[next_point] -= 1
                answer[next_point].update(answer[now])
                answer[next_point].add(now)
                if degree[next_point] == 0:
                    que.append(next_point)

        for i in range(n):
            result.append(sorted(answer[i]))

        return result