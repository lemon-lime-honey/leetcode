class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;

        while (r1 < r2) {
            int mid_r = (r1 + r2) / 2;
            if (matrix[mid_r][0] < target) {
                if (matrix[mid_r][matrix[mid_r].length - 1] >= target) {
                    r2 = mid_r;
                    break;
                }
                r1 = mid_r + 1;
            } else {
                r2 = mid_r;
            }
        }

        while (c1 < c2) {
            int mid_c = (c1 + c2) / 2;
            if (matrix[r2][mid_c] < target) {
                c1 = mid_c + 1;
            } else {
                c2 = mid_c;
            }
        }

        if (matrix[r2][c2] == target) {
            return true;
        }

        return false;
    }
}