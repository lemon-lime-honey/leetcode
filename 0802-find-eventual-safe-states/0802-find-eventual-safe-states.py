class Solution:
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        result = list()
        que = deque()

        degree = [0 for i in range(len(graph))]
        routes = [[] for i in range(len(graph))]

        for i in range(len(graph)):
            for j in range(len(graph[i])):
                degree[i] += 1
                routes[graph[i][j]].append(i)

        for i in range(len(degree)):
            if degree[i] == 0:
                que.append(i)
                result.append(i)

        while que:
            now = que.popleft()
            for next_point in routes[now]:
                if degree[next_point]:
                    degree[next_point] -= 1
                if degree[next_point] == 0:
                    que.append(next_point)
                    result.append(next_point)

        result.sort()

        return result