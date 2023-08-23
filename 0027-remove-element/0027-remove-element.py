class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        ref = 0
        while ref < len(nums):
            if nums[ref] == val:
                nums.pop(ref)
            else: ref += 1
        return len(nums)