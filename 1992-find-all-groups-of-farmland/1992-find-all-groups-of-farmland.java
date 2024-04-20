class Pair {
    int r;
    int c;

    public Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class PairComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair o1, Pair o2) {
        if (o1.r < o2.r) {
            return -1;
        } else if (o1.r == o2.r) {
            if (o1.c < o2.c) {
                return -1;
            } else if (o1.c == o2.c) {
                return 0;
            }
        }
        return 1;
    }
}

class Solution {
    public int[][] findFarmland(int[][] land) {
        int n = land.length, m = land[0].length;
        List<int[]> res = new ArrayList<>();
        boolean[][] visited = new boolean[n][m];

        int[] dr = {0, 0, -1, 1};
        int[] dc = {1, -1, 0, 0};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    Queue<Pair> que = new ArrayDeque<>();
                    List<Pair> points = new ArrayList<>();
                    Pair init = new Pair(i, j);
                    visited[i][j] = true;
                    que.add(init);
                    points.add(init);

                    while (!que.isEmpty()) {
                        int r = que.peek().r, c = que.peek().c;
                        que.poll();
                        for (int k = 0; k < 4; k++) {
                            int nr = r + dr[k], nc = c + dc[k];
                            if (nr < 0 || nr >= n ||
                                nc < 0 || nc >= m ||
                                visited[nr][nc] ||
                                land[nr][nc] == 0) {
                                    continue;
                                }
                            visited[nr][nc] = true;
                            Pair target = new Pair(nr, nc);
                            points.add(target);
                            que.add(target);
                        }
                    }

                    Collections.sort(points, new PairComparator());

                    int[] temp = new int[4];
                    temp[0] = points.get(0).r;
                    temp[1] = points.get(0).c;
                    temp[2] = points.get(points.size() - 1).r;                    
                    temp[3] = points.get(points.size() - 1).c;                    

                    res.add(temp);
                }
            }
        }

        return res.toArray(new int[res.size()][4]);
    }
}