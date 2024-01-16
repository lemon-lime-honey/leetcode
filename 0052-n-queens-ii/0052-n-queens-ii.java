class Solution {
    private int n;
    private int result;
    private Set<Integer> column;
    private Set<Integer> diag1;
    private Set<Integer> diag2;

    private void backtrack(int row) {
        if (row == n) {
            result++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (column.contains(col) || diag1.contains(row + col) || diag2.contains(row - col)) {
                continue;
            }

            column.add(col);
            diag1.add(row + col);
            diag2.add(row - col);
            backtrack(row + 1);
            diag2.remove(row - col);
            diag1.remove(row + col);
            column.remove(col);
        }
    }

    public int totalNQueens(int n) {
        this.n = n;
        result = 0;
        column = new HashSet<>();
        diag1 = new HashSet<>();
        diag2 = new HashSet<>();

        backtrack(0);
        return result;
    }
}