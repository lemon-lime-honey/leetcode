class Solution:
    def reverseParentheses(self, s: str) -> str:
        pair = dict()
        temp = list()

        for i in range(len(s)):
            if s[i] == '(':
                temp.append(i)
            elif s[i] == ')':
                t = temp.pop()
                pair[i] = t
                pair[t] = i

        result = list()
        direction = 1
        idx = 0

        while idx < len(s):
            if s[idx] in '()':
                idx = pair[idx]
                direction *= -1
            else:
                result.append(s[idx])
            idx += direction

        return ''.join(result)
