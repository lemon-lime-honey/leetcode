class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        result = list()
        nums = set()
        seen = set()

        for num in nums1:
            nums.add(num)

        for num in nums2:
            if num in nums and num not in seen:
                result.append(num)
                seen.add(num)

        return result