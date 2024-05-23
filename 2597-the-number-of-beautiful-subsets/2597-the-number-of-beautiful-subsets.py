class Solution:
    def beautifulSubsets(self, nums: List[int], k: int) -> int:
        def backtrack(idx, sub):
            if idx == len(nums):
                if sub:
                    nonlocal result
                    result += 1
                return

            if (nums[idx] - k) not in sub:
                sub.append(nums[idx])
                backtrack(idx + 1, sub)
                sub.pop()

            backtrack(idx + 1, sub)


        nums.sort()
        result = 0
        backtrack(0, list())
        return result