class Solution:
    def firstCompleteIndex(self, arr: List[int], mat: List[List[int]]) -> int:
        m, n = len(mat), len(mat[0])
        row = [set() for i in range(m)]
        col = [set() for i in range(n)]
        numDict = dict()

        for i in range(m):
            for j in range(n):
                numDict[mat[i][j]] = (i, j)

        for i in range(m * n):
            r, c = numDict[arr[i]]
            row[r].add(c)
            col[c].add(r)
            if len(row[r]) == n or len(col[c]) == m:
                return i

        return 0