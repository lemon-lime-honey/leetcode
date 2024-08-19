class Solution:
    def minSteps(self, n: int) -> int:
        result = [0 for i in range(n + 1)]

        for i in range(2, n + 1):
            result[i] = i
            for j in range(i // 2, 1, -1):
                if i % j == 0:
                    result[i] = result[j] + i // j
                    break

        return result[-1]