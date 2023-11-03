from collections import deque


class Solution:
    def solve(self, board: List[List[str]]) -> None:
        if not board or not board[0]: return
        row, col = len(board), len(board[0])
        if row < 3 or col < 3: return

        dr = [0, 0, -1, 1]
        dc = [1, -1, 0, 0]
        chk = [[False for i in range(col)] for j in range(row)]
        que = deque()

        for i in range(row):
            if board[i][0] == 'O':
                chk[i][0] = True
                que.append((i, 0))
            if board[i][col - 1] == 'O':
                chk[i][col - 1] = True
                que.append((i, col - 1))

        for i in range(col):
            if board[0][i] == 'O':
                chk[0][i] = True
                que.append((0, i))
            if board[row - 1][i] == 'O':
                chk[row - 1][i] = True
                que.append((row - 1, i))

        while que:
            r, c = que.popleft()

            for i in range(4):
                nr, nc = r + dr[i], c + dc[i]
                if (0 <= nr < row and
                    0 <= nc < col and
                    not chk[nr][nc] and
                    board[nr][nc] == 'O'):
                    que.append((nr, nc))
                    chk[nr][nc] = True

        for i in range(1, row - 1):
            for j in range(1, col - 1):
                if board[i][j] == 'O' and not chk[i][j]:
                    board[i][j] = 'X'