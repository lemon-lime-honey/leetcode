class Solution:
    def mergeSimilarItems(self, items1: List[List[int]], items2: List[List[int]]) -> List[List[int]]:
        temp = [0 for i in range(1001)]
        result = list()

        for v, w in items1:
            temp[v] += w

        for v, w in items2:
            temp[v] += w

        for idx, val in enumerate(temp):
            if val:
                result.append([idx, val])

        return result