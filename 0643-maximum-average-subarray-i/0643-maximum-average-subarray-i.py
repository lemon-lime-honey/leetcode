class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        lo, hi = 0, k - 1
        total = sum(nums[:k])
        result = total

        while hi < len(nums) - 1:
            lo += 1
            hi += 1
            total += nums[hi] - nums[lo - 1]
            result = max(result, total)

        return result / k