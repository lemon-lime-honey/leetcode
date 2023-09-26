class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        direction = ((0, 1), (1, 0), (0, -1), (-1, 0))
        row, col = len(matrix), len(matrix[0])
        visited = [[False for i in range(col)] for j in range(row)]
        result = list()
        r, c, d = 0, 0, 0

        while True:
            result.append(matrix[r][c])
            visited[r][c] = True

            nr, nc = r + direction[d][0], c + direction[d][1]

            if nr < 0 or nr >= row or nc < 0 or nc >= col or visited[nr][nc]:
                d = (d + 1) % 4
                nr, nc = r + direction[d][0], c + direction[d][1]
                if not (0 <= nr < row) or not (0 <= nc < col) or visited[nr][nc]:
                    break

            r, c = nr, nc

        return result