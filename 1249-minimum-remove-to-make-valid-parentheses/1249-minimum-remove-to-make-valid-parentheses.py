class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        string = list(s)
        stack = list()

        for i in range(len(string)):
            if string[i] == '(':
                stack.append(i)
            elif string[i] == ')':
                if stack:
                    stack.pop()
                else:
                    string[i] = ''

        while stack:
            string[stack.pop()] = ''

        return ''.join(string)