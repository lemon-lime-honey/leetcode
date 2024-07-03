class Solution:
    def minDifference(self, nums: List[int]) -> int:
        if len(nums) < 5: return 0
        result = int(1e12)
        nums.sort()

        for i in range(4):
            result = min(result, nums[i - 4] - nums[i])

        return result