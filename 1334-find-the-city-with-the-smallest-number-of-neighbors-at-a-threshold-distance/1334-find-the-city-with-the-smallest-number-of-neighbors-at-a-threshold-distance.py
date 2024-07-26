class Solution:
    def findTheCity(self, n: int, edges: List[List[int]], distanceThreshold: int) -> int:
        graph = [[int(1e9) for i in range(n)] for j in range(n)]
        result = defaultdict(list)

        for f, t, w in edges:
            graph[f][t] = w
            graph[t][f] = w

        for i in range(n):
            graph[i][i] = 0

        for i in range(n):
            for j in range(n):
                for k in range(n):
                    if graph[j][k] <= graph[j][i] + graph[i][k]: continue
                    graph[j][k] = graph[j][i] + graph[i][k]

        for i in range(n):
            cnt = 0
            for j in range(n):
                if i != j and graph[i][j] <= distanceThreshold:
                    cnt += 1
            result[cnt].append(i)
        
        return sorted(sorted(result.items(), key=lambda x: x[0])[0][1])[-1]
