class Solution:
    def findMin(self, nums: List[int]) -> int:
        lo, hi = 0, len(nums) - 1

        while lo < hi:
            mid = (lo + hi) // 2
            if nums[lo] < nums[mid] and nums[hi] < nums[mid]: lo = mid + 1
            elif nums[lo] > nums[mid] and nums[hi] > nums[mid]: hi = mid
            elif nums[mid] > nums[hi]: lo = mid + 1
            elif nums[mid] > nums[lo]: hi = mid
            else: return nums[mid]

        return nums[lo]