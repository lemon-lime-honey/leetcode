class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        cnt, result, lo, maxNum = 0, 0, 0, max(nums)

        for hi in range(len(nums)):
            if nums[hi] == maxNum:
                cnt += 1

            while cnt >= k:
                result += len(nums) - hi
                if nums[lo] == maxNum:
                    cnt -= 1
                lo += 1

        return result