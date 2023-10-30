class Solution:
    def totalNQueens(self, n: int) -> int:
        def backtrack(row):
            nonlocal result

            if row == n:
                result += 1
                return

            for col in range(n):
                if (col in column or
                    row + col in diag1 or
                    row - col in diag2):
                    continue

                column.add(col)
                diag1.add(row + col)
                diag2.add(row - col)
                backtrack(row + 1)
                diag2.remove(row - col)
                diag1.remove(row + col)
                column.remove(col)

        column = set()
        diag1 = set()
        diag2 = set()
        result = 0

        backtrack(0)
        return result