class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        def get(nums, idx):
            chk = sum(nums)

            if chk == target:
                result.append(nums)
            elif chk < target:
                for i in range(idx, len(candidates)):
                    get(nums + [candidates[i]], i)


        result = list()
        get([], 0)
        return result