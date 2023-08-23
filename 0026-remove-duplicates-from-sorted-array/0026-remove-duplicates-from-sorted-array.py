class Solution:
    def removeDuplicates(self, nums: list[int]) -> int:
        before = 0
        ref = 0
        k = 0
        for i in range(len(nums)):
            if before != nums[i] or i == 0:
                nums[ref] = nums[i]
                before = nums[i]
                k += 1
                ref += 1
        return k