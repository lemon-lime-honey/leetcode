class Solution:
    def minPatches(self, nums: List[int], n: int) -> int:
        num, idx, result = 1, 0, 0

        while num <= n:
            if idx < len(nums) and nums[idx] <= num:
                num += nums[idx]
                idx += 1
            else:
                num += num
                result += 1

        return result