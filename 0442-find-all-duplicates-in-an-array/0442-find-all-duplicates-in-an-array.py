class Solution:
    def findDuplicates(self, nums: List[int]) -> List[int]:
        result = list()

        for num in nums:
            nums[abs(num) - 1] *= -1
            if nums[abs(num) - 1] > 0:
                result.append(abs(num))

        return result