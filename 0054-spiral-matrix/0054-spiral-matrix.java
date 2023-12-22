class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] visited = new boolean[row][col];
        List<Integer> result = new ArrayList<>();
        int r = 0;
        int c = 0;
        int d = 0;

        while (true) {
            result.add(matrix[r][c]);
            visited[r][c] = true;
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= row || nc < 0 || nc >= col || visited[nr][nc]) {
                d = (d + 1) % 4;
                nr = r + dr[d];
                nc = c + dc[d];
                if (!(0 <= nr && nr < row) || !(0 <= nc && nc < col) || visited[nr][nc]) {
                    break;
                }
            }

            r = nr;
            c = nc;
        }

        return result;
    }
}