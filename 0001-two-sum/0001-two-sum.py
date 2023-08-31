from collections import defaultdict


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        numdict = defaultdict()

        for index, num in enumerate(nums):
            numdict[num] = index

        for index, num in enumerate(nums):
            if target - num in numdict and numdict[target - num] != index:
                return [index, numdict[target - num]]