class Solution:
    def minOperations(self, grid: List[List[int]], x: int) -> int:
        nums = list()
        result = 0

        for g in grid:
            nums.extend(g)

        nums.sort()
        target = nums[len(nums) // 2]

        for num in nums:
            chk = abs(num - target)
            if chk % x != 0:
                return -1
            result += chk // x

        return result