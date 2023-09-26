from bisect import bisect_left, bisect_right


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        lo = bisect_left(nums, target)
        hi = bisect_right(nums, target)

        return [-1, -1] if lo > hi - 1 else [lo, hi - 1]