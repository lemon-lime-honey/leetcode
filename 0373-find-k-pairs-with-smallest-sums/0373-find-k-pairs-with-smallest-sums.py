import heapq


class Solution:
    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:
        heap = list()
        result = list()

        for num in nums1:
            heapq.heappush(heap, (num + nums2[0], 0))

        while (k > 0 and heap):
            total, idx = heapq.heappop(heap)
            result.append([total - nums2[idx], nums2[idx]])

            if (idx + 1 < len(nums2)):
                heapq.heappush(heap, (total - nums2[idx] + nums2[idx + 1], idx + 1))

            k -= 1

        return result