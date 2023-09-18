class Solution:
    def trailingZeroes(self, n: int) -> int:
        if n < 5: return 0

        two, five = 0, 0

        for i in range(2, n + 1):
            if not i % 2 or not i % 5:
                chk = i
                while not (chk % 2 and chk % 5):
                    if not chk % 2:
                        chk //= 2
                        two += 1
                    if not chk % 5:
                        chk //= 5
                        five += 1

        return min(two, five)