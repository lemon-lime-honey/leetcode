class Solution:
    def findDiagonalOrder(self, mat: List[List[int]]) -> List[int]:
        diag = defaultdict(list)
        result = list()

        for i in range(len(mat)):
            for j in range(len(mat[0])):
                diag[i + j].append(mat[i][j])

        for key in sorted(diag.keys()):
            if key % 2:
                result.extend(diag[key])
            else:
                result.extend(diag[key][::-1])

        return result
