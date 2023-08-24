class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if len(nums) == 1: return True
        dp = [False for i in range(len(nums))]
        dp[-1] = True
        for i in range(len(nums) - 2, -1, -1):
            if nums[i] + i >= len(nums) - 1: dp[i] = True
            else:
                for j in range(i + 1, i + nums[i] + 1):
                    if dp[j]:
                        dp[i] = True
                        break
        return dp[0]