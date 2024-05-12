class Solution {
    public int[][] largestLocal(int[][] grid) {
        int[][] maxLocal = new int[grid.length - 2][grid.length - 2];

        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid.length - 2; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        maxLocal[i][j] = Math.max(maxLocal[i][j], grid[i + k][j + l]);
                    }
                }
            }
        }

        return maxLocal;
    }
}