class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        row = set()
        col = set()
        square = set()

        for i in range(9):
            for j in range(9):
                if board[i][j] != '.':
                    if (((i, board[i][j]) in row) or
                        ((j, board[i][j]) in col) or
                        ((i // 3, j // 3, board[i][j]) in square)):
                        return False
                    row.add((i, board[i][j]))
                    col.add((j, board[i][j]))
                    square.add((i // 3, j // 3, board[i][j]))

        return True