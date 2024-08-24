class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        mask = (1 << len(nums) + 1) - 1
        num = 0

        for n in nums:
            num |= 1 << n

        num &= mask

        for i in range(len(nums) + 1):
            if not num & 1:
                return i
            num >>= 1

        return -1