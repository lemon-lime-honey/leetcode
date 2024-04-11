class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack = list()

        for n in num:
            while stack and k and stack[-1] > n:
                stack.pop()
                k -= 1

            if stack or n != '0':
                stack.append(n)

        if k > 0:
            stack = stack[:-k]

        return ''.join(stack) if stack else '0'