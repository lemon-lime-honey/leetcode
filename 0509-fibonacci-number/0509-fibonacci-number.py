class Solution:
    def fib(self, n: int) -> int:
        if n == 0: return 0

        a, b, result = 0, 1, 1

        for i in range(n - 1):
            result = a + b
            a, b = b, result

        return result