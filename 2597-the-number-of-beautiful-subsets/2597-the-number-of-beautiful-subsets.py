class Solution:
    def beautifulSubsets(self, nums: List[int], k: int) -> int:
        def backtrack(idx, sub):
            if sub:
                nonlocal result
                result += 1

            if idx == len(nums):
                return

            for i in range(idx, len(nums)):
                flag = False
                for n in sub:
                    if abs(nums[i] - n) == k:
                        flag = True
                        break
                if flag: continue
                sub.append(nums[i])
                backtrack(i + 1, sub)
                sub.pop()


        result = 0
        backtrack(0, list())
        return result