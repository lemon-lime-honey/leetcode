class Node {
    public int r;
    public int c;

    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int[] dr = {0, 0, -1, 1};
        int[] dc = {1, -1, 0, 0};
        int m = grid[0].length;
        int n = grid.length;
        boolean[][] visited = new boolean[n][m];
        Queue<Node> que = new ArrayDeque<>();
        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    visited[i][j] = true;
                    que.add(new Node(i, j));

                    while (!que.isEmpty()) {
                        Node now = que.poll();

                        for (int k = 0; k < 4; k++) {
                            int nr = now.r + dr[k];
                            int nc = now.c + dc[k];
                            if ((0 <= nr && nr < n) && (0 <= nc && nc < m) &&
                                (!visited[nr][nc]) && (grid[nr][nc] == '1')) {
                                visited[nr][nc] = true;
                                que.add(new Node(nr, nc));
                            }
                        }
                    }
                    result++;
                }
            }
        }
        return result;
    }
}