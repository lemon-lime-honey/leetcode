class Solution:
    def maxDistance(self, arrays: List[List[int]]) -> int:
        small, big, result = arrays[0][0], arrays[0][-1], 0

        for array in arrays[1:]:
            result = max(result, abs(array[-1] - small), abs(big - array[0]))
            small = min(small, array[0])
            big = max(big, array[-1])

        return result