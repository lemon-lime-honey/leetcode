class Solution:
    def maxDepth(self, s: str) -> int:
        stack = list()

        for letter in s:
            if letter == '(':
                stack.append(letter)
            elif letter == ')':
                depth = 0
                while stack[-1] != '(':
                    depth = max(depth, stack.pop())
                stack.pop()
                stack.append(depth + 1)
            else:
                stack.append(0)

        return max(stack)