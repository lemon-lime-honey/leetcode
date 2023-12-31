class Solution:
    def myAtoi(self, s: str) -> int:
        negative = False
        start = False
        result = 0

        for letter in s:
            if not start:
                if letter == ' ':
                    continue
                elif letter == '+':
                    start = True
                elif letter == '-':
                    negative = True
                    start = True
                elif letter.isdigit():
                    result += int(letter)
                    start = True
                else:
                    break
            else:
                if letter.isdigit():
                    result = result * 10 + int(letter)
                else:
                    break

        if negative:
            result = min(2 ** 31, result)
            result *= -1
        else:
            result = min(2 ** 31 - 1, result)

        return result