class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        def get(idx, sub):
            result.append(copy.deepcopy(sub))
            for i in range(idx, len(nums)):
                sub.append(nums[i])
                get(i + 1, sub)
                sub.pop()


        result = list()
        get(0, list())
        return result