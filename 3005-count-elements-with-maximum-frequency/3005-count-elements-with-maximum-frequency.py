class Solution:
    def maxFrequencyElements(self, nums: List[int]) -> int:
        freq = dict()
        for num in nums:
            freq[num] = freq.get(num, 0) + 1
        frequency = sorted(freq.items(), key=lambda x: -x[1])
        maximum = frequency[0][1]
        result = 0

        for key, value in frequency:
            if value == maximum:
                result += value
            else:
                break

        return result