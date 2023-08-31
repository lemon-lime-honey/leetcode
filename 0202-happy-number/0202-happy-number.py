class Solution:
    def isHappy(self, n: int) -> bool:
        seen = {n}

        while True:
            res = 0
            while n:
                res += (n % 10) ** 2
                n //= 10
            if res == 1: return True
            if res in seen: return False

            n = res
            seen.add(n)