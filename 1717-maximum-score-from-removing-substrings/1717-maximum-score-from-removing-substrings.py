class Solution:
    def maximumGain(self, s: str, x: int, y: int) -> int:
        chk = ["ab", "ba"]
        result = 0

        if x < y:
            chk[0], chk[1] = chk[1], chk[0]
            x, y = y, x

        stack = list()

        for letter in s:
            if letter == chk[0][1] and stack and stack[-1] == chk[0][0]:
                result += x
                stack.pop()
            else:
                stack.append(letter)

        new_stack = list()

        for letter in stack:
            if letter == chk[1][1] and new_stack and new_stack[-1] == chk[1][0]:
                result += y
                new_stack.pop()
            else:
                new_stack.append(letter)

        return result
