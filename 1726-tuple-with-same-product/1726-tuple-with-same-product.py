class Solution:
    def tupleSameProduct(self, nums: List[int]) -> int:
        numDict = defaultdict(list)
        result = 0

        for i in range(len(nums)):
            for j in range(i + 1, len(nums)):
                numDict[nums[i] * nums[j]].append((nums[i], nums[j]))

        for pairs in numDict.values():
            result += len(pairs) * (len(pairs) - 1) * 4

        return result