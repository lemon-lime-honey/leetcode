class Solution:
    def minGroups(self, intervals: List[List[int]]) -> int:
        sorted_start = sorted(x[0] for x in intervals)
        sorted_end = sorted(x[1] for x in intervals)
        result, idx = 0, 0

        for start in sorted_start:
            if start > sorted_end[idx]:
                idx += 1
            else:
                result += 1

        return result