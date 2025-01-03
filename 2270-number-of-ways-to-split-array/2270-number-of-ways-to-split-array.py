class Solution:
    def waysToSplitArray(self, nums: List[int]) -> int:
        left, right, result = 0, sum(nums), 0

        for i in range(len(nums) - 1):
            left += nums[i]
            right -= nums[i]
            if right <= left:
                result += 1

        return result