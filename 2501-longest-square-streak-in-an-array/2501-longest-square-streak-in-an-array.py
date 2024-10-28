class Solution:
    def longestSquareStreak(self, nums: List[int]) -> int:
        num_map = dict()
        result = -1
        nums.sort()

        for num in nums:
            sqrt = isqrt(num)

            if sqrt * sqrt == num and sqrt in num_map:
                num_map[num] = num_map[sqrt] + 1
                result = max(result, num_map[num])
            else:
                num_map[num] = 1

        return result