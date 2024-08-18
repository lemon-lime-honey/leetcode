class Solution:
    def nthUglyNumber(self, n: int) -> int:
        two, three, five = 0, 0, 0
        nums = [0 for i in range(n)]
        nums[0] = 1

        for i in range(1, n):
            nums[i] = min(nums[two] * 2, nums[three] * 3, nums[five] * 5)
            if nums[i] == nums[two] * 2: two += 1
            if nums[i] == nums[three] * 3: three += 1
            if nums[i] == nums[five] * 5: five += 1

        return nums[-1]
