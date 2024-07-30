class Solution:
    def minimumDeletions(self, s: str) -> int:
        stack = list()
        result = 0

        for c in s[::-1]:
            if not stack or stack[-1] >= c:
                stack.append(c)
            else:
                stack.pop()
                result += 1

        return result