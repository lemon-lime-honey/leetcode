class Solution:
    def climbStairs(self, n: int) -> int:
        if n == 1: return 1

        now, before = 1, 1

        for i in range(1, n):
            temp = now
            now = temp + before
            before = temp

        return now