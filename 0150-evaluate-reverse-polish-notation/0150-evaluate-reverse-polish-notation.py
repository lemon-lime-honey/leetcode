class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = list()
        for i in range(len(tokens)):
            if tokens[i].strip('-').isdigit(): stack.append(tokens[i])
            elif tokens[i] in "+-*/":
                second = stack.pop()
                first = stack.pop()
                stack.append(str(int(eval(first + tokens[i] + second))))
        return int(stack.pop())