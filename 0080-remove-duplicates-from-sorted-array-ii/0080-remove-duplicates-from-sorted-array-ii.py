class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        before = [0, 0]
        ref = 0
        k = 0
        for i in range(len(nums)):
            if before[0] != nums[i] or i == 0:
                nums[ref] = nums[i]
                before = [nums[i], 1]
                k += 1
                ref += 1
            elif before[0] == nums[i] and before[1] < 2:
                nums[ref] = nums[i]
                before[1] += 1
                k += 1
                ref += 1
        return k