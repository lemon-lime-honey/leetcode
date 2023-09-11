import heapq


class Solution:
    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:
        result = list()

        for i in range(min(k, len(nums1))):
            for j in range(min(k, len(nums2))):
                if len(result) < k:
                    heapq.heappush(result, (-(nums1[i] + nums2[j]), [nums1[i], nums2[j]]))
                else:
                    if result[0][0] < -(nums1[i] + nums2[j]):
                        heapq.heappop(result)
                        heapq.heappush(result, (-(nums1[i] + nums2[j]), [nums1[i], nums2[j]]))
                    else: break

        return [coord[1] for coord in result]