class Solution:
    def maxCount(self, banned: List[int], n: int, maxSum: int) -> int:
        banned_num = set(banned)
        total = 0
        result = 0

        for num in range(1, n + 1):
            if num in banned_num:
                continue
            total += num
            if total > maxSum:
                break
            result += 1

        return result