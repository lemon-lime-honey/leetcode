class Solution:
    def frequencySort(self, nums: List[int]) -> List[int]:
        cnt = sorted(Counter(nums).most_common(), key=lambda x: (x[1], -x[0]))
        result = list()

        for k, v in cnt:
            for i in range(v):
                result.append(k)

        return result
