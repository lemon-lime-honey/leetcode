class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if len(nums) == 1:
            return 0 if nums[0] == target else -1

        lo, hi = 0, len(nums) - 1

        while lo < hi:
            mid = lo + (hi - lo) // 2

            if nums[mid] < nums[hi]:
                hi = mid
            else:
                lo = mid + 1

        pivot = lo
        original = nums[pivot:] + nums[:pivot]
        lo, hi = 0, len(original) - 1

        while lo < hi:
            mid = lo + (hi - lo) // 2

            if original[mid] == target:
                if mid + pivot >= len(nums):
                    return mid + pivot - len(nums)
                else: return mid + pivot
            elif original[mid] < target:
                lo = mid + 1
            else:
                hi = mid

        if original[lo] == target:
            if lo + pivot >= len(nums): return lo + pivot - len(nums)
            else: return lo + pivot
        return -1