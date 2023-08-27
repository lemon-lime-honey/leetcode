class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        r1, r2 = 0, len(matrix) - 1
        c1, c2 = 0, len(matrix[0]) - 1

        while r1 < r2:
            mid_r = (r1 + r2) // 2
            if matrix[mid_r][0] < target:
                if matrix[mid_r][-1] >= target:
                    r2 = mid_r
                    break
                r1 = mid_r + 1
            else: r2 = mid_r

        while c1 < c2:
            mid_c = (c1 + c2) // 2
            if matrix[r2][mid_c] < target:
                c1 = mid_c + 1
            else: c2 = mid_c

        return True if matrix[r2][c2] == target else False