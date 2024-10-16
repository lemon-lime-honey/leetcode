class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int r1 = 0, r2 = matrix.size() - 1;
        int c1 = 0, c2 = matrix[0].size() - 1;

        while (r1 < r2) {
            int mid = (r1 + r2) / 2;
            if (matrix[mid][0] < target) {
                if (matrix[mid][matrix[mid].size() - 1] >= target) {
                    r2 = mid;
                    break;
                }
                r1 = mid + 1;
            } else {
                r2 = mid;
            }
        }

        while (c1 < c2) {
            int mid = (c1 + c2) / 2;
            if (matrix[r2][mid] < target) {
                c1 = mid + 1;
            } else {
                c2 = mid;
            }
        }

        return matrix[r2][c2] == target;
    }
};