class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int[] dr = {0, 1, 0, -1}, dc = {1, 0, -1, 0};
        int seq = 0, r = 0, c = 0;

        for (int i = 1; i <= n * n; i++) {
            result[r][c] = i;
            r += dr[seq];
            c += dc[seq];
            if (r < 0 || c < 0 || r >= n || c >= n || result[r][c] != 0) {
                r -= dr[seq];
                c -= dc[seq];
                seq = (seq + 1) % 4;
                r += dr[seq];
                c += dc[seq];
            }
        }

        return result;
    }
}