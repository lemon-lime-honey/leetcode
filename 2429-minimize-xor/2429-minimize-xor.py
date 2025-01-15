class Solution:
    def minimizeXor(self, num1: int, num2: int) -> int:
        n1, n2 = bin(num1).count("1"), bin(num2).count("1")
        result = num1

        for i in range(32):
            if n1 > n2 and (1 << i) & num1:
                result ^= 1 << i
                n1 -= 1
            if n1 < n2 and (1 << i) & num1 == 0:
                result ^= 1 << i
                n1 += 1

        return result