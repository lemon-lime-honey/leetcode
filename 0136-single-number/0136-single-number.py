class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        numSet = set()

        for num in nums:
            if num not in numSet:
                numSet.add(num)
            else:
                numSet.discard(num)

        return numSet.pop()