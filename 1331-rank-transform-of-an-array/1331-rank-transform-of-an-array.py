class Solution:
    def arrayRankTransform(self, arr: List[int]) -> List[int]:
        sorted_without_duplicate = sorted(list(set(arr)))
        rankDict = dict()
        result = [0 for i in range(len(arr))]

        for idx, num in enumerate(sorted_without_duplicate):
            rankDict[num] = idx + 1

        for idx, num in enumerate(arr):
            result[idx] = rankDict[num]

        return result