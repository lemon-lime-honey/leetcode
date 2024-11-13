class Solution:
    def countFairPairs(self, nums: List[int], lower: int, upper: int) -> int:
        nums.sort()
        result = 0

        for i in range(len(nums) - 1):
            lo = bisect_left(nums, lower - nums[i], i + 1)
            hi = bisect_right(nums, upper - nums[i], i + 1)
            result += hi - lo

        return result