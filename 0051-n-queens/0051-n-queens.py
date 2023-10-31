class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        def get(r):
            if r == n:
                result.append(list(route))
                return

            for c in range(n):
                if (c in col or r + c in diag1 or r - c in diag2): continue
                temp = ''

                col.add(c)
                diag1.add(r + c)
                diag2.add(r - c)

                for i in range(n):
                    if i == c: temp += 'Q'
                    else: temp += '.'

                route.append(temp)
                get(r + 1)
                route.pop()

                diag2.remove(r - c)
                diag1.remove(r + c)
                col.remove(c)


        result = list()
        route = list()
        diag1 = set()
        diag2 = set()
        col = set()

        get(0)

        return result