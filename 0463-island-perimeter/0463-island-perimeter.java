class Solution {
    public int islandPerimeter(int[][] grid) {
        int[] dr = {0, 0, -1, 1};
        int[] dc = {1, -1, 0, 0};
        int n = grid.length, m = grid[0].length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int r = i + dr[k], c = j + dc[k];
                        if (r < 0 || r >= n || c < 0 || c >= m) {
                            cnt++;
                            continue;
                        }
                        if (grid[r][c] == 0) {
                            cnt++;
                        }
                    }
                    result += cnt;
                }
            }
        }

        return result;
    }
}