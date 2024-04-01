class Solution:
    def totalCost(self, costs: List[int], k: int, candidates: int) -> int:
        lo, hi = 0, len(costs) - 1
        left, right = list(), list()
        result = 0

        for i in range(k):
            while len(left) < candidates and lo <= hi:
                heapq.heappush(left, costs[lo])
                lo += 1

            while len(right) < candidates and lo <= hi:
                heapq.heappush(right, costs[hi])
                hi -= 1

            left_cost, right_cost = int(1e9), int(1e9)

            if left: left_cost = left[0]
            if right: right_cost = right[0]

            if left_cost <= right_cost:
                result += left_cost
                heapq.heappop(left)
            else:
                result += right_cost
                heapq.heappop(right)

        return result