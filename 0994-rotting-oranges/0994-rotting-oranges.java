class Pair {
    public int r;
    public int c;

    public Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int[] dr = {0, 0, -1, 1};
        int[] dc = {1, -1, 0, 0};

        boolean[][] chk = new boolean[grid.length][grid[0].length];
        Queue<Pair> que = new ArrayDeque<>();
        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    que.add(new Pair(i, j));
                    chk[i][j] = true;
                }
            }
        }

        while (!que.isEmpty()) {
            int n = que.size();
            boolean flag = false;

            for (int i = 0; i < n; i++) {
                int r = que.peek().r, c = que.peek().c;
                que.poll();
                for (int j = 0; j < 4; j++) {
                    int nr = r + dr[j], nc = c + dc[j];
                    if (nr < 0 || nc < 0 ||
                        nr >= grid.length || nc >= grid[0].length ||
                        grid[nr][nc] != 1 || chk[nr][nc]) continue;
                    grid[nr][nc] = 2;
                    que.add(new Pair(nr, nc));
                    chk[nr][nc] = true;
                    flag = true;
                }
            }

            if (flag) result++;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }

        return result;
    }
}