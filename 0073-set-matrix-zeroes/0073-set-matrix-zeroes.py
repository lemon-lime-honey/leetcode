class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        m = len(matrix)
        n = len(matrix[0])
        stack = list()

        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                    stack.append((i, j))

        while stack:
            r, c = stack.pop()
            for i in range(m):
                matrix[i][c] = 0
            for i in range(n):
                matrix[r][i] = 0