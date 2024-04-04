class Solution:
    def maxDepth(self, s: str) -> int:
        cnt, result = 0, 0

        for letter in s:
            if letter == '(':
                cnt += 1
            elif letter == ')':
                cnt -= 1
            result = max(result, cnt)

        return result