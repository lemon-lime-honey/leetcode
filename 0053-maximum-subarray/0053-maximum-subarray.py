class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [-int(1e9) for i in range(n)]
        result = -int(1e9)

        for i in range(n):
            if i == 0:
                dp[i] = nums[i]
                result = dp[i]
            else:
                dp[i] = max(nums[i], dp[i - 1] + nums[i])
                result = max(dp[i], result)

        return result