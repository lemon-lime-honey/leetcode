class Solution:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        exist = [False for i in range(len(nums) + 1)]
        result = list()

        for num in nums:
            if exist[num]:
                result.append(num)
            exist[num] = True

        for num in range(1, len(nums) + 1):
            if not exist[num]:
                result.append(num)

        return result