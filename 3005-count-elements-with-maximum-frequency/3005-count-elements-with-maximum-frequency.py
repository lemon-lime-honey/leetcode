class Solution:
    def maxFrequencyElements(self, nums: List[int]) -> int:
        freq = dict()
        maximum = 0
        result = 0

        for num in nums:
            freq[num] = freq.get(num, 0) + 1

        for num in freq.values():
            maximum = max(maximum, num)

        for num in freq.values():
            if num == maximum:
                result += num

        return result