class Solution:
    def numSteps(self, s: str) -> int:
        last = len(s) - 1
        carry = 0
        result = 0

        while last:
            chk = int(s[last]) + carry
            if chk == 0:
                result += 1
            elif chk == 2:
                result += 1
            else:
                carry = 1
                result += 2
            last -= 1

        if carry == 1: result += 1
        return result