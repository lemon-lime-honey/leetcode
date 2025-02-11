class Solution:
    def removeOccurrences(self, s: str, part: str) -> str:
        stack = list()

        for c in s:
            stack.append(c)

            if len(part) <= len(stack) and stack[-1] == part[-1]:
                flag = True
                for i in range(len(part) - 1, -1, -1):
                    if part[i] != stack[i + len(stack) - len(part)]:
                        flag = False
                if flag:
                    for i in range(len(part)):
                        stack.pop()

        return ''.join(stack)