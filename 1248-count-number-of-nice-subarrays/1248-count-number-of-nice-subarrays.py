class Solution:
    def numberOfSubarrays(self, nums: List[int], k: int) -> int:
        lo, hi, cnt = 0, 0, 0
        result = 0
        for i in range(len(nums)):
            if nums[i] % 2: cnt += 1
            while cnt > k:
                if nums[lo] % 2: cnt -= 1
                lo += 1
                hi = lo
            if cnt == k:
                while nums[hi] % 2 == 0:
                    hi += 1
                result += hi - lo + 1
        return result