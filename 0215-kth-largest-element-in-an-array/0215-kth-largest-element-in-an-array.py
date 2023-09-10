import heapq


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        result = list()

        for num in nums:
            heapq.heappush(result, -num)

        for i in range(k):
            res = heapq.heappop(result)

        return -res