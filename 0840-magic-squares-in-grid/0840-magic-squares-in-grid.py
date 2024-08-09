class Solution:
    def numMagicSquaresInside(self, grid: List[List[int]]) -> int:
        def chk(r, c):
            total = set()

            for i in range(r, r + 3):
                for j in range(c, c + 3):
                    if grid[i][j] not in range(1, 10):
                        return False
                    total.add(grid[i][j])

            if len(total) != 9:
                return False

            total = set()

            for i in range(r, r + 3):
                total.add(sum(grid[i][c : c + 3]))

            if len(total) > 1:
                return False

            total = set()

            for i in range(c, c + 3):
                temp = 0
                for j in range(r, r + 3):
                    temp += grid[j][i]
                total.add(temp)

            if len(total) > 1:
                return False

            if (
                grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2]
                != grid[r][c + 2] + grid[r + 1][c + 1] + grid[r + 2][c]
            ):
                return False

            return True

        result = 0

        for i in range(len(grid) - 2):
            for j in range(len(grid[0]) - 2):
                if chk(i, j):
                    result += 1

        return result
