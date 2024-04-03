class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        def search(r, c, idx):
            if idx == len(word):
                return True

            if (r < 0 or r >= n or c < 0 or c >= m or
                visited[r][c] or board[r][c] != word[idx]):
                return False

            visited[r][c] = True

            if (search(r + 1, c, idx + 1) or
                search(r - 1, c, idx + 1) or
                search(r, c + 1, idx + 1) or
                search(r, c - 1, idx + 1)):
                return True

            visited[r][c] = False
            return False


        n, m = len(board), len(board[0])
        visited = [[False for i in range(m)] for j in range(n)]
        result = False

        for i in range(n):
            for j in range(m):
                if board[i][j] == word[0]:
                    result = search(i, j, 0)
                    if result: return True

        return False