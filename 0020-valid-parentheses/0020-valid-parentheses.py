class Solution:
    def isValid(self, s: str) -> bool:
        couple = {')': '(', '}': '{', ']': '['}
        stack = list()
        for element in s:
            if element in '({[':
                stack.append(element)
            elif not stack: break
            else:
                if stack[-1] != couple[element]: break
                stack.pop()
        else:
            if stack: return False
            return True
        return False