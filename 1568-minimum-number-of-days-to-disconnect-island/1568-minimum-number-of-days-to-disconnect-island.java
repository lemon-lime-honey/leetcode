class Pair {
    public int r;
    public int c;

    public Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Solution {
    private void bfs(int row, int col, boolean[][] visited, int[][] grid) {
        Queue<Pair> que = new ArrayDeque<>();
        int[][] mvmt = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        que.add(new Pair(row, col));

        while (!que.isEmpty()) {
            int r = que.peek().r, c = que.peek().c;
            que.poll();
            for (int i = 0; i < 4; i++) {
                int nr = r + mvmt[i][0], nc = c + mvmt[i][1];
                if (nr < 0 || nr >= grid.length
                    || nc < 0 || nc >= grid[0].length
                    || grid[nr][nc] == 0
                    || visited[nr][nc]) {
                    continue;
                }
                visited[nr][nc] = true;
                que.add(new Pair(nr, nc));
            }
        }
    }

    private boolean cntIsle(int[][] grid) {
        boolean[][] chk = new boolean[grid.length][grid[0].length];
        int cnt = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !chk[i][j]) {
                    bfs(i, j, chk, grid);
                    cnt++;
                }
            }
        }

        return cnt != 1;
    }

    public int minDays(int[][] grid) {
        if (cntIsle(grid)) return 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (cntIsle(grid)) return 1;
                    grid[i][j] = 1;
                }
            }
        }

        return 2;
    }
}