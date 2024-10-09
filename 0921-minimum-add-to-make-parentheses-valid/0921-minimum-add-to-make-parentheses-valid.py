class Solution:
    def minAddToMakeValid(self, s: str) -> int:
        result = [0, 0]

        for p in s:
            if p == '(':
                result[0] += 1
            elif p == ')' and result[0] > 0:
                result[0] -= 1
            else:
                result[1] += 1

        return sum(result)