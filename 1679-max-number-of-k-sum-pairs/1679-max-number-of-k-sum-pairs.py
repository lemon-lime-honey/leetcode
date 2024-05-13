class Solution:
    def maxOperations(self, nums: List[int], k: int) -> int:
        nums.sort()
        lo, hi = 0, len(nums) - 1
        result = 0

        while lo < hi:
            chk = nums[lo] + nums[hi]
            if chk < k:
                lo += 1
            elif chk > k:
                hi -= 1
            else:
                result += 1
                lo += 1
                hi -= 1

        return result