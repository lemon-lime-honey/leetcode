class Solution:
    def maxSubarrayLength(self, nums: List[int], k: int) -> int:
        cnt = dict()
        lo, result = 0, 0

        for hi in range(len(nums)):
            cnt[nums[hi]] = cnt.get(nums[hi], 0) + 1

            while cnt[nums[hi]] > k and lo < hi:
                cnt[nums[lo]] -= 1
                lo += 1

            result = max(result, hi - lo + 1)

        return result