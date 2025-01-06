class Solution:
    def toHex(self, num: int) -> str:
        hexadecimal = "0123456789abcdef"

        if num == 0: return "0"
        if num > 0 and num <= 15: return hexadecimal[num]
        if num < 0: num += 2 ** 32

        result = list()

        while num:
            result.append(hexadecimal[num % 16])
            num //= 16

        return "".join(result[::-1])