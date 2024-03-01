class Coordinate {
    int r;
    int c;

    public Coordinate(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        Queue<Coordinate> que = new ArrayDeque<>();
        que.add(new Coordinate(entrance[0], entrance[1]));
        int[][] chk = new int[m][n];
        chk[entrance[0]][entrance[1]] = 1;

        int[] dr = {0, 0, -1, 1};
        int[] dc = {1, -1, 0, 0};

        while (!que.isEmpty()) {
            Coordinate now = que.poll();
            int r = now.r;
            int c = now.c;

            if ((r == 0 || c == 0 || r == m - 1 || c == n - 1) &&
                !(r == entrance[0] && c == entrance[1])) {
                return chk[r][c] - 1;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (0 <= nr && nr < m && 0 <= nc && nc < n &&
                    chk[nr][nc] == 0 && maze[nr][nc] == '.') {
                    chk[nr][nc] = chk[r][c] + 1;
                    que.add(new Coordinate(nr, nc));
                }
            }
        }

        return -1;
    }
}