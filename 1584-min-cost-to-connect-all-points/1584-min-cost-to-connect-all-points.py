import heapq


class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        def find(p):
            if chk[p] != p:
                chk[p] = find(chk[p])
            return chk[p]


        def union(p, q):
            p, q = find(p), find(q)
            if p < q:
                chk[q] = p
            else:
                chk[p] = q


        data = list()

        for i in range(len(points)):
            for j in range(i + 1, len(points)):
                dist = (abs(points[i][0] - points[j][0]) + 
                        abs(points[i][1] - points[j][1]))
                heapq.heappush(data, (dist, i, j))

        chk = [i for i in range(len(points))]
        result = 0

        while data:
            dist, start, end = heapq.heappop(data)
            if find(start) == find(end):
                continue
            result += dist
            union(start, end)

        return result