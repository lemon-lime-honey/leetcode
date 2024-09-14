class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        result = [[0 for i in range(n)] for j in range(n)]
        dr = [0, 1, 0, -1]
        dc = [1, 0, -1, 0]
        seq = 0
        r, c = 0, 0

        for i in range(1, n ** 2 + 1):
            result[r][c] = i
            r += dr[seq]
            c += dc[seq]
            if r < 0 or c < 0 or r >= n or c >= n or result[r][c] != 0:
                r -= dr[seq]
                c -= dc[seq]
                seq = (seq + 1) % 4
                r += dr[seq]
                c += dc[seq]

        return result