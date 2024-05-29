class Solution:
    def numSteps(self, s: str) -> int:
        target = 0
        result = 0

        for i in range(len(s) - 1, -1, -1):
            if s[i] == '1':
                target += 2 ** (len(s) - 1 - i)

        while target != 1:
            result += 1
            if target % 2:
                target += 1
            else:
                target = target >> 1

        return result