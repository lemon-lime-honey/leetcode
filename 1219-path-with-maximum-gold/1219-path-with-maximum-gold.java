class Solution {
    private int result;
    private boolean[][] chk;
    private int[] dr = {0, 0, -1, 1};
    private int[] dc = {1, -1, 0, 0};

    private void backtrack(int r, int c, int total, int[][] grid) {
        result = Math.max(result, total);
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i], nc = c + dc[i];
            if (nr < 0 || grid.length <= nr ||
                nc < 0 || grid[0].length <= nc ||
                chk[nr][nc] || grid[nr][nc] == 0) continue;
            chk[nr][nc] = true;
            backtrack(nr, nc, total + grid[nr][nc], grid);
            chk[nr][nc] = false;
        }
    }

    public int getMaximumGold(int[][] grid) {
        result = 0;
        chk = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    chk[i][j] = true;
                    backtrack(i, j, grid[i][j], grid);
                    chk[i][j] = false;
                }
            }
        }

        return result;
    }
}