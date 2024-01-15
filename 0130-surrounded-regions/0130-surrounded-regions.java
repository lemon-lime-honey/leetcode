class Coordinates {
    int r;
    int c;

    Coordinates(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Solution {
    public void solve(char[][] board) {
        if (board == null || board[0] == null) {
            return;
        }

        int row = board.length;
        int col = board[0].length;

        if (row < 3 || col < 3) {
            return;
        }

        int[] dr = {0, 0, -1, 1};
        int[] dc = {1, -1, 0, 0};
        boolean[][] chk = new boolean[row][col];
        Queue<Coordinates> que = new ArrayDeque<>();

        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                chk[i][0] = true;
                que.add(new Coordinates(i, 0));
            }
            if (board[i][col - 1] == 'O') {
                chk[i][col - 1] = true;
                que.add(new Coordinates(i, col - 1));
            }
        }

        for (int i = 0; i < col; i++) {
            if (board[0][i] == 'O') {
                chk[0][i] = true;
                que.add(new Coordinates(0, i));
            }
            if (board[row - 1][i] == 'O') {
                chk[row - 1][i] = true;
                que.add(new Coordinates(row - 1, i));
            }
        }

        while (!que.isEmpty()) {
            Coordinates now = que.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                if ((0 <= nr && nr < row) &&
                    (0 <= nc && nc < col) && 
                    (!chk[nr][nc] && board[nr][nc] == 'O')) {
                    que.add(new Coordinates(nr, nc));
                    chk[nr][nc] = true;
                }
            }
        }

        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                if (board[i][j] == 'O' && !chk[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}