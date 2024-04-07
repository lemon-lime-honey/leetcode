class Solution:
    def checkValidString(self, s: str) -> bool:
        minimum, maximum = 0, 0

        for letter in s:
            if letter == '(':
                minimum += 1
                maximum += 1
            elif letter == ')':
                minimum -= 1
                maximum -= 1
            else:
                maximum += 1
                minimum -= 1
            if maximum < 0: return False
            minimum = max(minimum, 0)

        return minimum == 0