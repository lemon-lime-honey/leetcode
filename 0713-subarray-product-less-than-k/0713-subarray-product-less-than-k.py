class Solution:
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
        if k <= 1:
            return 0

        result = 0
        calc = 1
        lo = 0

        for hi in range(len(nums)):
            calc *= nums[hi]

            while calc >= k:
                calc //= nums[lo]
                lo += 1

            result += hi - lo + 1

        return result