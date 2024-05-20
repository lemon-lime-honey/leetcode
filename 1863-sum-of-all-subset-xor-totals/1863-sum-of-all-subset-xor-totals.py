class Solution:
    def subsetXORSum(self, nums: List[int]) -> int:
        def solve(n, value):
            if n == len(nums): return value
            return solve(n + 1, value ^ nums[n]) + solve(n + 1, value)


        return solve(0, 0)