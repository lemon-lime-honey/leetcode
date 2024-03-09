class Solution:
    def getCommon(self, nums1: List[int], nums2: List[int]) -> int:
        result = int(1e12)
        one, two = 0, 0

        while one < len(nums1) and two < len(nums2):
            if nums1[one] == nums2[two]:
                result = nums1[one]
                break
            elif nums1[one] < nums2[two]:
                one += 1
            else:
                two += 1

        return -1 if result == int(1e12) else result