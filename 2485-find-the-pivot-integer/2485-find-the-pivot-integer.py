class Solution:
    def pivotInteger(self, n: int) -> int:
        if n == 1: return 1;

        prefix = [0 for i in range(n + 1)]

        for i in range(1, n + 1):
            prefix[i] = prefix[i - 1] + i

        for i in range(n - 1, 0, -1):
            if prefix[n] - prefix[i - 1] == prefix[i]:
                return i

        return -1