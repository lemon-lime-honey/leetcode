class Solution:
    def findLHS(self, nums: List[int]) -> int:
        cnt = Counter(nums)
        result = 0

        for num in cnt:
            if num + 1 in cnt:
                result = max(result, cnt[num] + cnt[num + 1])

        return result