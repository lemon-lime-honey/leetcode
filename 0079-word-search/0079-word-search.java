class Solution {
    int[] dr = {1, -1, 0, 0}, dc = {0, 0, -1, 1};
    boolean[][] visited;
    boolean result;

    private boolean search(char[][] board, String word, boolean[][] visited, int r, int c, int idx) {
        if (idx == word.length()) {
            return true;
        }

        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length ||
            visited[r][c] || board[r][c] != word.charAt(idx)) {
                return false;
        }

        visited[r][c] = true;

        if (search(board, word, visited, r + 1, c, idx + 1) ||
            search(board, word, visited, r - 1, c, idx + 1) ||
            search(board, word, visited, r, c + 1, idx + 1) ||
            search(board, word, visited, r, c - 1, idx + 1)) {
            return true;
        }

        visited[r][c] = false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        boolean result = false;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    result = search(board, word, visited, i, j, 0);
                    if (result) return true;
                }
            }
        }

        return false;
    }
}