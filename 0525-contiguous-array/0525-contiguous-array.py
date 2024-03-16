class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        prefix = {0: -1}
        total, result = 0, 0

        for i in range(len(nums)):
            if nums[i] == 0:
                total -= 1
            else:
                total += 1
            if total not in prefix:
                prefix[total] = i
            else:
                result = max(result, i - prefix[total])

        return result