class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        result = [1 for i in range(len(nums))]

        for i in range(1, len(nums)):
            result[i] = result[i - 1] * nums[i - 1]

        before = 1

        for i in range(len(nums) - 1, -1, -1):
            result[i] *= before
            before *= nums[i]

        return result