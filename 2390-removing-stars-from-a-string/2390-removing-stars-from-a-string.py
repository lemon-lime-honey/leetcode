class Solution:
    def removeStars(self, s: str) -> str:
        stack = list()

        for c in s:
            if c != '*':
                stack.append(c)
            else:
                stack.pop()

        return ''.join(stack)