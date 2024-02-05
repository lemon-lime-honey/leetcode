class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> row = new HashSet();
        Set<String> col = new HashSet();
        Set<String> square = new HashSet();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    String rowChk = Integer.toString(i) + board[i][j];
                    String colChk = Integer.toString(j) + board[i][j];
                    String sqChk = Integer.toString(i / 3) + Integer.toString(j / 3) + board[i][j];
                    if (row.contains(rowChk) || col.contains(colChk) || square.contains(sqChk)) {
                        return false;
                    }
                    row.add(rowChk);
                    col.add(colChk);
                    square.add(sqChk);
                }
            }
        }

        return true;
    }
}