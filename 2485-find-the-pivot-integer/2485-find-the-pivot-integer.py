class Solution:
    def pivotInteger(self, n: int) -> int:
        forward = [0 for i in range(n + 1)]
        backward = [0 for i in range(n + 1)]

        for i in range(1, n + 1):
            forward[i] = forward[i - 1] + i

        backward[n] = n

        for i in range(n - 1, 0, -1):
            backward[i] = backward[i + 1] + i

        for i in range(1, n + 1):
            if forward[i] == backward[i]:
                return i

        return -1