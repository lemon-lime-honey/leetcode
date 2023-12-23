class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    stack.push(new int[] {i, j});
                }
            }
        }

        while (!stack.empty()) {
            int[] coord = stack.pop();
            for (int i = 0; i < m; i++) {
                matrix[i][coord[1]] = 0;
            }
            for (int i = 0; i < n; i++) {
                matrix[coord[0]][i] = 0;
            }
        }
    }
}