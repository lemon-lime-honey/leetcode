class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        points.sort(key=lambda x:x[0])
        ref = points[0][1]
        result = 1

        for s, e in points[1:]:
            if s > ref:
                result += 1
                ref = e
            else:
                ref = min(ref, e)

        return result