class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        def backtrack(idx, total, route):
            if total >= target:
                if total == target:
                    result.append(list(route))
                return

            for i in range(idx, len(candidates)):
                if i > idx and candidates[i] == candidates[i - 1]:
                    continue
                backtrack(i + 1, total + candidates[i], route + [candidates[i]])

        candidates.sort()
        result = list()
        backtrack(0, 0, list())
        return result