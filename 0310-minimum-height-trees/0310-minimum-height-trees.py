class Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        if n == 1: return [0]

        degree = defaultdict(set)
        result = list()
        que = deque()

        for u, v in edges:
            degree[u].add(v)
            degree[v].add(u)

        for key, value in degree.items():
            if len(value) == 1:
                que.append(key)
                result.append(key)

        while que:
            n = len(que)
            result = list()

            for i in range(n):
                now = que.popleft()
                result.append(now)
                for next_point in degree[now]:
                    degree[next_point].discard(now)
                    if len(degree[next_point]) == 1:
                        que.append(next_point)

        return result