class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        nums.sort()
        n = len(nums)
        result = int(1e9)

        for i in range(n):
            lo, hi = i + 1, n - 1

            while lo < hi:
                chk = nums[i] + nums[lo] + nums[hi]
                if abs(target - chk) < abs(result - target):
                    result = chk
                if chk > target:
                    hi -= 1
                elif chk < target:
                    lo += 1
                else:
                    return target

        return result