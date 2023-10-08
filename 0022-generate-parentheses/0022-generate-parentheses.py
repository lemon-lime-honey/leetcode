class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        def generate(lo, hi):
            if len(res) == 2 * n:
                result.append(''.join(res))
                return

            if lo < n:
                res.append('(')
                generate(lo + 1, hi)
                res.pop()

            if hi < lo:
                res.append(')')
                generate(lo, hi + 1)
                res.pop()


        result = list()
        res = list()
        generate(0, 0)

        return result