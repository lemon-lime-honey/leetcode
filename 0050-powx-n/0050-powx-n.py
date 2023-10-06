class Solution:
    def myPow(self, x: float, n: int) -> float:
        @cache
        def calc(a, p):
            if p == 0: return 1
            if p == 1: return a
            if p == -1: return 1/a

            if p % 2:
                return a * calc(a, p // 2) * calc(a, p // 2)
            return calc(a, p // 2) * calc(a, p // 2)


        return calc(x, n)