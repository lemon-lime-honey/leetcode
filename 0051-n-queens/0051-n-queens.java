class Solution {
    private List<List<String>> result;
    private List<String> route;
    private Set<Integer> diag1;
    private Set<Integer> diag2;
    private Set<Integer> col;
    private int n;

    private void get(int r) {
        if (r == n) {
            result.add(new ArrayList<>(route));
            return;
        }

        for (int c = 0; c < n; c++) {
            if (col.contains(c) || diag1.contains(r + c) || diag2.contains(r - c)) {
                continue;
            }

            StringBuilder sb = new StringBuilder();

            col.add(c);
            diag1.add(r + c);
            diag2.add(r - c);

            for (int i = 0; i < n; i++) {
                if (i == c) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }

            route.add(sb.toString());
            get(r + 1);
            route.remove(route.size() - 1);

            diag2.remove(r - c);
            diag1.remove(r + c);
            col.remove(c);
        }
    }

    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        route = new ArrayList<>();
        diag1 = new HashSet<>();
        diag2 = new HashSet<>();
        col = new HashSet<>();
        this.n = n;

        get(0);
        return result;
    }
}