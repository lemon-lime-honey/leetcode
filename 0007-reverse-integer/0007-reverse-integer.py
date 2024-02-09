class Solution:
    def reverse(self, x: int) -> int:
        result = int(str(abs(x))[::-1])

        if result.bit_length() >= 32:
            return 0
        elif x < 0:
            return -result
        return result