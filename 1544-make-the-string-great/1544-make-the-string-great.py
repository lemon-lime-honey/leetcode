class Solution:
    def makeGood(self, s: str) -> str:
        stack = list()

        for letter in s:
            if (stack and 
                (stack[-1].isupper() and stack[-1].lower() == letter or 
                 stack[-1].islower() and stack[-1].upper() == letter)):
                stack.pop()
            else:
                stack.append(letter)

        return ''.join(stack)