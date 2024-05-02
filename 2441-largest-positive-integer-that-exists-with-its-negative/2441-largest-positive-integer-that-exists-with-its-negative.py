class Solution:
    def findMaxK(self, nums: List[int]) -> int:
        nums.sort()
        lo, hi = 0, len(nums) - 1

        while lo < hi:
            if nums[lo] == -1 * nums[hi]:
                return nums[hi]
            if nums[lo] < -1 * nums[hi]:
                lo += 1
            else:
                hi -= 1

        return -1