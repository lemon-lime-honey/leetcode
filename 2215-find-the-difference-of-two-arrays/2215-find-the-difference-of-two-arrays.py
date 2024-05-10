class Solution:
    def findDifference(self, nums1: List[int], nums2: List[int]) -> List[List[int]]:
        n1, n2 = set(nums1), set(nums2)
        result = list()
        result.append(list(n1.difference(n2)))
        result.append(list(n2.difference(n1)))
        return result