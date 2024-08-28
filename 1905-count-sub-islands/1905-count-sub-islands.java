class Solution {
    private int result;
    private boolean flag;
    private int[] dr = {0, 0, -1, 1};
    private int[] dc = {1, -1, 0, 0};

    private boolean find(int r, int c, int[][] grid1, int[][] grid2, int n, int m) {
        grid2[r][c] = 0;

        if (grid1[r][c] == 0) {
            flag = false;
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i], nc = c + dc[i];
            if (nr < 0 || nc < 0 || nr >= n || nc >= m || grid2[nr][nc] == 0) {
                continue;
            }
            find(nr, nc, grid1, grid2, n, m);
        }

        return flag;
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length, m = grid1[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid2[i][j] == 1) {
                    flag = true;
                    if (find(i, j, grid1, grid2, n, m)) {
                        result++;
                    }
                }
            }
        }

        return result;
    }
}