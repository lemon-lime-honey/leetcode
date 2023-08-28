from bisect import bisect_left


class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        if target > nums[-1]: return len(nums)

        return bisect_left(nums, target)