class Solution {
    int[] city;

    private int find(int p) {
        if (city[p] != p) {
            city[p] = find(city[p]);
        }
        return city[p];
    }

    private void union(int p, int q) {
        p = find(p);
        q = find(q);
        if (p == q) {
            return;
        }
        if (p < q) {
            city[q] = p;
        } else {
            city[p] = q;
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        city = new int[n];

        for (int i = 0; i < n; i++) {
            city[i] = i;
        }

        Set<Integer> result = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    int a = find(i);
                    int b = find(j);
                    if (a != b) {
                        union(a, b);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            find(i);
            result.add(city[i]);
        }

        return result.size();
    }
}