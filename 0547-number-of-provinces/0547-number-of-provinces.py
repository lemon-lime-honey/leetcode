class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        def find(p):
            if city[p] != p:
                city[p] = find(city[p])
            return city[p]


        def union(p, q):
            p, q = find(p), find(q)
            if p == q: return
            if p < q: city[q] = p
            else: city[p] = q


        n = len(isConnected)
        city = [i for i in range(n)]
        result = set()

        for i in range(n):
            for j in range(n):
                if i != j and isConnected[i][j] == 1:
                    a, b = find(i), find(j)
                    if a != b: union(a, b)

        for i in range(n):
            find(i)
            result.add(city[i])

        return len(result)