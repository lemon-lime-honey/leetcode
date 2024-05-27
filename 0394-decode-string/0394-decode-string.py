class Solution:
    def decodeString(self, s: str) -> str:
        stack = list()
        num = list()
        n = list()

        for letter in s:
            if letter.isdigit(): n.append(letter)
            elif letter == ']':
                target = list()
                while stack and stack[-1] != '[':
                    target.append(stack.pop())
                stack.pop()
                for i in range(num.pop()):
                    for j in range(len(target) - 1, -1, -1):
                        stack.append(target[j])
            elif letter == '[':
                stack.append(letter)
                num.append(int(''.join(n)))
                n.clear()
            else:
                stack.append(letter)

        return ''.join(stack)