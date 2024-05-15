class Data implements Comparable<Data> {
    public int num;
    public int r;
    public int c;

    public Data(int num, int r, int c) {
        this.num = num;
        this.r = r;
        this.c = c;
    }

    @Override
    public int compareTo(Data d) {
        return this.num <= d.num ? 1 : -1;
    }
}

class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) return 0;

        int[][] maps = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maps[i][j] = Integer.MAX_VALUE;
            }
        }

        int[] dr = {0, 0, -1, 1};
        int[] dc = {1, -1, 0, 0};
        Queue<Data> que = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    que.add(new Data(0, i, j));
                    maps[i][j] = 0;
                }
            }
        }

        while (!que.isEmpty()) {
            int num = que.peek().num, r = que.peek().r, c = que.peek().c;
            que.poll();
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (nr < 0 || nr >= n || nc < 0 || nc >= n || maps[nr][nc] <= num + 1) continue;
                maps[nr][nc] = num + 1;
                que.add(new Data(maps[nr][nc], nr, nc));
            }
        }

        boolean[][] chk = new boolean[n][n];
        PriorityQueue<Data> pQue = new PriorityQueue<>();
        pQue.add(new Data(maps[0][0], 0, 0));
        chk[0][0] = true;

        while (!pQue.isEmpty()) {
            int dist = pQue.peek().num, r = pQue.peek().r, c = pQue.peek().c;
            pQue.poll();
            if (r == n - 1 && c == n - 1) return dist;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (nr < 0 || nr >= n || nc < 0 || nc >= n || chk[nr][nc]) continue;
                pQue.add(new Data(Math.min(dist, maps[nr][nc]), nr, nc));
                chk[nr][nc] = true;
            }
        }

        return -1;
    }
}