class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        def combine(idx, route):
            if len(route) == k:
                if sum(route) == n:
                    result.append(list(route))
                    return
                return

            for i in range(idx, 10):
                route.append(i)
                combine(i + 1, route)
                route.pop()


        result = list()
        combine(1, list())
        return result