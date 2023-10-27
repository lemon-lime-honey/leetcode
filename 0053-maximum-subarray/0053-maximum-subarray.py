class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        result = nums[0]
        now = nums[0]

        for num in nums[1:]:
            now = max(num, now + num)
            result = max(result, now)

        return result