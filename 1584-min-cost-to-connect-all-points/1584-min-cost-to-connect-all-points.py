from collections import defaultdict
import heapq


class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        edges = defaultdict(list)
        n = len(points)

        for i in range(n):
            for j in range(i + 1, n):
                dist = (abs(points[i][0] - points[j][0]) +
                        abs(points[i][1] - points[j][1]))
                edges[i].append([j, dist])
                edges[j].append([i, dist])

        chk = set()
        heap = [(0, 0)]
        result = 0

        while len(chk) < n:
            dist, point = heapq.heappop(heap)
            if point in chk: continue
            result += dist
            chk.add(point)

            for next_point, next_dist in edges[point]:
                if next_point in chk: continue
                heapq.heappush(heap, (next_dist, next_point))

        return result