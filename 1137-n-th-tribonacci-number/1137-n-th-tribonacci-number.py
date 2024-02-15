class Solution:
    def tribonacci(self, n: int) -> int:
        if n < 2: return n

        one, two, three = 0, 1, 1

        for i in range(n - 2):
            one, two, three = two, three, one + two + three

        return three