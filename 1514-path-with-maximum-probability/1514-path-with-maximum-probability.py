class Solution:
    def maxProbability(self, n: int, edges: List[List[int]], succProb: List[float], start_node: int, end_node: int) -> float:
        result = [0 for i in range(n)]
        result[start_node] = 1

        for i in range(n - 1):
            flag = False
            for index, (u, v) in enumerate(edges):
                if result[u] * succProb[index] > result[v]:
                    result[v] = result[u] * succProb[index]
                    flag = True
                if result[v] * succProb[index] > result[u]:
                    result[u] = result[v] * succProb[index]
                    flag = True
            if not flag: break

        return result[end_node]
