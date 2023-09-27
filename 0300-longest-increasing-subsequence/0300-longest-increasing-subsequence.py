class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        result = list()
        result.append(nums[0])

        for i in range(1, len(nums)):
            if result[-1] < nums[i]:
                result.append(nums[i])
            else:
                lo, hi = 0, len(result) - 1

                while lo < hi:
                    mid = (lo + hi) // 2

                    if result[mid] < nums[i]:
                        lo = mid + 1
                    else:
                        hi = mid

                result[lo] = nums[i]

        return len(result)