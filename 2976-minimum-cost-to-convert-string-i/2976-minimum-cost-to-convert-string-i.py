class Solution:
    def minimumCost(self, source: str, target: str, original: List[str], changed: List[str], cost: List[int]) -> int:
        n = len(source)
        graph = [[int(1e9) for i in range(26)] for j in range(26)]
        result = 0

        for i in range(len(original)):
            o, c = ord(original[i]) - ord('a'), ord(changed[i]) - ord('a')
            graph[o][c] = min(graph[o][c], cost[i])

        for i in range(26):
            for j in range(26):
                for k in range(26):
                    if graph[j][k] <= graph[j][i] + graph[i][k]:
                        continue
                    graph[j][k] = graph[j][i] + graph[i][k]

        for i in range(n):
            if source[i] == target[i]: continue
            u, v = ord(source[i]) - ord('a'), ord(target[i]) - ord('a')
            if graph[u][v] == int(1e9): return -1
            result += graph[u][v]

        return result
