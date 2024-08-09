class Solution {
    private boolean square(int r, int c, int[][] grid) {
        Set<Integer> set = new HashSet<>();

        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (grid[i][j] < 1 || grid[i][j] > 9) {
                    return false;
                }
                set.add(grid[i][j]);
            }
        }

        return (set.size() == 9) ? true : false;
    }

    private boolean row(int r, int c, int[][] grid) {
        Set<Integer> set = new HashSet<>();

        for (int i = r; i < r + 3; i++) {
            int sum = 0;
            for (int j = c; j < c + 3; j++) {
                sum += grid[i][j];
            }
            set.add(sum);
        }

        return (set.size() == 1) ? true : false;
    }

    private boolean column(int r, int c, int[][] grid) {
        Set<Integer> set = new HashSet<>();

        for (int i = c; i < c + 3; i++) {
            int sum = 0;
            for (int j = r; j < r + 3; j++) {
                sum += grid[j][i];
            }
            set.add(sum);
        }

        return (set.size() == 1) ? true : false;
    }

    private boolean diagonal(int r, int c, int[][] grid) {
        int left = grid[r][c] + grid[r + 2][c + 2];
        int right = grid[r][c + 2] + grid[r + 2][c];

        return left == right;
    }

    public int numMagicSquaresInside(int[][] grid) {
        int result = 0;

        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                if (square(i, j, grid)
                    && row(i, j, grid)
                    && column(i, j, grid)
                    && diagonal(i, j, grid)) {
                    result++;
                }
            }
        }

        return result;
    }
}