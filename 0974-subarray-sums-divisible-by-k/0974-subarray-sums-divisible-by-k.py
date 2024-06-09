class Solution:
    def subarraysDivByK(self, nums: List[int], k: int) -> int:
        sums = [1] + [0 for i in range(k)]
        total = 0
        result = 0

        for num in nums:
            total += num
            total %= k
            if sums[total]: result += sums[total]
            sums[total] += 1

        return result