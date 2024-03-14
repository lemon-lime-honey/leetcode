class Solution:
    def numSubarraysWithSum(self, nums: List[int], goal: int) -> int:
        def getNumber(target):
            if target < 0: return 0

            lo, hi, cnt, total = 0, 0, 0, 0

            while hi < len(nums):
                total += nums[hi]
                while lo <= hi and total > target:
                    total -= nums[lo]
                    lo += 1
                cnt += hi - lo + 1
                hi += 1

            return cnt

        return getNumber(goal) - getNumber(goal - 1)