class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        total = 0
        sums = dict()

        for i in range(len(nums)):
            total += nums[i]
            total %= k

            if total == 0 and i > 0: return True
            if total in sums and i - sums[total] > 1: return True
            if total not in sums: sums[total] = i

        return False