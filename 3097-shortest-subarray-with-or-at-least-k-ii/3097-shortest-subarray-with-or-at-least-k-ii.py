class Solution:
    def minimumSubarrayLength(self, nums: List[int], k: int) -> int:
        if k == 0: return 1

        bits = [0 for i in range(32)]
        result = len(nums) + 1
        lo = 0

        for hi in range(len(nums)):
            temp = 0
            for i in range(32):
                if nums[hi] & (1 << i):
                    bits[i] += 1
                if bits[i]:
                    temp |= (1 << i)

            if temp >= k:
                result = min(result, hi - lo + 1)

            while temp >= k:
                temp = 0
                for i in range(32):
                    if nums[lo] & (1 << i):
                        bits[i] -= 1
                    if bits[i]:
                        temp |= (1 << i)

                lo += 1
                if temp >= k:
                    result = min(result, hi - lo + 1)

        return -1 if result == len(nums) + 1 else result