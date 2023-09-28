class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        def combination(index):
            if len(route) == k:
                result.append(list(route))
                return

            for i in range(index, n + 1):
                if not visited[i]:
                    route.add(i)
                    visited[i] = True
                    combination(i + 1)
                    route.remove(i)
                    visited[i] = False

        visited = [False for i in range(n + 1)]
        result = list()
        route = set()

        combination(1)

        return result