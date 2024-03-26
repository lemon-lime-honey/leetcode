class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        n = len(nums)

        for i in range(n):
            if 0 < nums[i] < n + 1: continue
            nums[i] = n + 1

        for i in range(n):
            target = abs(nums[i])
            if target > n: continue

            target -= 1

            if nums[target] > 0:
                nums[target] *= -1

        for i in range(n):
            if nums[i] > 0:
                return i + 1

        return n + 1