class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        lo, add = 0, 0
        result = int(1e9)

        for i in range(len(nums)):
            add += nums[i]
            while add >= target:
                result = min(result, i - lo + 1)
                add -= nums[lo]
                lo += 1

        return 0 if result == int(1e9) else result